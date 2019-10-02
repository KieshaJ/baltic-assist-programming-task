--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 11.5

-- Started on 2019-10-02 12:21:13

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2884 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 17118)
-- Name: course; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course (
    id uuid NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    enrolment_count integer,
    title character varying(255) NOT NULL,
    price_id uuid NOT NULL
);


ALTER TABLE public.course OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 17123)
-- Name: course_enrolments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_enrolments (
    course_id uuid NOT NULL,
    enrolments_id uuid NOT NULL
);


ALTER TABLE public.course_enrolments OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 17126)
-- Name: course_modules; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_modules (
    course_id uuid NOT NULL,
    modules_id uuid NOT NULL
);


ALTER TABLE public.course_modules OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 17129)
-- Name: enrolment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enrolment (
    id uuid NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    course_id uuid,
    student_id uuid
);


ALTER TABLE public.enrolment OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 17134)
-- Name: lesson; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lesson (
    id uuid NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    content character varying(255),
    order_number integer,
    title character varying(255)
);


ALTER TABLE public.lesson OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 17142)
-- Name: module; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.module (
    id uuid NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    order_number integer
);


ALTER TABLE public.module OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 17147)
-- Name: module_lessons; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.module_lessons (
    module_id uuid NOT NULL,
    lessons_id uuid NOT NULL
);


ALTER TABLE public.module_lessons OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 17150)
-- Name: price; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.price (
    id uuid NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    amount double precision NOT NULL,
    currency integer NOT NULL
);


ALTER TABLE public.price OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 17155)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    id uuid NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 17160)
-- Name: student_enrolments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student_enrolments (
    student_id uuid NOT NULL,
    enrolments_id uuid NOT NULL
);


ALTER TABLE public.student_enrolments OWNER TO postgres;

--
-- TOC entry 2722 (class 2606 OID 17122)
-- Name: course course_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);


--
-- TOC entry 2730 (class 2606 OID 17133)
-- Name: enrolment enrolment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrolment
    ADD CONSTRAINT enrolment_pkey PRIMARY KEY (id);


--
-- TOC entry 2734 (class 2606 OID 17141)
-- Name: lesson lesson_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lesson
    ADD CONSTRAINT lesson_pkey PRIMARY KEY (id);


--
-- TOC entry 2736 (class 2606 OID 17146)
-- Name: module module_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.module
    ADD CONSTRAINT module_pkey PRIMARY KEY (id);


--
-- TOC entry 2740 (class 2606 OID 17154)
-- Name: price price_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.price
    ADD CONSTRAINT price_pkey PRIMARY KEY (id);


--
-- TOC entry 2742 (class 2606 OID 17159)
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


--
-- TOC entry 2738 (class 2606 OID 17172)
-- Name: module_lessons uk_429n03345fnw4siu4wlhkglac; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.module_lessons
    ADD CONSTRAINT uk_429n03345fnw4siu4wlhkglac UNIQUE (lessons_id);


--
-- TOC entry 2746 (class 2606 OID 17176)
-- Name: student_enrolments uk_4mv4duruoy704leua1hx8yxos; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_enrolments
    ADD CONSTRAINT uk_4mv4duruoy704leua1hx8yxos UNIQUE (enrolments_id);


--
-- TOC entry 2728 (class 2606 OID 17168)
-- Name: course_modules uk_65atknawguv1oleqbww05c3a5; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_modules
    ADD CONSTRAINT uk_65atknawguv1oleqbww05c3a5 UNIQUE (modules_id);


--
-- TOC entry 2726 (class 2606 OID 17166)
-- Name: course_enrolments uk_68r79teg49wgubrscpoifolcm; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_enrolments
    ADD CONSTRAINT uk_68r79teg49wgubrscpoifolcm UNIQUE (enrolments_id);


--
-- TOC entry 2744 (class 2606 OID 17174)
-- Name: student uk_7pb8owoegbhhcrpopw4o1ykcr; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT uk_7pb8owoegbhhcrpopw4o1ykcr UNIQUE (name);


--
-- TOC entry 2724 (class 2606 OID 17164)
-- Name: course uk_msgoex7rold2eqqf1cllhk02i; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT uk_msgoex7rold2eqqf1cllhk02i UNIQUE (title);


--
-- TOC entry 2732 (class 2606 OID 17170)
-- Name: enrolment ukphl2mwi4s3ik50i529ab065l7; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrolment
    ADD CONSTRAINT ukphl2mwi4s3ik50i529ab065l7 UNIQUE (student_id, course_id);


--
-- TOC entry 2750 (class 2606 OID 17192)
-- Name: course_modules fk2kd9ath0mf6p3habbdwnwxi94; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_modules
    ADD CONSTRAINT fk2kd9ath0mf6p3habbdwnwxi94 FOREIGN KEY (modules_id) REFERENCES public.module(id);


--
-- TOC entry 2747 (class 2606 OID 17177)
-- Name: course fk5y9pvohlviyiq110ac1vok62a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT fk5y9pvohlviyiq110ac1vok62a FOREIGN KEY (price_id) REFERENCES public.price(id);


--
-- TOC entry 2756 (class 2606 OID 17222)
-- Name: student_enrolments fkdl6ieex3e4rre2rtkxeh3jef8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_enrolments
    ADD CONSTRAINT fkdl6ieex3e4rre2rtkxeh3jef8 FOREIGN KEY (enrolments_id) REFERENCES public.enrolment(id);


--
-- TOC entry 2755 (class 2606 OID 17217)
-- Name: module_lessons fkfkuen3gu231ce1wp4urhdxjul; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.module_lessons
    ADD CONSTRAINT fkfkuen3gu231ce1wp4urhdxjul FOREIGN KEY (module_id) REFERENCES public.module(id);


--
-- TOC entry 2757 (class 2606 OID 17227)
-- Name: student_enrolments fkgk4tvje0bu0yk0j4d1ftf58op; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_enrolments
    ADD CONSTRAINT fkgk4tvje0bu0yk0j4d1ftf58op FOREIGN KEY (student_id) REFERENCES public.student(id);


--
-- TOC entry 2749 (class 2606 OID 17187)
-- Name: course_enrolments fklf87xvd6gta08kny6k5qmfjb9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_enrolments
    ADD CONSTRAINT fklf87xvd6gta08kny6k5qmfjb9 FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- TOC entry 2751 (class 2606 OID 17197)
-- Name: course_modules fklr5ysf9t0n6t7mfjs73qvrk7u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_modules
    ADD CONSTRAINT fklr5ysf9t0n6t7mfjs73qvrk7u FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- TOC entry 2748 (class 2606 OID 17182)
-- Name: course_enrolments fkni4lak7n95xe2r3u9edrn67ax; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_enrolments
    ADD CONSTRAINT fkni4lak7n95xe2r3u9edrn67ax FOREIGN KEY (enrolments_id) REFERENCES public.enrolment(id);


--
-- TOC entry 2752 (class 2606 OID 17202)
-- Name: enrolment fkqnrv6xltxnx61nfjoe2sngny4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrolment
    ADD CONSTRAINT fkqnrv6xltxnx61nfjoe2sngny4 FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- TOC entry 2753 (class 2606 OID 17207)
-- Name: enrolment fkquem30hnspsnegde2q2bhvou; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrolment
    ADD CONSTRAINT fkquem30hnspsnegde2q2bhvou FOREIGN KEY (student_id) REFERENCES public.student(id);


--
-- TOC entry 2754 (class 2606 OID 17212)
-- Name: module_lessons fkuyqgfpbkv4ocuwjw01o131os; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.module_lessons
    ADD CONSTRAINT fkuyqgfpbkv4ocuwjw01o131os FOREIGN KEY (lessons_id) REFERENCES public.lesson(id);


-- Completed on 2019-10-02 12:21:13

--
-- PostgreSQL database dump complete
--

