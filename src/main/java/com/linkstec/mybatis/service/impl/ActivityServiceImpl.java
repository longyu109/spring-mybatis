package com.linkstec.mybatis.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.linkstec.mybatis.mapper.MotActivityMapper;
import com.linkstec.mybatis.model.MotActivity;
import com.linkstec.mybatis.service.ActivityService;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private MotActivityMapper motActivityMapper;

	@Override
	public MotActivity selectByPrimaryKey(BigDecimal activityId) {
		MotActivity selectByPrimaryKey = motActivityMapper
				.selectByPrimaryKey(activityId);
		return selectByPrimaryKey;
	}

	@Override
	public List<MotActivity> getByPage(Map<String, Object> requestMap) {
		String pageSizeStr = (String) requestMap.get("pageSize");
		String pageNumStr = (String) requestMap.get("pageNum");

		Integer pageSize = 20;
		Integer pageNum = 1;
		if (pageSizeStr != null && pageNumStr != null) {
			pageSize = Integer.parseInt(pageSizeStr);
			pageNum = Integer.parseInt(pageNumStr);
		}
		PageHelper.startPage(pageNum, pageSize);
		return motActivityMapper.getByPage(requestMap);
	}

}
