package com.palace.seeds.util;

public class UUIDKit {

	public static  String getUsigned(){
		return java.util.UUID.randomUUID().toString().replace("-","");
	}
}
