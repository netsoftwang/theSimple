package com.palace.seeds.service;

import java.util.Map;

import com.palace.seeds.helper.Result;

public interface ICusFieldService {

	public Map getPage(Map<String, Object> params);

	public Result save(Map<String,Object>  map);
}
