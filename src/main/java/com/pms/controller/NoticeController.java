package com.pms.controller;

import com.pms.entity.Notice;
import com.pms.entity.Result;
import com.pms.service.Impl.NoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping("/findNoticeByStatus")
    public Result findNoticeByStatus(int noticeStatus){
        Result result = noticeService.findNoticeByStatus(noticeStatus);
        return  result;
    }
    @RequestMapping("/findAllNotice")
    public Result findAllNotice(){
        Result result = noticeService.findAllNotice();
        return  result;
    }

}
