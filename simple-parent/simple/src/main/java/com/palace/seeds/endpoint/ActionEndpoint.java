package com.palace.seeds.endpoint;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.palace.seeds.helper.Result;
import com.palace.seeds.service.ActionService;

@Controller
@RequestMapping("action")
public class ActionEndpoint {
	
	@Autowired
	private ActionService actionService;
	@RequestMapping("add")
	public @ResponseBody Result add(Map<String,Object> params){
		return actionService.add(params);
	}
	@RequestMapping("edit")
	public @ResponseBody Result edit(Map<String,Object> params){
		return  actionService.edit(params);
	}
	
	
	@RequestMapping("getPage")
	public @ResponseBody Map<String,Object> getPage(Map<String,Object> params){
		return actionService.getPage(params);
	}
}
