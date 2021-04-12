package com.mm.api.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CmsEmailTemplateDetailDto {

    private String bookId;
    private String unitId;
    private String unitName;
    private String pageId;
    private String pageName;
    private String bookFolder;
    private String unitFoler;
    private String pageFolder;
    private String status;
    private String result;
    private String startTime;
    private String endTime;
}
