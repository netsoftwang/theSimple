package com.palace.seeds.util.collection;

import java.util.Map;

public class MapKit {
	
	public static  String getString(Map map,String key,Object def){
		
		Object obj = map.get(key);
		if(obj==null||obj.toString().isEmpty()){
			return (String)def;
		}else{
			return obj.toString();
		}
	}
	
	public static  String getString(Map map,String key){
		Object obj = map.get(key);
		if(obj==null||obj.toString().isEmpty()){
			return "";
		}else{
			return obj.toString();
		}
	}

}
