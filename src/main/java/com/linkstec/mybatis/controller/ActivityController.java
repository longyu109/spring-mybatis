package com.linkstec.mybatis.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.linkstec.mybatis.model.MotActivity;
import com.linkstec.mybatis.service.ActivityService;

@RestController
@RequestMapping("/mot/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	/**
	 * 测试最简单的http请求，以便后续的分页
	 * 
	 * */

	@RequestMapping(value = "/{activityId}", method = RequestMethod.GET)
	@ResponseBody
	public MotActivity get(@PathVariable String activityId) {
		MotActivity selectByPrimaryKey = activityService
				.selectByPrimaryKey(new BigDecimal(activityId));
		return selectByPrimaryKey;
	}

	/**
	 * 分页
	 * 
	 * */

	@RequestMapping(value = "/getByPage", method = RequestMethod.GET)
	@ResponseBody
	public List<MotActivity> getInfos(@RequestParam String pageNum,@RequestParam String pageSize) {

		Map<String, Object> requestMap = new HashMap<String, Object>();
		requestMap.put("pageNum", pageNum);
		requestMap.put("pageSize", pageSize);
		List<MotActivity> list = activityService.getByPage(requestMap);
		return list;
	}

}
