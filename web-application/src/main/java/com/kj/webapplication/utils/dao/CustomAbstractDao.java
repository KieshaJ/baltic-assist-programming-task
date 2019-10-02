package com.kj.webapplication.utils.dao;

import org.hibernate.query.criteria.internal.OrderImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;
import java.util.*;

public abstract class CustomAbstractDao<T> {
    @PersistenceContext
    protected EntityManager entityManager;

    public CustomAbstractDao() {}

    public static String like(String value, boolean leftWildcard, boolean rightWildcard) {
        return (leftWildcard ? "%" : "") + value + (rightWildcard ? "%" : "");
    }

    public static String like(String value) {
        return like(value, true, true);
    }

    public static Path<Object> getOrderBy(String orderByString, Root root) {
        Path orderBy;
        if (orderByString != null) {
            orderBy = root.get(orderByString);
        } else {
            orderBy = null;
        }

        return orderBy;
    }

    protected long getTotalElements(CriteriaQuery criteriaQuery, Root root) {
        Selection oldSelection = criteriaQuery.getSelection();
        List oldOrder = criteriaQuery.getOrderList();
        criteriaQuery.select(this.entityManager.getCriteriaBuilder().count(root));
        criteriaQuery.orderBy(Collections.emptyList());
        long totalElements = (Long)this.entityManager.createQuery(criteriaQuery).getSingleResult();
        criteriaQuery.select(oldSelection);
        criteriaQuery.orderBy(oldOrder);
        return totalElements;
    }

    protected List<T> getResults(CriteriaQuery criteriaQuery, Root root, List<Predicate> predicates, List<Order> orderList) {
        criteriaQuery.where((Predicate[])predicates.toArray(new Predicate[0]));
        this.prepareOrder(criteriaQuery, orderList, root, (Pageable)null);
        TypedQuery<T> query = this.entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    protected void likeStrings(List<Predicate> predicateList, Path<String> path, String value, boolean lowerCase) {
        if (!StringUtils.isEmpty(value)) {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            likeStrings(builder, predicateList, path, value, lowerCase);
        }

    }

    protected static void likeStrings(CriteriaBuilder builder, List<Predicate> predicateList, Path<String> path, String value, boolean lowerCase) {
        if (!StringUtils.isEmpty(value)) {
            Predicate predicate = builder.like((Expression)(lowerCase ? builder.lower(path) : path), lowerCase ? like(value.toLowerCase()) : like(value));
            predicateList.add(predicate);
        }

    }

    protected <Y> void equalValues(List<Predicate> criteriaList, Path<Y> yPath, Y object) {
        if (object != null) {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            equalValues(builder, criteriaList, yPath, object);
        }

    }

    protected static void equalValues(CriteriaBuilder builder, List<Predicate> criteriaList, Path<? extends Object> yPath, Object object) {
        if (object != null) {
            criteriaList.add(builder.equal(yPath, object));
        }

    }

    protected <Y> void notEqualValues(List<Predicate> criteriaList, Path<Y> yPath, Y object) {
        if (object != null) {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            notEqualValues(builder, criteriaList, yPath, object);
        }

    }

    protected static void notEqualValues(CriteriaBuilder builder, List<Predicate> criteriaList, Path<? extends Object> yPath, Object object) {
        if (object != null) {
            criteriaList.add(builder.notEqual(yPath, object));
        }

    }

    protected static <T extends Comparable> void greaterThan(CriteriaBuilder builder, List<Predicate> criteriaList, Path<T> yPath, T object) {
        if (object != null) {
            criteriaList.add(builder.greaterThan(yPath, object));
        }

    }

    protected static <T extends Comparable> void greaterThanOrEqualTo(CriteriaBuilder builder, List<Predicate> criteriaList, Path<T> yPath, T object) {
        if (object != null) {
            criteriaList.add(builder.greaterThanOrEqualTo(yPath, object));
        }

    }

    protected static <T extends Comparable> void lessThan(CriteriaBuilder builder, List<Predicate> criteriaList, Path<T> yPath, T object) {
        if (object != null) {
            criteriaList.add(builder.lessThan(yPath, object));
        }

    }

    protected static <T extends Comparable> void lessThanOrEqualTo(CriteriaBuilder builder, List<Predicate> criteriaList, Path<T> yPath, T object) {
        if (object != null) {
            criteriaList.add(builder.lessThanOrEqualTo(yPath, object));
        }

    }

    protected static <T extends Comparable> void in(List<Predicate> criteriaList, Path<T> yPath, Collection<T> objectsCollection) {
        if (objectsCollection != null && !objectsCollection.isEmpty()) {
            criteriaList.add(yPath.in(objectsCollection));
        }

    }

    protected Page<T> getPageResults(CriteriaQuery criteriaQuery, Root root, List<Predicate> predicates, List<Order> orderList, Pageable pageable, boolean calculateTotal) {
        return this.getPageResults(criteriaQuery, root, predicates, orderList, pageable, calculateTotal, (EntityGraph)null);
    }

    protected Page<T> getPageResults(CriteriaQuery criteriaQuery, Root root, List<Predicate> predicates, List<Order> orderList, Pageable pageable, boolean calculateTotal, EntityGraph entityGraph) {
        criteriaQuery.where((Predicate[])predicates.toArray(new Predicate[0]));
        this.prepareOrder(criteriaQuery, orderList, root, pageable);
        long totalElements = calculateTotal ? this.getTotalElements(criteriaQuery, root) : 0L;
        TypedQuery<T> query = this.entityManager.createQuery(criteriaQuery);
        if (entityGraph != null) {
            query.setHint("javax.persistence.loadgraph", entityGraph);
        }

        query.setMaxResults(pageable.getPageSize()).setFirstResult((int)pageable.getOffset());
        List<T> resultList = query.getResultList();
        return new PageImpl(resultList, pageable, totalElements);
    }

    private void prepareOrder(CriteriaQuery criteriaQuery, List<Order> list, Root root, Pageable pageable) {
        List<Order> orderList = new ArrayList();
        if (list != null) {
            orderList.addAll(list);
        }

        if (pageable != null) {
            Sort sort = pageable.getSort();
            if (sort != null) {
                Iterator iterator = sort.iterator();

                while(iterator.hasNext()) {
                    org.springframework.data.domain.Sort.Order order = (org.springframework.data.domain.Sort.Order)iterator.next();
                    Path<Object> orderBy = getOrderBy(order.getProperty(), root);
                    if (orderBy != null) {
                        orderList.add(new OrderImpl(orderBy, order.getDirection().equals(Sort.Direction.ASC)));
                    }
                }
            }
        }

        criteriaQuery.orderBy((Order[])orderList.toArray(new Order[0]));
    }

    public class CustomQuery<Q extends T> {
        public CriteriaBuilder criteriaBuilder;
        public CriteriaQuery<Q> criteriaQuery;
        public Root<Q> root;
        public List<Predicate> predicateList = new ArrayList();
        private List<Order> orderList = new ArrayList();

        public CustomQuery(Class<Q> entityClass) {
            this.criteriaBuilder = CustomAbstractDao.this.entityManager.getCriteriaBuilder();
            this.criteriaQuery = this.criteriaBuilder.createQuery(entityClass);
            this.root = this.criteriaQuery.from(entityClass);
        }

        public <Y> CustomQuery equalValues(Path<Y> yPath, Y object) {
            CustomAbstractDao.equalValues(this.criteriaBuilder, this.predicateList, yPath, object);
            return this;
        }

        public <Y> CustomAbstractDao.CustomQuery equalValues(SingularAttribute<Q, Y> singularAttribute, Y object) {
            return this.equalValues(this.root.get(singularAttribute), object);
        }

        public <Y> CustomAbstractDao.CustomQuery notEqualValues(Path<Y> yPath, Y object) {
            CustomAbstractDao.notEqualValues(this.criteriaBuilder, this.predicateList, yPath, object);
            return this;
        }

        public <Y> CustomAbstractDao.CustomQuery notEqualValues(SingularAttribute<Q, Y> singularAttribute, Y object) {
            return this.notEqualValues(this.root.get(singularAttribute), object);
        }

        public CustomAbstractDao.CustomQuery likeStrings(Path<String> path, String value, boolean lowerCase) {
            CustomAbstractDao.likeStrings(this.criteriaBuilder, this.predicateList, path, value, lowerCase);
            return this;
        }

        public CustomAbstractDao.CustomQuery likeStrings(SingularAttribute<Q, String> singularAttribute, String value, boolean lowerCase) {
            return this.likeStrings(this.root.get(singularAttribute), value, lowerCase);
        }

        public <Y extends Comparable> CustomAbstractDao.CustomQuery greaterThan(Path<Y> yPath, Y object) {
            CustomAbstractDao.greaterThan(this.criteriaBuilder, this.predicateList, yPath, object);
            return this;
        }

        public <Y extends Comparable> CustomAbstractDao.CustomQuery greaterThan(SingularAttribute<Q, Y> singularAttribute, Y object) {
            return this.greaterThan(this.root.get(singularAttribute), object);
        }

        public <Y extends Comparable> CustomAbstractDao.CustomQuery greaterThanOrEqualTo(Path<Y> yPath, Y object) {
            CustomAbstractDao.greaterThanOrEqualTo(this.criteriaBuilder, this.predicateList, yPath, object);
            return this;
        }

        public <Y extends Comparable> CustomAbstractDao.CustomQuery greaterThanOrEqualTo(SingularAttribute<Q, Y> singularAttribute, Y object) {
            return this.greaterThanOrEqualTo(this.root.get(singularAttribute), object);
        }

        public <Y extends Comparable> CustomAbstractDao.CustomQuery lessThan(Path<Y> yPath, Y object) {
            CustomAbstractDao.lessThan(this.criteriaBuilder, this.predicateList, yPath, object);
            return this;
        }

        public <Y extends Comparable> CustomAbstractDao.CustomQuery lessThan(SingularAttribute<Q, Y> singularAttribute, Y object) {
            return this.lessThan(this.root.get(singularAttribute), object);
        }

        public <Y extends Comparable> CustomAbstractDao.CustomQuery lessThanOrEqualTo(Path<Y> yPath, Y object) {
            CustomAbstractDao.lessThanOrEqualTo(this.criteriaBuilder, this.predicateList, yPath, object);
            return this;
        }

        public <Y extends Comparable> CustomAbstractDao.CustomQuery lessThanOrEqualTo(SingularAttribute<Q, Y> singularAttribute, Y object) {
            return this.lessThanOrEqualTo(this.root.get(singularAttribute), object);
        }

        public <Y extends Comparable> CustomAbstractDao.CustomQuery in(Path<Y> yPath, Collection<Y> objectsCollection) {
            CustomAbstractDao.in(this.predicateList, yPath, objectsCollection);
            return this;
        }

        public <Y extends Comparable> CustomAbstractDao.CustomQuery in(SingularAttribute<Q, Y> singularAttribute, Collection<Y> objectsCollection) {
            return this.in(this.root.get(singularAttribute), objectsCollection);
        }

        public CustomAbstractDao.CustomQuery addOrder(Order order) {
            this.orderList.add(order);
            return this;
        }

        public Page<T> getPageResult(Pageable pageable) {
            return this.getPageResult(pageable, true);
        }

        public Page<T> getPageResult(Pageable pageable, boolean calculateTotal) {
            return this.getPageResult(pageable, calculateTotal, (EntityGraph)null);
        }

        public Page<T> getPageResult(Pageable pageable, boolean calculateTotal, EntityGraph entityGraph) {
            return CustomAbstractDao.this.getPageResults(this.criteriaQuery, this.root, this.predicateList, this.orderList, pageable, calculateTotal, entityGraph);
        }

        public List<T> getResult() {
            return CustomAbstractDao.this.getResults(this.criteriaQuery, this.root, this.predicateList, this.orderList);
        }
    }
}
