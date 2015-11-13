package com.palace.seeds;

public class MyBeanInsMBean implements MyMBean {

	private int age;
	private String name;
	@Override
	public void printAge() {
		System.out.println(age);
		
	}

	@Override
	public void setAge(int age) {
		this.age=age;
	}

	@Override
	public void printName() {
		System.out.println(name);
		
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

}
