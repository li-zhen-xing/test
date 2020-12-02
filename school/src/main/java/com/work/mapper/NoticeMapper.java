package com.work.mapper;

import com.work.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface NoticeMapper {
	
	public List<Notice> getNoticeList(@Param("notice") Notice notice, @Param("page") Integer page, @Param("limit") Integer limit);
	public Integer getNoticeListCount(@Param("notice") Notice notice);
	public void addNotice(@Param("notice") Notice notice);
	public void updateNotice(@Param("notice") Notice notice);
	public Notice getNoticeById(@Param("id") Integer id);
	public void deleteNoticeById(@Param("id") int id);
	
}
