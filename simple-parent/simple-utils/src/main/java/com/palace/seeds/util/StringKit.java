package com.palace.seeds.util;

public class StringKit {
	public  static  boolean isEmpety(String str){
		return str == null || "".equals(str.trim()) ? true : false;
	}
	
}
