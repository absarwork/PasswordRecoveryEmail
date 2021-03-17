package com.mm.api.emailer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mm.api.bean.ApiConstants;
import com.mm.api.bean.ResponseDTO;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 *
 * @author adeel.asghar
 */
@Slf4j
public class Emailer {

    public ResponseDTO sendEmail(final EmailMessage emailMessage) throws Exception {
        try {
            return sendBasicEmail(emailMessage);
        } catch (Exception e) {
            log.error(e.getClass().getName(), e);
            return new ResponseDTO(500, null, null, false, e.getMessage());
        }
    }

    public ResponseDTO sendBasicEmail(final EmailMessage msg) throws Exception {

        try {
            Email from = new Email(msg.getFromEmail(), msg.getFromName());
            String subject = msg.getSubject();
            Email to = new Email(msg.getRecipients());
            Content content = new Content("text/html", msg.getHtmlTemplate());
            Mail mail = new Mail(from, subject, to, content);
            if (null != msg.getCategory()) {
                if (!msg.getCategory().isEmpty()) {
                    mail.addCategory(msg.getCategory());
                }
            }
            SendGrid sg = new SendGrid(msg.getSandGridKey());
            Request request = new Request();

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            if (null != msg.getCategory()) {
                if (!msg.getCategory().isEmpty()) {
                    request.addHeader("category", msg.getCategory());
                }
            }
            Response response = sg.api(request);

            log.info("________________Success_________________");
            log.info(">>>>>> Status Code: " + response.getStatusCode());
            log.info(">>>>>> Status Body: " + response.getBody());
            log.info(">>>>>> Sender Email: " + msg.getFromEmail());
            log.info(">>>>>> Request Email: " + msg.getRecipients());
            log.info(">>>>>> Status: " +msg.getRedirectUrl());
            log.info(">>>>>> Date: " +new Date());
            log.info("_______________________________________");
            return new ResponseDTO(response.getStatusCode(), response.getBody(), response.getHeaders(), true, ApiConstants.SUCCESS_MSG);
        } catch (Exception ex) {
            log.info("________________Exception_________________");
            log.info(">>>>>> Sender Email: " + msg.getFromEmail());
            log.info(">>>>>> Request Email: " + msg.getRecipients());
            log.info(">>>>>> Status: " +msg.getRedirectUrl());
            log.info(">>>>>> Date: " +new Date());
            log.info("__________________________________________");
            log.error(ex.getClass().getName(), ex);
            return new ResponseDTO(500, null, null, false, ex.getMessage());
        }
    }
}
