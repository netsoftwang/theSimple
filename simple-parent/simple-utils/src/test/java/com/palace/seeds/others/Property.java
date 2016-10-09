package com.palace.seeds.others;

public class Property {

	public static void main(String[] args) {
		if(args==null||args.length==0){
			System.out.println("null");
		}else{
			if("0".equals(args[0])){
				System.setProperty("catalina.base",args[1]);
				System.out.println("path ="+args[1]);
			}else {
				System.out.println("res path ="+System.getProperty("catalina.base"));
			}
		}
	}
}
