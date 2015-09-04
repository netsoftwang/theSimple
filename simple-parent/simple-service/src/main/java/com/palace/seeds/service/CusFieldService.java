package com.palace.seeds.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.palace.seeds.dao.ICusFieldDao;
import com.palace.seeds.helper.Result;
import com.palace.seeds.helper.TableConst;
import com.palace.seeds.model.CusField;

@Service
public class CusFieldService extends BaseService implements ICusFieldService{

	@Resource  
	private ICusFieldDao cusFieldDao;
	
	public Map getPage(Map<String, Object> params) {
		return cusFieldDao.getPage(params);
	}

	public Result save(Map<String,Object>  map){
		map.put(TableConst.TABLENAME,"cusField");
		map.put(TableConst.ENT,getEntId());
		if(this.baseDao.save(map)>1){
			return Result.succ();
		}else{
			return Result.err("cusField 保存错误");
		}
	}
	
	
	public static void main(String[] args) {
		Class clazz= CusField.class;
		Field[] fieldArr= clazz.getDeclaredFields();
		String fieldName=null;
		for(Field f : fieldArr){
			fieldName = f.getName();
			System.out.println(fieldName);
		}
	}
}
