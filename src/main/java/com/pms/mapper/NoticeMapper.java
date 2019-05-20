package com.pms.mapper;

import com.pms.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    public int addNotice(Notice notice);
    public int deleteNotice(int noticeId);
    public int updateNotice(Notice notice);
    public Notice findNoticeById(int noticeId);
    public Notice findNoticeByName(String noticeName);
    public List<Notice> findNoticeByStatus(int noticeStatus);
    public List<Notice> findNoticeByContent(String noticeContent);
    public List<Notice> findAllNotice();
}
