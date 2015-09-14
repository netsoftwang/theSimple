package com.palace.seeds.service;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palace.seeds.dao.ITablesDao;
import com.palace.seeds.helper.Result;
import com.palace.seeds.helper.TableConst;
import com.palace.seeds.util.StringKit;

@Service
public class TablesService extends BaseService{
	
	@Autowired
	private ITablesDao tablesDao;
	public Result add(Map<String,Object> map){
		map.put(TableConst.TABLENAME,"tables");
		map.put(TableConst.ENTID, getEntId());
		Long id=tablesDao.save(map);
		if(id >0){
			return Result.succ().add(TableConst.ID,id);
		}else{
			return Result.err("保存失败");
		}
	}
	
	public Map<String,Object> getPage(Map<String,Object> map){
		return getPage(map,"tables");
	}

	public Result del(Map<String, Object> map) {
		String id= MapUtils.getString(map,TableConst.ID,"");
		if(StringKit.isEmpety(id))
			return Result.err("id信息获取失败");
		 if(this.baseDao.delById("tables",id)>0){
			return Result.succ();
		}else{
			return Result.err("表信息删除失败");
		}
	}
}
