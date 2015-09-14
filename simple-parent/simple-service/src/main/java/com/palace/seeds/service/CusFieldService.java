package com.palace.seeds.service;

import java.lang.reflect.Field;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;

import com.palace.seeds.dao.ICusFieldDao;
import com.palace.seeds.helper.Result;
import com.palace.seeds.helper.TableConst;
import com.palace.seeds.model.CusField;
import com.palace.seeds.util.StringKit;

@Service
public class CusFieldService extends BaseService implements ICusFieldService{

	@Resource  
	private ICusFieldDao cusFieldDao;
	
	public Map getPage(Map<String, Object> map) {
		return cusFieldDao.getPage(map);
	}
	@Override
	public Result del(Map<String, Object> map) {
		String id= MapUtils.getString(map,TableConst.ID,"");
		if(StringKit.isEmpety(id))
			return Result.err("id信息获取失败");
		 if(this.baseDao.delById("cusField",id)>0){
			return Result.succ();
		}else{
			return Result.err("字段删除失败");
		}
	}
	@Override
	public Result edit(Map<String, Object> map) {
		String id= MapUtils.getString(map,TableConst.ID,"");
		if(StringKit.isEmpety(id))
			return Result.err("id信息获取失败");
		map.remove(TableConst.ID);
		Result validateRes= validate(map);
		if(validateRes.getCode()-Result.ERROR_CODE==0)
			return validateRes;
		if(this.baseDao.updateById("cusField",id, map)>0){
			return Result.succ();
		}else{
			return Result.err("字段保存错误");
		}
	}
	
	public Result save(Map<String,Object>  map){
		map.put(TableConst.TABLENAME,"cusField");
		map.put(TableConst.ENTID,getEntId());
		Result validateRes= validate(map);
		if(validateRes.getCode()-Result.ERROR_CODE==0)
			return validateRes;
		if(this.baseDao.save(map)>0){
			return Result.succ();
		}else{
			return Result.err("字段保存错误");
		}
	}
	
	
	public Result validate(Map<String,Object> map){
		String tableNameC = MapUtils.getString(map,"CFTableName","");
		if(StringKit.isEmpety(tableNameC))
			return Result.err("表名称不能为空!");
			
		String fieldNameZH= MapUtils.getString(map,"name","");
		if(StringKit.isEmpety(fieldNameZH))
			return Result.err("字段的中文名称不能为空");
		
		String field = MapUtils.getString(map,"field","");
		if(StringKit.isEmpety(field))
			return Result.err("字段名不能为空");
		
		String type=MapUtils.getString(map,"CFType","");
		if(StringKit.isEmpety(type))
			return  Result.err("字段类型不能为空");
		
		Integer viewNum = MapUtils.getInteger(map,"viewNum",-1);
		if(viewNum>255|| viewNum<=0)
			return  Result.err("字段的序号在1到255之间");
		
		Integer width = MapUtils.getInteger(map,"CFWidth",-1);
		if(width>100|| width<0)
			return  Result.err("字段的宽度在1到100之间");
		return Result.succ();		
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
