package com.palace.seeds.service;

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

@Service
public class TreeNodeService extends BaseDao implements ITreeService{
	@Resource
	private ITreeDao treeDao;
	@Resource
	private ITreeNodeDao treeNodeDao;
	/**
	 * 添加节点，包含entId，为那个tree，下面的那个节点添加添加新节点
	 * @param params
	 * @return
	 */
	public Result addNode(Map<String,Object> params){
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
		long i=treeNodeDao.insert("insert into treeNode(entId,parentId,uniquId,type,name,icon,action,url,left,right"
				,MapUtils.getString(params,"entId","0")
				,MapUtils.getString(params,"parentId","0")
				,MapUtils.getString(params,"uniquId")
				,MapUtils.getString(params,"type")
				,MapUtils.getString(params,"name")
				,MapUtils.getString(params,"icon","")
				,MapUtils.getString(params,"action","")
				,MapUtils.getString(params,"url",""),left+1,left+2);
		if(i>0)
			return Result.succ();
		else
			return Result.err("树节点添加失败!");
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
