package com.work.mapper;

import com.work.pojo.Chat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatMapper {
	
	public List<Chat> getChatList(@Param("chat") Chat chat, @Param("page") Integer page, @Param("limit") Integer limit);
	public Integer getChatListCount(@Param("chat") Chat chat);
	public void addChat(@Param("chat") Chat chat);
	public void updateChat(@Param("chat") Chat chat);
	public Chat getChatById(@Param("id") Integer id);
	public void deleteChatById(@Param("id") Integer id);
	//聊天消息
	public List<Chat> findChatList(@Param("chat") Chat chat, @Param("page") Integer page, @Param("limit") Integer limit);
	public Integer findChatListCount(@Param("chat") Chat chat);
	//我的消息
	public List<Chat> myChatList(@Param("chat") Chat chat);
	
	
}
