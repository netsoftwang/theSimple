package com.palace.seeds.mina;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;

import org.junit.Test;

public class MainThread {

	@Test
	public void test1() throws Exception{
		Selector sele= SelectorProvider.provider().openSelector();
		while(true){
			System.out.println("begin");
			int i =sele.select();
			System.out.println(i);
			Thread.currentThread().sleep(1000);
		}
	}
}
