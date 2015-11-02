package com.palace.seeds.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {
	
	private String name;
	private String email;
	private int age;
	
	
	public User(String name, String email, int age) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public static User getUserInstance(){
		return new User(RandomVal.nextStr(),RandomVal.randomNumStr(10)+"@qq.com",new Random().nextInt(30));
	}
	
	public List<User> getUserList(int num){
		ArrayList<User> list = new ArrayList<User>();
		for(int i=0;i<num;i++){
			list.add(getUserInstance());
		}
		return list;
	}
}
