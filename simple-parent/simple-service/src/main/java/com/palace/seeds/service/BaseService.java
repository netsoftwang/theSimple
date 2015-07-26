package com.palace.seeds.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.palace.seeds.dao.BaseDao;
import com.palace.seeds.helper.Result;
import com.palace.seeds.helper.TableConst;
import com.palace.seeds.model.CusField;
import com.palace.seeds.model.Model;

public class BaseService{
	@Autowired
	protected BaseDao baseDao;
	 
	
	public Result save(){
		return null;
	}

	public <T> Model getModel(Class<T> clazz,Map<String,Object> params){
		return new Model(clazz, params);
	}
	public Model getModel(String tableName,Map<String,Object> params){
		return new Model(tableName,params);
	}
	public Model getModel(List<CusField> cfList ,Map<String,Object> params){
		return null;
	}
	
	
	
	public Map<String,Object> getPage(int total,List<Map<String,Object>> val){
		Map<String,Object> res=new HashMap<String, Object>();
		 res.put(TableConst.TOTAL,total);
		 res.put(TableConst.ROWS, val);
		 return res;
	}
}
