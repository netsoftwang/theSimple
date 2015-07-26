package com.palace.seeds.model;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.palace.seeds.dao.BaseDao;

public class Model<T> extends BaseDao{
	
	private Class<T> clazz;
	private String tableName="";
	private Long entId;
	private Map<String,Object> params=new HashMap<String,Object>();
	
	public Model(Class<T> clazz) {
		this.clazz=clazz;
		this.tableName=clazz.getName();
	}
	public Model(Class<T> clazz,String tableName) {
		super();
		this.clazz=clazz;
		this.tableName=tableName;
	
	}
	public Model(Class<T> clazz, Map<String, Object> params) {
		super();
		this.clazz = clazz;
		this.params = params;
	}
	public Model(String tableName, Map<String, Object> params) {
		super();
		this.tableName = tableName;
		this.params = params;
	}
	public Model(Class<T> clazz, String tableName, Map<String, Object> params) {
		super();
		this.clazz = clazz;
		this.tableName = tableName;
		this.params = params;
	}
	public Class<T> getClazz() {
		return clazz;
	}
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	public void setAttr(String name,Object val){
		params.put(name, val);
	}
	public Object getAttr(String name){
		return params.get(name);
	}
	public String getAttrStr(String name){
		return params.get(name)==null ? null:(String)name;
	}
	
	public Long getAttrLong(String name){
		 Object obj= params.get(name);
		 if(obj==null)
			 return null;
		 else{
			 if(obj instanceof String)
				 return Long.parseLong((String)obj);
			 else if(obj instanceof Long)
				 return (Long)obj;
			 else if(obj instanceof Integer)
				 return (Long)obj;
			 else 
				 return null;
		 }
	}
	
	
	 
	
	Map<String,Object> map= new HashMap<String,Object>();
	public Map<String,Object> getFields(){
		if(clazz!=null){
			Field[] fields = clazz.getFields();
			for(int i=0;i<fields.length;i++){
				map.put(fields[i].getName(),fields[i].getType().getSimpleName());
			}
		}else{
			String sql="select * from cusFields ";
		/*	queryForObj(sql,new ResultSetExtractor<CusField>() {

				@Override
				public CusField extractData(ResultSet rs) throws SQLException,
						DataAccessException {
					 
					return null;
				}
			});*/
		}
		return null;
	}
	
	
	
	public static void main(String[] args) {
		Field[] fields=	CusField.class.getDeclaredFields();
		for(int i=0;i<fields.length;i++){
			Field f  = fields[i];
			String name= f.getType().getSimpleName();
		}
	}
	public <T> T getInstance(Class<T> clazz,Map<String,Object>  params){
		Field[] fields = clazz.getDeclaredFields();
		try {
			Object obj = clazz.newInstance();
			for(Map.Entry<String,Object> entry : params.entrySet()){
				
				String fieldStr= entry.getKey();
				Field field= clazz.getField(fieldStr);
				String name= field.getType().getName();
				field.getType().getSimpleName();
				clazz.getMethods();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
}
