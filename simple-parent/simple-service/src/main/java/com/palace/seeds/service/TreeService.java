package com.palace.seeds.service;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;

import com.palace.seeds.helper.Result;
import com.palace.seeds.helper.TableConst;

@Service
public class TreeService extends BaseService{

	public Result add(Map<String,Object>params){
		if(this.baseDao.insert("insert into tree(entId,label,name,des,field_one,field_two) values(?,?,?,?,?,?)",
				 MapUtils.getString(params,"entId","")==""? getEntId():MapUtils.getString(params,"entId"),
				 MapUtils.getString(params,"label"),
				 MapUtils.getString(params,"name"),
				 MapUtils.getString(params,"des"),
				 MapUtils.getString(params,"field_one","def"),
				 MapUtils.getString(params,"field_two","def"))>0)
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
		params.put(TableConst.TOTAL,this.baseDao.queryForLong("select count(1) "+ sql,
				MapUtils.getLong(params, "entId",getEntId())));
		params.put(TableConst.ROWS,this.baseDao.queryForListMap("select * "+sql+" limit ?,?",
				MapUtils.getLong(params,"entId",getEntId()),MapUtils.getLong(params,"page"),MapUtils.getLong(params,"rows")));
		return params;
	}
	public Result edit(Map<String,Object> params){
		if(this.baseDao.update("tree","name=?,lable=?,des=?,field_one=?,field_two=?","id=?", 
				MapUtils.getString(params,"name"),
				MapUtils.getString(params,"label"),
				 MapUtils.getString(params,"des"),
				 MapUtils.getString(params,"field_one","def"),
				 MapUtils.getString(params,"field_two","def"),
				 MapUtils.getString(params,"id"))>0)
			return Result.succ();
		else
			return Result.err("修改失败");
	}
	
}
