package com.mm.api.domain;

import lombok.Data;
import lombok.ToString;
import java.util.List;

@Data
@ToString
public class CmsEmailTemplateDto {
    private static final long serialVersionUID = 1L;
    private String recipients;
    private String subject;
    private String fromEmail;
    private String fromName;
    private String sandGridKey;
    private String redirectUrl;
    private String logoUrl;
    private List<CmsEmailTemplateDetailDto> detailDtos;
}
