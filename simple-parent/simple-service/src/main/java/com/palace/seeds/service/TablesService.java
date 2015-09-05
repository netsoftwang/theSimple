package com.palace.seeds.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palace.seeds.dao.ITablesDao;
import com.palace.seeds.helper.Result;
import com.palace.seeds.helper.TableConst;

@Service
public class TablesService extends BaseService{
	
	@Autowired
	private ITablesDao tablesDao;
	public Result add(Map<String,Object> map){
		map.put(TableConst.TABLENAME,"tables");
		map.put(TableConst.ENTID, getEntId());
		Long id=tablesDao.save(map);
		if(id >0){
			return Result.succ().add(TableConst.ID,id);
		}else{
			return Result.err("保存失败");
		}
	}
	
	public Map<String,Object> getPage(Map<String,Object> map){
		//这里应该有权限控制，管理员权限，企业权限和用户权限
		return getPage(tablesDao.queryForLong("select count(1) from tables where 1=1 "+getCondition(map)) , 
				tablesDao.queryForListMap("select * from tables where 1=1 "+getCondition(map)+getOrder(map)+" limit ?,? ",Long.parseLong((String)map.get("page")),Long.parseLong((String)map.get("rows"))));
	}
	
	public  String getCondition(Map<String,Object> map){
		String sql = " ";
		for(String key : map.keySet()){
			if(key.startsWith("key")){
				sql+=" and "+ key.split("_")[1]+" like '%"+map.get(key+"' ");
			}
		}
	return sql;
	}
	
	
	 public String getOrder(Map<String,Object> map){
		 if(map.containsKey("sort")){
			 return " order by "+map.get("sort")+" "+ map.get("order");
		 }else{
			 return " " ;
		 }
	 }
	
	
	
	
}
