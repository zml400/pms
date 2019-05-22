package com.pms.controller;

import com.pms.VO.ResultPage;
import com.pms.entity.Notice;
import com.pms.VO.Result;
import com.pms.service.Impl.NoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Notice")
public class NoticeController {
    @Autowired
    private NoticeServiceImpl noticeService;

    @RequestMapping("/addNotice")
    public Result addNotice(Notice notice){
        Result result = noticeService.addNotice(notice);
        return result;
    }

    @RequestMapping("/deleteNotice")
    public Result deleteNotice(int noticeId){
        Result result =noticeService.deleteNotice(noticeId);
        return result;
    }
    @RequestMapping("/updateNotice")
    public Result updateNotice(Notice notice){
        Result result = noticeService.updateNotice(notice);
        return result;
    }
    @RequestMapping("/findNoticeByName")
    public Result findNoticeByName(String noticeName){
        Result result = noticeService.findNoticeByName(noticeName);
        return  result;
    }
    @RequestMapping("/findNoticeByContent")
    public Result findNoticeByContent(String noticeContent){
        Result result = noticeService.findNoticeByContent(noticeContent);
        return  result;
    }
    @RequestMapping("/findNoticeByStatus/{pageNum},{pageSize}")
    public ResultPage findNoticeByStatus(@PathVariable("pageNum")int pageNum,
                                           @PathVariable("pageSize")int pageSize,
                                           int noticeStatus){
        return noticeService.findNoticeByStatus(noticeStatus,pageNum,pageSize);
    }
    @RequestMapping("/findAllNotice/{pageNum},{pageSize}")
    public ResultPage findAllNotice(@PathVariable("pageNum")int pageNum,
                                           @PathVariable("pageSize")int pageSize){
        return noticeService.findAllNotice(pageNum,pageSize);
    }

}
