package com.kj.webapplication.utils.model;

import com.kj.webapplication.models.Price;
import com.kj.webapplication.utils.details.PriceDetails;

public class PriceUtils {
    public static PriceDetails toDetails(Price entity) {
        if(entity != null) {
            return new PriceDetails(entity.getAmount(), entity.getCurrency());
        }
        else {
            return null;
        }
    }

    public static Price toEntity(PriceDetails details) {
        if(details != null) {
            return new Price(null, details.getAmount(), details.getCurrency());
        }
        else {
            return null;
        }
    }
}
