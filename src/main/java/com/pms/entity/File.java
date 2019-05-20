package com.pms.entity;

import lombok.Data;

@Data
public class File {
    private int fileId;
    private String fileName;
    private String fileLink;
    private String fileDescription;
    private int fileStatus;
}
