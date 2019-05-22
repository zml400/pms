package com.pms.controller;

import com.pms.VO.ResultPage;
import com.pms.entity.Document;
import com.pms.VO.Result;
import com.pms.service.Impl.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/Document")
public class DocumentController {
    @Autowired
    private DocumentServiceImpl documentService;

    /**
     * 上传文件
     * @param file
     * @return
     */
    @RequestMapping(value = "/upLoadFile",method = RequestMethod.POST)
    public Result upLoadFile(@RequestParam("file") MultipartFile file) {
        Result result =documentService.upLoadFile(file);
        return result;
    }

    /**
     * 批量上传文件
     * @param files
     * @return
     */
    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    public Result upLoadFiles(@RequestParam("file") MultipartFile[] files) {
        Result result =documentService.upLoadFiles(files);
        return result;
    }

    /**
     * 下载文件
     * @param response
     * @return
     */
    @RequestMapping("/download")
    public Result downloadFile(HttpServletResponse response,int documentId) {
        Result result = documentService.downLoad(response,documentId);
        return result;
    }

    @RequestMapping("/deleteDocument")
    public Result deleteDocument(int documentId){
        Result result =documentService.deleteDocument(documentId);
        return result;
    }


    @RequestMapping("/updateDocument")
    public Result updateDocument(Document document){
        Result result = documentService.updateDocument(document);
        return result;
    }

    @RequestMapping("/findDocumentByName")
    public Result findDocumentByName(String documentName){
        Result result = documentService.findDocumentByName(documentName);
        return  result;
    }

    /**
     * 根据文件状态查找文件
     */
    @RequestMapping("/findDocumentByStatus/{pageNum},{pageSize}")
    public ResultPage findDocumentByStatus(@PathVariable("pageNum")int pageNum,
                                           @PathVariable("pageSize")int pageSize,
                                           int documentStatus){
        ResultPage result = documentService.findDocumentByStatus(documentStatus,pageNum,pageSize);
        return  result;
    }

    @RequestMapping("/findAllDocument/{pageNum},{pageSize}")
    public ResultPage findAllDocument(@PathVariable("pageNum")int pageNum,
                                    @PathVariable("pageSize")int pageSize){
        return documentService.findAllDocument(pageNum,pageSize);
    }

}
