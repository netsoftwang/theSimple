package com.palace.seeds.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.palace.seeds.helper.ConstVal;
import com.palace.seeds.helper.Result;
import com.palace.seeds.helper.TableConst;

@Repository
public class TreeDao extends BaseDao implements ITreeDao{

	public Long addNode(Map<String, Object> params) {
		getInsertSql(params);
		return insert((String)params.get(TableConst.SQL),(Object[])params.get(TableConst.SQLPARAMS));
	}
}
