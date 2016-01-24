package com.palace.seeds.endpoint;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.palace.seeds.helper.Result;
import com.palace.seeds.service.ActionService;
import com.palace.seeds.service.TreeService;
import com.palace.seeds.util.JsonKit;

@Controller
@RequestMapping("tree")
public class TreeEndpoint {
	
	@Autowired
	private TreeService treeService;
	@RequestMapping("add")
	public @ResponseBody Result add(ServletRequest req){
		return treeService.add(getParams(req));
	}
	@RequestMapping("edit")
	public @ResponseBody Result edit(ServletRequest req){
		return  treeService.edit(getParams(req));
	}
	
	@RequestMapping("getPage")
	public @ResponseBody Map<String,Object> getPage(@RequestParam Map<String,Object> map){
		return treeService.getPage(map);
	}
	
	public Map<String,Object> getParams(ServletRequest req){
		Map<String,Object> params=new HashMap<String, Object>();
		Enumeration<String> enumVal= req.getParameterNames();
		while(enumVal.hasMoreElements()){
			String name= enumVal.nextElement();
			params.put(name,req.getParameter(name));
		}
		return params;
	}
}
