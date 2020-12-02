package com.work.service;

import com.work.pojo.SystemUpset;

import java.util.List;

public interface SystemUpsetService {
	
	public List<SystemUpset> getSystemUpsetList(SystemUpset systemUpset, Integer page, Integer limit);
	public Integer getSystemUpsetListCount(SystemUpset systemUpset);
	public void addSystemUpset(SystemUpset systemUpset);
	public void updateSystemUpset(SystemUpset systemUpset);
	
}
