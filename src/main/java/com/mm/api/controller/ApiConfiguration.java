package com.mm.api.controller;

import com.mm.api.bean.ResponseDTO;
import com.mm.api.emailer.EmailMessage;
import com.mm.api.emailer.EmailMessagesFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ApiConfiguration {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Autowired
    EmailMessagesFactory emailService;

    @PostMapping("/sendVerificationEmail")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO sendVerificationEmail(@RequestHeader(value = "authorization", required = true) String authorization, @RequestBody EmailMessage emailMessage) {
        try {
            ResponseDTO response = null;
            log.info(">>>>> Email Send Process Start at " + new Date());
            response = emailService.sendPasswordRecoveryEmail(emailMessage, authorization);
            log.info(">>>>> Email Send Process End at " + new Date());
            return response;
        } catch (Exception ex) {
            return new ResponseDTO(500, null, null, false, ex.getMessage());
        }
    }

    @GetMapping("/healthCheck")
    @ResponseStatus(HttpStatus.OK)
    public Object healthCheck(){
        return "{\"success\":true}";
    }

}
