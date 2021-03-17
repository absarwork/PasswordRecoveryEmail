package com.mm.api.bean;


import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Adeel.Asghar
 */

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    Object statusCode;
    Object body ;
    Object headers;
    Boolean isSuccess = true;
    String  message;

}
