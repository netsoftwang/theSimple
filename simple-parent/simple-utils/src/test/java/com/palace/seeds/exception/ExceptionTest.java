package com.palace.seeds.exception;

import java.io.IOException;

public class ExceptionTest {

	
	public void test1(){
		System.out.println("test1");
		throw new RuntimeException("test1 runtimeException");
	}

	public void test3() throws Exception{
		System.out.println("test3");
		throw new IOException("asdf");
	}
	public void test2(){
		System.out.println("test2");
		try{
			test1();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("test2 end");
	}
	
	public static void main(String[] args) {
		new ExceptionTest().test2();
		System.out.println("main");
	}
	
}
