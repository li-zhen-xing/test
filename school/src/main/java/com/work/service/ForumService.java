package com.work.service;

import com.work.pojo.Forum;

import java.util.List;

public interface ForumService {
	
	public List<Forum> getForumList(Forum forum, Integer page, Integer limit);
	public Integer getForumListCount(Forum forum);
	public void addForum(Forum forum);
	public void updateForum(Forum forum);
	public Forum getForumById(Integer id);
	
}
