package com.palace.seeds.endpoint;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.palace.seeds.helper.Result;
import com.palace.seeds.service.IBaseService;

public abstract class BaseEndpoint {
	
	 
	public @ResponseBody Result add(Map<String,Object> params){
		 return null;
	}
	 
	public @ResponseBody Result edit(Map<String,Object> params){
		return null;
	}
	
	 
	public @ResponseBody Result getPageResult(Map<String,Object> params){
		return null;
	}
	
	 
	public @ResponseBody Map<String,Object> getPage(Map<String,Object> params){
		return null;
	}
	
	public IBaseService getService(){
		return null;
	}
}
