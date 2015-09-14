package com.palace.seeds.endpoint;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.palace.seeds.helper.Result;
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
	@RequestMapping("add")
	public @ResponseBody Result add(@RequestParam Map<String,Object> map){
		return cusFieldService.save(map);
	}
	
	@RequestMapping("edit")
	public @ResponseBody Result edit(@RequestParam Map<String,Object> map){
		return cusFieldService.edit(map);
	}
	@RequestMapping("del")
	public @ResponseBody Result del(@RequestParam Map<String,Object> map){
		return cusFieldService.del(map);
	}
	
}
