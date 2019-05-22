package com.pms.mapper;

import com.pms.entity.Document;
import org.apache.ibatis.annotations.Mapper;

import java.io.File;
import java.util.List;

@Mapper
public interface DocumentMapper {
    public int addDocument(Document document);
    public int deleteDocument(int documentId);
    public int updateDocument(Document document);
    public Document findDocumentById(int documentId);
    public Document findDocumentByName(String documentName);
    public List<Document> findDocumentByStatus(int documentStatus);
    public List<Document> findAllDocument();
}
