package io.netty.example.echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;


public class Test1 {

	public static void testaa(){
		System.out.println(SelectionKey.OP_ACCEPT);
	}
	
	public static void main(String[] args) throws Exception {
		print(null);
	}
	
	static void print(Object o) throws Exception{
		SocketChannel ch =  SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));
		ch.write(ByteBuffer.allocate(100).put("aenasda".getBytes()));
		Thread.currentThread().sleep(5000);
		System.out.println("ASDEFA");
		System.out.println("res:"+o);
	}
}
