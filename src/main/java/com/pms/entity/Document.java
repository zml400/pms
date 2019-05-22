package com.pms.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
public class Document {
    private int documentId;
    private String documentName;
    private MultipartFile documentContent;
    private String documentUrl;
    private int documentStatus;
}
