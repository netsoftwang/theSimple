package com.palace.seeds;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class MyBeanTest {

	public void run() throws Exception{
		MBeanServer ms =  ManagementFactory.getPlatformMBeanServer();
		ObjectName objName= new ObjectName("com.palace.seeds:type=MyBeanInsMBean");
		ms.registerMBean(new MyBeanInsMBean(), objName);
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("my bean test is run");
		new MyBeanTest().run();
	}
}
