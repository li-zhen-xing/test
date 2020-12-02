package com.work.mapper;

import com.work.pojo.SystemUpset;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemUpsetMapper {
	
	public List<SystemUpset> getSystemUpsetList(@Param("systemUpset") SystemUpset systemUpset, @Param("page") Integer page, @Param("limit") Integer limit);
	public Integer getSystemUpsetListCount(@Param("systemUpset") SystemUpset systemUpset);
	public void addSystemUpset(@Param("systemUpset") SystemUpset systemUpset);
	public void updateSystemUpset(@Param("systemUpset") SystemUpset systemUpset);
	public SystemUpset getSystemUpsetById(@Param("id") Integer id);
	public void deleteSystemUpsetById(@Param("id") int id);

}
