package com.pms.service;

import com.pms.entity.Notice;
import com.pms.entity.Result;

public interface NoticeService {
    public Result addNotice(Notice notice);
    public Result deleteNotice(int noticeId);
    public Result updateNotice(Notice notice);
    public Result findNoticeById(int noticeId);
    public Result findNoticeByName(String noticeName);
    public Result findNoticeByStatus(int noticeStatus);
    public Result findNoticeByContent(String noticeContent);
    public Result findAllNotice();
}
