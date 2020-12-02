package com.work.mapper;

import com.work.pojo.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
	
	public List<Banner> getBannerList(@Param("banner") Banner banner, @Param("page") Integer page, @Param("limit") Integer limit);
	public Integer getBannerListCount(@Param("banner") Banner banner);
	public void addBanner(@Param("banner") Banner banner);
	public void updateBanner(@Param("banner") Banner banner);
	public Banner getBannerById(@Param("id") Integer id);

}
