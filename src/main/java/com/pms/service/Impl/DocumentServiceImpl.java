package com.pms.service.Impl;

import com.pms.entity.Document;
import com.pms.entity.Result;
import com.pms.mapper.DocumentMapper;
import com.pms.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentMapper documentMapper;

    /**
     * 上传单个文件
     * @param file 文件
     * @return Result
     */
    @Override
    public Result upLoadFile(MultipartFile file){
        if(file.isEmpty()){
            return Result.failed("文件为空");
        }

        String fileName = file.getOriginalFilename();
        Document document=documentMapper.findDocumentByName(fileName);
        if(document!=null){
            return Result.failed("添加失败，名字已经存在！");
        }
        try {
            String filePath = ResourceUtils.getURL("").getPath();
            //文件存放路径：resources文件夹下的upLoad文件中
            String path = filePath+"src/main/resources/upLoad/"+fileName;
            File file1 = new File(path);
            if(!file1.getParentFile().exists()){
                file1.getParentFile().mkdirs();
            }
            try {
                file.transferTo(file1);

                Document document1 = new Document();
                document1.setDocumentName(fileName);
                document1.setDocumentUrl(path);
                documentMapper.addDocument(document1);
                return Result.success(fileName+"上传成功",document1);
            } catch (IOException e) {
                return Result.failed(fileName+"上传失败");
            }
        }catch (FileNotFoundException e){
            return Result.failed("上传失败");
        }
    }

    /**
     * 上传多个文件
     * @param files 文件
     * @return Result
     */
    @Override
    public Result upLoadFiles(MultipartFile[] files){
        if (files.length==0) {
            return Result.failed("文件为空");
        }
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            Document document = documentMapper.findDocumentByName(fileName);
            if (document != null) {
                return Result.failed("添加失败，" + fileName + ":名字已经存在！");
            }
            try {
                String filePath = ResourceUtils.getURL("").getPath();
                //文件存放路径：resources文件夹下的upLoad文件中
                String path = filePath + "src/main/resources/upLoad/" + fileName;
                File file1 = new File(path);
                if (!file1.getParentFile().exists()) {
                    file1.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(file1);
                    Document document1 = new Document();
                    document1.setDocumentName(fileName);
                    document1.setDocumentUrl(path);
                    documentMapper.addDocument(document1);
                    return Result.success("上传成功", document1);
                } catch (IOException e) {
                    return Result.failed("上传失败");

                }
            } catch (FileNotFoundException e) {
                return Result.failed(fileName + "上传失败");
            }
        }
        return Result.success();
    }

    /**
     * 下载文件
     * @param response 回应
     * @return Result
     */
    @Override
    public Result downLoad(HttpServletResponse response,int documentId){
        String fileName=documentMapper.findDocumentById(documentId).getDocumentName();
        String sourcePath = documentMapper.findDocumentById(documentId).getDocumentUrl();
        File sourceFile = new File(sourcePath);
        if(!sourceFile.exists()) { //判断文件是否存在
            return Result.failed("文件"+fileName+"不存在");
        }
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment;fileName=" +fileName);
        byte[] buffer = new byte[1024];
        try {
            OutputStream outputStream = response.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            int length = bufferedInputStream.read(buffer);
            while (length != -1) {
                outputStream.write(buffer);
                length = bufferedInputStream.read(buffer);
            }
            bufferedInputStream.close();
            fileInputStream.close();
            return Result.success("下载成功");
        } catch (Exception e) {
            return Result.failed("下载失败");
        }
    }
    @Override
    public Result deleteDocument(int documentId) {
        int num=documentMapper.deleteDocument(documentId);
        if(num==0){
            return Result.failed("删除失败");
        }else {
            return Result.success("删除成功");
        }
    }

    @Override
    public Result updateDocument(Document document) {
        int num=documentMapper.updateDocument(document);
        if(num==0){
            return Result.failed("更新失败");
        }else{
            return Result.success("更新成功",document);
        }
    }

    @Override
    public Result findDocumentById(int documentId) {
        Document document = documentMapper.findDocumentById(documentId);
        if(document==null){
            return Result.failed("您输入的文件id错误，请重新输入");
        }else {
            return Result.success("查找成功",document);
        }
    }

    @Override
    public Result findDocumentByName(String documentName) {
        Document document = documentMapper.findDocumentByName(documentName);
        if(document==null){
            return Result.failed("您输入的文件名错误，请重新输入");
        }else {
            return Result.success("查找成功",document);
        }
    }

    @Override
    public Result findDocumentByStatus(int documentStatus) {
        List<Document> documentList = documentMapper.findDocumentByStatus(documentStatus);
        if(documentList.size()==0){
            return Result.failed("您输入的状态没有记录，请重新输入");
        }else {
            return Result.success("查找成功", documentList);
        }
    }

    @Override
    public Result findAllDocument() {
        List<Document> documentList = documentMapper.findAllDocument();
        if(documentList.size()==0){
            return Result.failed("没有记录");
        }else {
            return Result.success("查找成功", documentList);
        }
    }
}
