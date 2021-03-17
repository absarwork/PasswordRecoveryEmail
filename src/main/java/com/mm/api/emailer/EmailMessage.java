/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mm.api.emailer;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Adeel.Asghar
 */
@Data
@ToString
public class EmailMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    private String recipients;
    private List<String> recipientsMulti = new ArrayList<>();
    private String cc;
    private String subject;
    private String fromEmail;
    private String fromName;
    private Map<String, String> bodyMap;
    private String emailTemplateName;
    private String category;
    private String sandGridKey;
    private String htmlTemplate;
    private String redirectUrl;
    private String logoUrl;
    private String senderFirstName;
    private String senderLastName;

}
