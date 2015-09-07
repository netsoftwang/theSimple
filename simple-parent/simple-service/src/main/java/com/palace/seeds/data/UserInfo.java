package com.palace.seeds.data;

import java.util.HashMap;
import java.util.Map;

import com.palace.seeds.model.User;

public class UserInfo {
	public static ThreadLocal<User> userLocal;
	private static Map<String,User> userMap = new HashMap<String,User>();
	public static void addUser(String serial ,User user){
		userMap.put(serial,user);
	}
	public static User getUser(String serial){
		return userMap.get(serial);
	}
	public static boolean checkUser(String serial){
		if(userMap.containsKey(serial)){
			return true;
		}else{
			return false;
		}
	}
	
}
