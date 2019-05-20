package com.pms.entity;

import lombok.Data;

@Data
public class Notice {
    private int noticeId;
    private String noticeName;
    private String noticeContent;
    private int noticeStatus;
}
