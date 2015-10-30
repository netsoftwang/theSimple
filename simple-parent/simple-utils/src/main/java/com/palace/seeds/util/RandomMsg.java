package com.palace.seeds.util;

import java.util.Random;

public class RandomMsg {

	 
	public static final char[] c1=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l'
		,'m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public static final char[] c2=new char[]{'A','B','C','D','E','F','G','H','I','J','K','L'
		,'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public static final char[] character=new char[]{'0','1','2','3','4','5','6','7','8','9'};
	
	public static Random random = new Random();
	
	/*
	 * 指定长度的随机字符串，全部都小写
	 */
	static StringBuilder sb1= new StringBuilder(22); 
	public static String randomLowerStr(int num){
		sb1.delete(0, sb1.length());
		for(int i=0;i<num;i++){
			sb1.append(c1[random.nextInt(22)]);
		}
		return sb1.toString();
	}
	public static String nextStr(){
		return randomLowerStr(10);
	}
	
	
	/*
	 * 指定长度的随机字符串，大小写
	 */
	static StringBuilder sb2= new StringBuilder(22); 
	public static String randomStr(int num){
		sb2.delete(0, sb2.length());
		for(int i=0;i<num;i++){
			if(random.nextBoolean())
				sb2.append(c1[random.nextInt(22)]);
			else 
				sb2.append(c2[random.nextInt(22)]);
		}
		return sb2.toString();
	}
	
	/*
	 * 指定长度的随机字符串，全部都小写,线程安全的
	 */
	StringBuilder sb3;
	public static  synchronized String randomStrSyc(int num){
		StringBuilder sb3= new StringBuilder(22); 
		sb1.delete(0, sb3.length());
		for(int i=0;i<num;i++){
			sb3.append(c1[random.nextInt(22)]);
		}
		return sb3.toString();
	}
}
