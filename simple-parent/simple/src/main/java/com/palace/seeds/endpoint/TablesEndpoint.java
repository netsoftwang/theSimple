package com.palace.seeds.endpoint;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.palace.seeds.service.TablesService;

@Controller
@RequestMapping("tables")
public class TablesEndpoint {
 
	@Resource
	private TablesService tablesService;
	
	@RequestMapping("getTablesPage")
	public @ResponseBody Map<String,Object> getTables(){
		return tablesService.getPage(null);
	}
	 
}
