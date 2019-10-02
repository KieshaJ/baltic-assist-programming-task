package com.kj.webapplication.utils.response;

import com.kj.webapplication.utils.enums.ResponseType;

import java.io.Serializable;
import java.util.Map;

public class ResponseMessage implements Serializable {
    private ResponseType responseType;
    private String msgCode;
    private String text;
    private Map<String, String> errorMap;

    public ResponseMessage() {
    }

    public ResponseMessage(ResponseType responseType, String msgCode, String text, Map<String, String> errorMap) {
        this.responseType = responseType;
        this.msgCode = msgCode;
        this.text = text;
        this.errorMap = errorMap;
    }

    public void setType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public void setText(String text) {
        if (text == null) {
            this.text = "";
        }

        this.text = text;
    }

    public String getText() {
        return text;
    }

    public ResponseType getType() {
        return responseType;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }
}
