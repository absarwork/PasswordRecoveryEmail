package com.mm.api.bean;


/**
 * Error code or response code that will be sent in API response to cleint
 *
 * @author Muzaffar.ali
 */
public enum ApiCode {

    // API Success
    SUCCESS,
    // API Error
    ERROR,
    DELETED,
    INVALID_CREDENTIAL,
    UNREGISTERED_EMAIL,
    INACTIVE_USER,
    INVALID_VERIFICATION_TOKEN,
    EMAIL_VALIDATION_TIME,
    VERIFICATION_TOKEN_CONSUMED,
    INVALID_VERIFICATION_PASSWORD,
    PASSWORD_UNSCURE,
    DUPLICATE_EMAIL,
    DUPLICATE_CAMPAIGN_NAME,
    DUPLICATE_COMPANY_NAME,
    DUPLICATE_RECORD,
    // API Field Vallidation error
    VALIDATION_ERROR,
    // HTTP Bad Request
    HTTP_400,
    // INVALID ID
    INVALID_ID,
    // Internal Server error
    HTTP_500,

    ALREADY_CONSUMED,
    // Non Found
    HTTP_404;

}