package com.palace.seeds.helper;

import java.util.HashMap;
import java.util.Map;

public class Cache {
	/**
	 * 考虑一下多线程带来的问题
	 */
	private static Map<String,Object> map=new HashMap<String,Object>();
	
	public static Object get(String key){
		return map.get(key);
	}
	public static void put(String key ,Object obj){
		map.put(key,obj);
	}
	
}
