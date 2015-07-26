package com.palace.seeds.dao;

import java.util.Map;

import com.palace.seeds.helper.Result;

public interface ITreeDao  extends IBaseDao{

	Long addNode(Map<String, Object> params);

}
