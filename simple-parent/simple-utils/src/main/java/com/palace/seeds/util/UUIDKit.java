package com.palace.seeds.util;

public class UUIDKit {

	public static  String  uuid(){
		return java.util.UUID.randomUUID().toString().replace("-","");
	}
}
