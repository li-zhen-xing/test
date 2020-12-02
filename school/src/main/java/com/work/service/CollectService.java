package com.work.service;

import com.work.pojo.Collect;

import java.util.List;

public interface CollectService {
	
	public List<Collect> getCollectList(Collect collect, Integer page, Integer limit);
	public Integer getCollectListCount(Collect collect);
	public void addCollect(Collect collect);
	public Collect getCollectById(Integer id);
	public void deleteCollectById(int id);
	public void deleteMyCollect(Collect collect);
}
