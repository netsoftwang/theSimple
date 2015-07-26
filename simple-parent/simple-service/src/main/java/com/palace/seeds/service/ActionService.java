package com.palace.seeds.service;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palace.seeds.dao.BaseDao;
import com.palace.seeds.helper.Result;
import com.palace.seeds.model.Action;

@Service
public class ActionService extends BaseService{

	public Result add(Map<String,Object>params){
		 String sql="insert into action(entId,actionVal,actionGroup) values("+MapUtils.getString(params,"entId")+","
				 +MapUtils.getString(params,"actionVal")
				 +MapUtils.getString(params,"actionGroup")+")";
		 if(this.baseDao.execute(sql)>0)
			 return Result.succ();
		 else
			 return Result.err("权限添加出错");
	}
	public Map<String,Object> getPage(Map<String,Object> params){
		String sql=" from action where entId=? ";
		if(!"0".equals(MapUtils.getString(params, "actionGroup","0")))
			sql+=" and actionGroup=? ";
		params.put("total",this.baseDao.queryForLong("select count(1) "+ sql,
				MapUtils.getLong(params, "entId",0l),"0".equals(MapUtils.getString(params,"actionGroup"))?"":MapUtils.getString(params,"actionGroup")));
		params.put("rows",this.baseDao.queryForListMap("select * "+sql+" limit ?,?",
				MapUtils.getLong(params,"entId",0l),"0".equals(MapUtils.getString(params,"actionGroup"))?"":MapUtils.getString(params,"actionGroup"),
				MapUtils.getLong(params,"page"),MapUtils.getLong(params,"rows")));
		return params;
	}
	public Result edit(Map<String,Object> params){
		if(this.baseDao.update("action", "actionVal='"+MapUtils.getString(params,"actionVal")+"',actionGroup='"+MapUtils.getString(params,"actionGroup")+"' ",
				 "id="+MapUtils.getString(params,"id"))>1)
			return Result.succ();
		else
			return Result.err("修改失败");
		
	}
	
}
