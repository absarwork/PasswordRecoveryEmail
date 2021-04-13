package com.mm.api.emailer;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class ContentRefreshDTO {
    private String emailKey = "";

    private String toEmail = "" ;

    private String fromEmail = "" ;

    private String emailSubject = "" ;

    private String emailServerUrl = "" ;

    private String emailApiKey = "" ;

    private List<Long> bookIds = new ArrayList<>();
}
