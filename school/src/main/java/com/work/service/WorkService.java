package com.work.service;

import com.work.pojo.Work;

import java.util.List;

public interface WorkService {
	
	public List<Work> getWorkList(Work work, Integer page, Integer limit);
	public Integer getWorkListCount(Work work);
	public void addWork(Work work);
	public void updateWork(Work work);
	public Work getWorkById(Integer id);
	
}
