package com.palace.seeds.service;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;

import com.palace.seeds.helper.Result;

@Service
public class TreeService extends BaseService{

	public Result add(Map<String,Object>params){
		 String sql="insert into tree(entId,label,name,des) values("+MapUtils.getString(params,"entId")+","
				 +MapUtils.getString(params,"label")
				 +MapUtils.getString(params,"name")
				 +MapUtils.getString(params,"des")+")";
		 if(this.baseDao.execute(sql)>0)
			 return Result.succ();
		 else
			 return Result.err("树添加出错");
	}
	/**
	 * 树列表
	 * @param params
	 * @return
	 */
	public Map<String,Object> getPage(Map<String,Object> params){
		String sql=" from tree where entId=? ";
		params.put("total",this.baseDao.queryForLong("select count(1) "+ sql,
				MapUtils.getLong(params, "entId",0l)));
		params.put("rows",this.baseDao.queryForListMap("select * "+sql+" limit ?,?",
				MapUtils.getLong(params,"entId",0l),MapUtils.getLong(params,"page"),MapUtils.getLong(params,"rows")));
		return params;
	}
	public Result edit(Map<String,Object> params){
		if(this.baseDao.update("tree", "label='"+MapUtils.getString(params,"label")+
				"',name='"+MapUtils.getString(params,"name")+"',des='"+MapUtils.getString(params,"des")+"' ",
				 "id="+MapUtils.getString(params,"id"))>1)
			return Result.succ();
		else
			return Result.err("修改失败");
	}
	
}
