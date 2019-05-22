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
        Notice notice1=noticeMapper.findNoticeByName(notice.getNoticeName());
        if(notice1!=null){
            return Result.failed("添加失败，名称已经存在！");
        }else{
            int num=noticeMapper.addNotice(notice);
            if(num==0){
                return Result.failed("添加失败！");
            }else
            {
                return Result.success("添加成功",notice);
            }
        }
    }

    @Override
    public Result deleteNotice(int noticeId) {
        int num=noticeMapper.deleteNotice(noticeId);
        if(num==0){
            return Result.failed("删除失败");
        }else {
            return Result.success("删除成功");
        }
    }

    @Override
    public Result updateNotice(Notice notice) {
        int num=noticeMapper.updateNotice(notice);
        if(num==0){
            return Result.failed("更新失败");
        }else {
            return Result.success("更新成功",notice);
        }
    }

    @Override
    public Result findNoticeById(int noticeId) {
        Notice notice = noticeMapper.findNoticeById(noticeId);
        if(notice==null){
            return Result.failed("您输入的公告id错误，请重新输入");
        }else {
            return Result.success("查找成功",notice);
        }
    }

    @Override
    public Result findNoticeByName(String noticeName) {
        Notice notice = noticeMapper.findNoticeByName(noticeName);
        if(notice==null){
            return Result.failed("您输入的公告名错误，请重新输入");
        }else {
            return Result.success("查找成功",notice);
        }
    }

    @Override
    public Result findNoticeByStatus(int noticeStatus) {
        List<Notice> noticeList = noticeMapper.findNoticeByStatus(noticeStatus);
        if(noticeList.size()==0){
            return Result.failed("您输入的状态错误，请重新输入");
        }else {
            return Result.success("查找成功",noticeList);
        }
    }

    @Override
    public Result findNoticeByContent(String noticeContent) {
        List<Notice> noticeList = noticeMapper.findNoticeByContent(noticeContent);
        if(noticeList.size()==0){
            return Result.failed("您输入的内容不存在，请重新输入");
        }else {
            return Result.success("查找成功",noticeList);
        }
    }

    @Override
    public Result findAllNotice() {
        List<Notice> noticeList = noticeMapper.findAllNotice();
        if(noticeList.size()==0){
            return Result.failed("没有记录");
        }else {
            return Result.success("查找成功",noticeList);
        }
    }
}
