package com.mm.api.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.CUSTOM, property = "error", visible = true)
@JsonTypeIdResolver(LowerCaseClassNameResolver.class)
public class ApiError {

    private String url;
    private String profileType; //==> Staging || Production
    private String serviceType; //==> Controller || Service Name
    private String methodName; // ==> XYZ
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<ApiSubError> subErrors;

    public ApiError() {
        this.setTimestamp(LocalDateTime.now());
    }

    public ApiError(HttpStatus status) {
        this();
        this.setStatus(status);
    }

    public ApiError(HttpStatus status, Throwable ex) {
        this();
        this.setStatus(status);
        this.setMessage(message);
        this.setDebugMessage(ex.toString());
    }

    public ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.setStatus(status);
        this.setMessage(message);
        this.setDebugMessage(ex.toString());
    }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getProfileType() { return profileType; }
    public void setProfileType(String profileType) { this.profileType = profileType; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public String getMethodName() { return methodName; }
    public void setMethodName(String methodName) { this.methodName = methodName; }

    public HttpStatus getStatus() { return status; }
    public void setStatus(HttpStatus status) { this.status = status; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getDebugMessage() { return debugMessage; }
    public void setDebugMessage(String debugMessage) { this.debugMessage = debugMessage; }


    public List<ApiSubError> getSubErrors() { return subErrors; }
    public void setSubErrors(List<ApiSubError> subErrors) { this.subErrors = subErrors; }


    // error adding point
    private void addSubError(ApiSubError subError) {
        if(this.getSubErrors() == null) { this.setSubErrors(new ArrayList<>()); }
        this.getSubErrors().add(subError);
    }

    /**
     * Note:- handle this validation error for object field wrong related
     * */
    // # 3
    public void addValidationError(String object, String field, Object rejectedValue, String message) {
        this.addSubError(new ApiValidationError(object, field, rejectedValue, message));
    }
    // # 2
    public void addValidationError(FieldError fieldError) {
        this.addValidationError(fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage());
    }
    // # 1
    public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }

    /**
     * Note:- handle this validation error for object name wrong related
     * */
    // # 3
    public void addValidationError(String object , String message) { this.addSubError(new ApiValidationError(object, message)); }

    // # 2
    public void addValidationError(ObjectError objectError) { this.addValidationError(objectError.getObjectName(), objectError.getDefaultMessage()); }

    // # 1
    public void addValidationError(List<ObjectError> globalErrors) { globalErrors.forEach(this::addValidationError); }


    @Override
    public String toString() { return new Gson().toJson(this); }

}
