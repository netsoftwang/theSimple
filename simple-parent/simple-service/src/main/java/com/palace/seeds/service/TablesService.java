package com.palace.seeds.service;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palace.seeds.dao.ITablesDao;
import com.palace.seeds.helper.Result;
import com.palace.seeds.helper.TableConst;
import com.palace.seeds.util.StringKit;

@Service
public class TablesService extends BaseService{
	
	@Autowired
	private ITablesDao tablesDao;
	public Result add(Map<String,Object> map){
		Long id=tablesDao.save(map);
		if(id >0){
			return Result.succ().add(TableConst.ID,id);
		}else{
			return Result.err("保存失败");
		}
	}
	
	public Map<String,Object> getPage(Map<String,Object> params){
		//这里应该有权限控制，管理员权限，企业权限和用户权限
		return getPage(tablesDao.queryForLong("select count(1) from tables ") , 
				tablesDao.queryForListMap("select * from tables ", null));
	}
	
	public  String getOrderBy(Map<String,Object> map){
		String orderBy = MapUtils.getString(map,TableConst.ORDERBY,"");
		if(!StringKit.isEmpety(orderBy)){
			  return  " order by "+orderBy+" "+MapUtils.getString(map,TableConst.ORDERTYPE," desc ");
		}else{
			return "";
		}
	}
	
	
	//我们约定查询条件都以
	
	
	
	
}
