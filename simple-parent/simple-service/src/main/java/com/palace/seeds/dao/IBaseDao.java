package com.palace.seeds.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao {

	public Map<String,Object> queryForMap(String sql,Object ...args);
	public List<Map<String,Object>> queryForListMap(String sql,Object ...args);
	public Long insert(String sql,Object...args);
	public Map<String,Object> findById(String tableName,String id);
	public Map<String,Object> findById(String tableName,String id,String ...columns);
	//public Map<String,Object> getPage(String totalSql,String objSql,Object args);
	public Long queryForLong(String sql,Object ...args);
	public <T> T queryForObj(String sql,Class<T> returnType , Object ...args);
	public Integer update(String tableName,String sql,String condition);
	public Long save(Map<String,Object> params);
}
