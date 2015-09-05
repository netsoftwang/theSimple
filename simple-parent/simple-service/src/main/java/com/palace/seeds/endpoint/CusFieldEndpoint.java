package com.palace.seeds.endpoint;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.palace.seeds.service.ICusFieldService;

@Controller
@RequestMapping("cusField")
public class CusFieldEndpoint {
 
	@Resource
	private ICusFieldService cusFieldService;
	
	@RequestMapping("getCusFieldPage")
	public @ResponseBody Map<String,Object> getCusFieldPage(ServletRequest req){
		Map<String,Object> params=new HashMap<String, Object>();
		Enumeration<String> enumVal= req.getParameterNames();
		while(enumVal.hasMoreElements()){
			String name=enumVal.nextElement();
			params.put(name,req.getParameter(name));
		}
		return cusFieldService.getPage(params);
	}
	 
}
