package com.palace.seeds.endpoint;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.palace.seeds.helper.Result;
import com.palace.seeds.service.ActionService;

@Controller
@RequestMapping("Test")
public class TestEndpoint {
	
	@Autowired
	private ActionService actionService;
	@RequestMapping("test")
	public @ResponseBody Result add(Map<String,Object> params){
		
		
		
		
		return actionService.add(params);
	}
	 
}
