package com.palace.seeds.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Repository;

import com.palace.seeds.helper.TableConst;

@Repository
public class CusFieldDao extends BaseDao implements ICusFieldDao{

	public Map getPage(Map<String, Object> params) {
		Integer page=MapUtils.getInteger(params,"page",0);
		page=page==1?0:page;
		Integer rows=MapUtils.getInteger(params,"rows",10);
		Long entId=MapUtils.getLong(params,"entId",0l);
		String con_tableName=MapUtils.getString(params,"con_tableName","customer");
		Map<String,Object> resMap=new HashMap<String, Object>();
		String sql="select * from cusField where entId=? and CFTableName=?  limit ?,?";
		String countSql="select count(1) from cusField where entId=? and  CFTableName=?";
		resMap.put(TableConst.TOTAL,queryForLong(countSql,entId,con_tableName));
		resMap.put(TableConst.ROWS,queryForListMap(sql,entId,con_tableName,page,rows));
		return  resMap;
	}
 
	
}

 