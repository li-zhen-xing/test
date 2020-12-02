package com.work.mapper;

import com.work.pojo.ForumReply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ForumReplyMapper {
	
	public List<ForumReply> getForumReplyList(@Param("forumReply") ForumReply forumReply, @Param("page") Integer page, @Param("limit") Integer limit);
	public Integer getForumReplyListCount(@Param("forumReply") ForumReply forumReply);
	public void addForumReply(@Param("forumReply") ForumReply forumReply);
	public void updateForumReply(@Param("forumReply") ForumReply forumReply);
	public ForumReply getForumReplyById(@Param("replyId") Integer replyId);
	public void deleteForumReply(@Param("replyId") Integer replyId);
	
}
