package com.palace.seeds.util;

import java.util.List;
import java.util.Map;

public class JsonKit {

	public static String mapToJson(Map<String,Object> map){
		StringBuilder sb=new StringBuilder(200);
		sb.append("{\"");
		for(Map.Entry<String,Object> entry : map.entrySet()){
			sb.append(entry.getKey()).append("\":");
			Object obj= entry.getValue();
			if(obj instanceof String || obj instanceof Character || obj instanceof Byte){
				sb.append("\"").append(obj).append("\"");
			}else if(obj instanceof Long || obj instanceof Integer||obj instanceof Float || obj instanceof Double ){
				sb.append(obj);
			}else if(obj instanceof Boolean){
				sb.append(obj);
			}else if(obj instanceof List){
				sb.append(listToJson((List)obj));
			}else if(obj instanceof Map){
				sb.append(mapToJson((Map)obj));
			}
			sb.append(",");
		}
		if(sb.length()>2){
			 String sbStr= sb.substring(0,sb.length()-1);
			 return sbStr+"}";
		}else
			return "{}";
	}
	public static String listToJson(List<Object> list){
		StringBuilder sb = new StringBuilder(200);
		sb.append("[");
		for(int i=0;i<list.size();i++){
			Object obj = list.get(i);
			if(obj ==null){
				sb.append("null");
			}else if(obj instanceof Map){
				sb.append(mapToJson((Map)obj));
			}else if(obj instanceof List){
				sb.append(listToJson((List)obj));
			}else if(obj instanceof String || obj instanceof Character || obj instanceof Byte){
				sb.append("\"").append(obj).append("\"");
			}else if(obj instanceof Long || obj instanceof Integer || obj instanceof Float || obj instanceof Double){
				sb.append(obj);
			}else if(obj instanceof Boolean ){
				sb.append(obj);
			}
			sb.append(",");
		}
		if(sb.length()>1){
			 String sbStr= sb.substring(0,sb.length()-1);
			 return sbStr+"]";
		}else
			return "[]";
	}
}
