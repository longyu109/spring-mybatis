package com.linkstec.mybatis.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.linkstec.mybatis.model.MotActivity;

public interface ActivityService {
	
	 public MotActivity selectByPrimaryKey(BigDecimal activityId);
	 
	 public List<MotActivity> getByPage(Map<String,Object> requestMap);
 	 
}
