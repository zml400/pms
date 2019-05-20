package com.pms.service.Impl;

import com.pms.entity.Notice;
import com.pms.entity.Result;
import com.pms.mapper.NoticeMapper;
import com.pms.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public Result addNotice(Notice notice) {
        Result result = new Result();
        Notice notice1=noticeMapper.findNoticeByName(notice.getNoticeName());
        if(notice1!=null){
            result.setCode(1);
            result.setMessage("添加失败，名称已经存在！");
        }else{
            int num=noticeMapper.addNotice(notice);
            if(num==0){
                result.setCode(1);
                result.setMessage("添加失败！");
            }else
            {
                result.setCode(1);
                result.setMessage("添加成功");
                result.setData(notice);
            }
        }
        return result;
    }

    @Override
    public Result deleteNotice(int noticeId) {
        Result result = new Result();
        int num=noticeMapper.deleteNotice(noticeId);
        if(num==0){
            result.setCode(1);
            result.setMessage("删除失败");
        }else {
            result.setCode(0);
            result.setMessage("删除成功");
        }
        return result;
    }

    @Override
    public Result updateNotice(Notice notice) {
        Result result = new Result();
        int num=noticeMapper.updateNotice(notice);
        if(num==0){
            result.setCode(1);
            result.setMessage("更新失败");
        }else{
            result.setCode(0);
            result.setMessage("更新成功");
            result.setData(notice);
        }
        return result;
    }

    @Override
    public Result findNoticeById(int noticeId) {
        Result result = new Result();
        Notice notice = noticeMapper.findNoticeById(noticeId);
        if(notice==null){
            result.setCode(1);
            result.setMessage("您输入的公告id错误，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(notice);
        }
        return result;
    }

    @Override
    public Result findNoticeByName(String noticeName) {
        Result result = new Result();
        Notice notice = noticeMapper.findNoticeByName(noticeName);
        if(notice==null){
            result.setCode(1);
            result.setMessage("您输入的公告名错误，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(notice);
        }
        return result;
    }

    @Override
    public Result findNoticeByStatus(int noticeStatus) {
        Result result = new Result();
        List<Notice> noticeList = noticeMapper.findNoticeByStatus(noticeStatus);
        if(noticeList.size()==0){
            result.setCode(1);
            result.setMessage("您输入的状态错误，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(noticeList);
        }
        return result;
    }

    @Override
    public Result findNoticeByContent(String noticeContent) {
        Result result = new Result();
        List<Notice> noticeList = noticeMapper.findNoticeByContent(noticeContent);
        if(noticeList.size()==0){
            result.setCode(1);
            result.setMessage("您输入的内容不存在，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(noticeList);
        }
        return result;
    }

    @Override
    public Result findAllNotice() {
        Result result = new Result();
        List<Notice> noticeList = noticeMapper.findAllNotice();
        result.setCode(0);
        result.setMessage("查找成功");
        result.setData(noticeList);
        return result;
    }
}
