package com.palace.seeds.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.palace.seeds.dao.BaseDao;
import com.palace.seeds.data.UserInfo;
import com.palace.seeds.helper.Cache;
import com.palace.seeds.helper.Result;
import com.palace.seeds.helper.TableConst;
import com.palace.seeds.model.CusField;
import com.palace.seeds.model.Model;
import com.palace.seeds.model.User;

public class BaseService{
	@Autowired
	protected BaseDao baseDao;
	 
/*	public Result save(Map<String,Object> map){
		 if(this.baseDao.save(map)>1){
			 return Result.succ();
		 }else{
			 return Result.err("保存失败!");
		 }
	}*/
	public Result saveCFMap(Map<String,Object> map){
		 List<Map<String,Object>>  listMap = getCusFile(map);
		 StringBuilder sb=new StringBuilder(300);
		 sb.append("insert into ").append(listMap.get(0).get("tableName("));
		 StringBuilder  valSb=new StringBuilder(300);
		 valSb.append(" values( ");
		 
		 Object[] objArr=new Object[listMap.size()];
		 String fieldName="";
		 for(int i=0;i<listMap.size();i++){
			 fieldName=(String) listMap.get(i).get("field");
			 sb.append(fieldName).append(",");
			 valSb.append("?").append(",");
			 objArr[i]=map.get(fieldName);
		 }
		 String sql=sb.substring(0,sb.length()-1)+")"+valSb.substring(0,sb.length()-1)+")";
		 if(this.baseDao.insert(sql,objArr)>1){
			 return Result.succ();
		 }else{
			 return Result.err("保存失败!");
		 }
	}
	
	public void checkVal(Object vla,Map<String ,Object>map){
		
	}
	public  List<Map<String,Object>> getCusFile(Map<String,Object> map){
		
		String viewFieldList=""+getEntId()+map.get("vt.viewName");
		Object obj= Cache.get(viewFieldList);
		if(obj==null){
			String sql="select cf.name,cf.field,cf.type,cf.tableName from cusField cf join viewTable vt "
					+ "on cf.cusField =vt.cusFieldId "
					+ "where vt.viewName=? and vt.entId=?";
			List<Map<String,Object>> listMap = this.baseDao.queryForListMap(sql,map.get("vt.viewName"),getEntId());
			Cache.put(viewFieldList,listMap);
			return listMap;
		}else{
			return (List<Map<String, Object>>) obj;
		}
	}
	public long getEntId(){
		User user= UserInfo.userLocal.get();
		user.getEntId();
		System.out.println("thread local entid=="+user.getEntId());
		return 1l;
	}
	public Map<String,Object> getPage(Map<String,Object> map,String tableName){
		//这里应该有权限控制，管理员权限，企业权限和用户权限
		 Long  total = baseDao.queryForLong("select count(1) from "+tableName+" where 1=1 "+getCondition(map));
		 List<Map<String,Object>>listMap =baseDao.queryForListMap("select * from "+tableName+" where 1=1 "+getCondition(map)+getOrder(map)
						+" limit ?,? ",Long.parseLong((String)map.get("page")),Long.parseLong((String)map.get("rows")));
		 Map<String,Object> retMap = new HashMap<String,Object>();
		 retMap.put(TableConst.TOTAL,total);
		 retMap.put(TableConst.ROWS, listMap);
		 return retMap;
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
	 
	public Map<String,Object> getPage(Long total,List<Map<String,Object>> rows){
		 Map<String,Object> retMap = new HashMap<String,Object>();
		 retMap.put(TableConst.TOTAL,total);
		 retMap.put(TableConst.ROWS, rows);
		 return retMap;
	}
	
	public <T> T getObj(Map<String,Object>  map,Class<T> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		T  ins= clazz.newInstance();
		Method[] methodArr =clazz.getDeclaredMethods();
		String methodName=null,fieldName=null;
		
		for(Method method : methodArr){
			methodName  = method.getName();
			fieldName=methodName.substring(3,fieldName.length());
			method.invoke(ins,map.get(fieldName.substring(0, 1).toLowerCase()+fieldName.substring(1,fieldName.length())));
		}
		return ins;
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
	

	
	
}
