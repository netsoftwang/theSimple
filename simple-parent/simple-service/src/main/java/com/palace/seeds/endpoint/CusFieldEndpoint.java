package com.palace.seeds.endpoint;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.palace.seeds.service.ICusFieldService;

@Controller
@RequestMapping("cusField")
public class CusFieldEndpoint {
 
	@Resource
	private ICusFieldService cusFieldService;
	
	@RequestMapping("getCusFieldPage")
	public @ResponseBody Map<String,Object> getCusFieldPage(@RequestParam Map<String,Object> map){
		return cusFieldService.getPage(map);
	}
	 
}
