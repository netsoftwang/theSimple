package com.palace.seeds.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;

import com.palace.seeds.dao.BaseDao;
import com.palace.seeds.dao.ITreeDao;
import com.palace.seeds.dao.ITreeNodeDao;
import com.palace.seeds.helper.Result;
import com.palace.seeds.helper.TableConst;
import com.palace.seeds.util.StringKit;

@Service
public class TreeNodeService extends BaseService implements ITreeService{
	@Resource
	private ITreeDao treeDao;
	@Resource
	private ITreeNodeDao treeNodeDao;
	
	
	/**
	 * 当前节点1，位节点1添加子节点，那么在表中建立关联的记录，
	 * 	如果还是同样的节点描述，查询时根据父节点获取子节点，只需要在父节点保存的表中查询即可
	 *  如果为节点1添加其他类型的节点，查询时需要从其他表中获取数据，这种节点是叶子节点，因为是实际的数据，不在具有树状结构的描述
	 * 节点1的子节点既有和节点1在同样表中的节点，还有其他表中的节点(叶子节点)
	 * 节点1的子节点都是和节点1一样在同一张表中的节点
	 * 节点1的子节点都是和节点1不在同一张表中
	 * 
	 * 如果有不同表的节点数据，就需要一个中间过渡节点，过渡节点和节点一样都是和父节点在同一张表中，但是过渡节点下挂在的是其他表中的数据
	 */
	
	/**
	 * 添加节点，包含entId，为那个tree，下面的那个节点添加添加新节点
	 * @param params
	 * @return
	 */
	public Result add(Map<String,Object> params){
		Map<String,Object> parentTreeMap = treeNodeDao.findById(TableConst.TREE,MapUtils.getString(params,TableConst.ID),"left","right");
		Integer left=MapUtils.getInteger(parentTreeMap,"left");
		Integer right=MapUtils.getInteger(parentTreeMap,"right");

		treeNodeDao.update(TableConst.TREENODE," right=right+2 ", " "
				+ "name='"+MapUtils.getString(params,"name")
				+" and entId= "+MapUtils.getString(params,"entId","0")
				+" and right >="+right);
		treeNodeDao.update(TableConst.TREENODE,"left=left+2", 
				" name='"+MapUtils.getString(params,"name")
				+" and entId= "+MapUtils.getString(params,"entId","0")
				+" and left >"+left);
		long i=treeNodeDao.insert("insert into treeNode(parentId,entId,name,field,type,status,"
				+ "theClass,url,icon,action,isHasChild,left,right,tableName,condition,createTime)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
				,MapUtils.getString(params,"parentId","0")
				,MapUtils.getString(params,"entId","0")
				,MapUtils.getString(params,"name")
				,MapUtils.getString(params,"field")
				,MapUtils.getString(params,"type","0")
				,MapUtils.getString(params,"status","")
				,MapUtils.getString(params,"theClass","")
				,MapUtils.getString(params,"url","")
				,MapUtils.getString(params,"icon","")
				,MapUtils.getString(params,"action","")
				,MapUtils.getString(params,"isHasChild","")
				,left+1
				,left+2
				,MapUtils.getString(params,"tableName","")
				,MapUtils.getString(params,"condition","")
				,System.currentTimeMillis()/1000);
		if(i>0)
			return Result.succ();
		else
			return Result.err("树节点添加失败!");
	}
	
	public Result edit(Map<String,Object> params){
		//treeDao.update(tableName, sql, condition)
		String fields="name,field,type,status,theClass,url,icon,action,isHasChild,tableName,condition";
		Integer i = treeDao.update(TableConst.TREENODE,
				getSetSql(fields),
				MapUtils.getString(params,TableConst.ID),
				getParams(fields, params));
		if(i>0){
			return Result.succ();
		}else{
			return Result.err("树节点修改失败!");
		}
	}
	
	public Result queryNode(Map<String,Object> params){
		
		
		 params.put("entId",0);
	/*	 List<Map<String,Object>> listMap= treeNodeDao.queryForListMap(
		 		"select  tn1.* from treeNode tn1 join treeNode tn2 on tn1.id=tn2.id "
		 		+ " where  tn2.id=? and tn1.left >tn2.left and tn1.right < tn2.right and tn1.name=? and tn1.entId=?"
		 		,MapUtils.getString(params,TableConst.ID)
		 		,MapUtils.getString(params,"name")
		 		,MapUtils.getString(params,"entId"));*/
		 List listMap= treeNodeDao.queryForListMap(
				 "select * from treeNode where parentId=?",MapUtils.getString(params,TableConst.ID));
		 listMap.add(new HashMap().put("child",
				 treeNodeDao.queryForListMap("select * from ? where treeNodeId=?"
						 ,MapUtils.getString(params,TableConst.TABLENAME)
						 ,MapUtils.getString(params,TableConst.ID)))
				 );
		return  null;
				 
	}

}
