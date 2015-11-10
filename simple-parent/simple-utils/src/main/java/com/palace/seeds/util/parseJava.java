package com.palace.seeds.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class parseJava {

	public void run() throws IOException{
		String path="c:\\wzj\\java\\MapTest.java";
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		 
		 do{
			 String str =  br.readLine();
			 if(str!=null){
				 System.out.println(str+":::"+str.length());
			 }
		 }while(true);
	}
	
	boolean start=false,end=false;
	int count=0;
	
	public static String classFlag=" class ", methodFlag=" void ";
	
	boolean  classStart=false,classEnd =false;
	boolean methodStart=false,methodEnd=false;
	int currentNum =0;
	public void parse(BufferedReader br) throws IOException{
		
		 do{
			 String str =  br.readLine();
			 currentNum++;
			 if(str.contains(classFlag)){
				 classStart=true;
			 }
			System.out.println(str+":::"+str.length()+":::"+currentNum);
			
		 }while(true);
	}

	public void methodParse(String str){
		if(str.contains(methodFlag)){
			
		}
	}
	public static void main(String[] args) throws IOException {
		new parseJava().run();
	}
	
	
	class asda{
		void main(){
			new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
				}
			};
		}
	}
	
}
