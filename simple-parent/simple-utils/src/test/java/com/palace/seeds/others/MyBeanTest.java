package com.palace.seeds.others;


public class MyBeanTest {

	public void run() throws Exception{
	/*	MBeanServer ms =  ManagementFactory.getPlatformMBeanServer();
		ObjectName objName= new ObjectName("com.palace.seeds:name=My");
		ms.registerMBean(new My(), objName);
		HtmlAdaptorServer adapter = new HtmlAdaptorServer();  
	    adapter.setPort(9797);  
	    ms.registerMBean(adapter, new ObjectName("com.palace.seeds:name=My,port=9797"));  
	        adapter.start(); */ 
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("my bean test is run");
		new MyBeanTest().run();
		
	}
}
