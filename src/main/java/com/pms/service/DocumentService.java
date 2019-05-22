package com.pms.service;

import com.pms.VO.ResultPage;
import com.pms.entity.Document;
import com.pms.VO.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface DocumentService {
     public Result upLoadFile(MultipartFile file);
     public Result upLoadFiles(MultipartFile[] files);
     public Result downLoad(HttpServletResponse response,int documentId);
     public Result deleteDocument(int documentId);
     public Result updateDocument(Document document);
     public Result findDocumentById(int documentId);
     public Result findDocumentByName(String documentName);
     public ResultPage findDocumentByStatus(int documentStatus,int pageNum, int pageSize);
     public ResultPage findAllDocument(int pageNum,int pageSize);
}
