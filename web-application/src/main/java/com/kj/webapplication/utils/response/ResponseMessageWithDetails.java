package com.kj.webapplication.utils.response;

import com.kj.webapplication.utils.enums.ResponseType;

import java.util.Map;

public class ResponseMessageWithDetails<T> extends ResponseMessage {
    private T details;

    public ResponseMessageWithDetails(ResponseType responseType, String msgCode, String text, T details) {
        super(responseType, msgCode, text, (Map)null);
        this.details = details;
    }

    private ResponseMessageWithDetails() {
    }

    public T getDetails() {
        return details;
    }

    public void setDetails(T details) {
        this.details = details;
    }
}

