package com.pms.service;

import com.pms.VO.ResultPage;
import com.pms.entity.Notice;
import com.pms.VO.Result;

public interface NoticeService {
    public Result addNotice(Notice notice);
    public Result deleteNotice(int noticeId);
    public Result updateNotice(Notice notice);
    public Result findNoticeById(int noticeId);
    public Result findNoticeByName(String noticeName);
    public ResultPage findNoticeByStatus(int noticeStatus, int pageNum, int pageSize);
    public Result findNoticeByContent(String noticeContent);
    public ResultPage findAllNotice(int pageNum,int pageSize);
}
