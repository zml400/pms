package com.pms.service;

import com.pms.entity.Document;
import com.pms.entity.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DocumentService {
     Result upLoadFile(MultipartFile file);
     Result upLoadFiles(MultipartFile[] files);
     Result downLoad(HttpServletResponse response,int documentId);
     Result deleteDocument(int documentId);
     Result updateDocument(Document document);
     Result findDocumentById(int documentId);
     Result findDocumentByName(String documentName);
     Result findDocumentByStatus(int documentStatus);
     Result findAllDocument();
}
