package com.palace.seeds.endpoint;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.palace.seeds.helper.Result;
import com.palace.seeds.service.TablesService;

@Controller
@RequestMapping("tables")
public class TablesEndpoint {
 
	@Resource
	private TablesService tablesService;
	
	@RequestMapping("getTablesPage")
	public @ResponseBody Map<String,Object> getTables(@RequestParam Map<String,Object> map){
		return tablesService.getPage(map);
	}
	 
	@RequestMapping("add")
	public @ResponseBody Result add(@RequestParam Map<String,Object> map){
		return tablesService.add(map);
	}
}
