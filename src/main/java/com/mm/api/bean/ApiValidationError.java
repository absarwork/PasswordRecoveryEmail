package com.mm.api.bean;

import com.google.gson.Gson;

public class ApiValidationError extends ApiSubError {

    private String object; // class
    private String field; // class-field
    private Object rejectedValue; // class-field-value
    private String message; // reject by resone message

    public ApiValidationError() { }

    public ApiValidationError(String object, String message) {
        this.setObject(object);
        this.setMessage(message);
    }

    public ApiValidationError(String object, String field, Object rejectedValue, String message) {
        this.setObject(object);
        this.setField(field);
        this.setRejectedValue(rejectedValue);
        this.setMessage(message);
    }

    public String getObject() { return object; }
    public void setObject(String object) { this.object = object; }

    public String getField() { return field; }
    public void setField(String field) { this.field = field; }

    public Object getRejectedValue() { return rejectedValue; }
    public void setRejectedValue(Object rejectedValue) { this.rejectedValue = rejectedValue; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }


    @Override
    public String toString() { return new Gson().toJson(this); }

}
