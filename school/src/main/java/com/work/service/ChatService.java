package com.work.service;

import com.work.pojo.Chat;

import java.util.List;

public interface ChatService {
	public List<Chat> getChatList(Chat chat, Integer page, Integer limit);
	public Integer getChatListCount(Chat chat);
	public void addChat(Chat chat);
	public void updateChat(Chat chat);
	public Chat getChatById(Integer id);
	public void deleteChatByChatId(int id);
	public List<Chat> findChatList(Chat chat, Integer page, Integer limit);
	public Integer findChatListCount(Chat chat);
	public List<Chat> myChatList(Chat chat);
	
}
