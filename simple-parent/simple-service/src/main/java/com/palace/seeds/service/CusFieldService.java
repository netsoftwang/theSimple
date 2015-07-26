package com.palace.seeds.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.palace.seeds.dao.ICusFieldDao;

@Service
public class CusFieldService implements ICusFieldService{

	@Resource  
	private ICusFieldDao cusFieldDao;
	
	public Map getPage(Map<String, Object> params) {
		return cusFieldDao.getPage(params);
	}

}
