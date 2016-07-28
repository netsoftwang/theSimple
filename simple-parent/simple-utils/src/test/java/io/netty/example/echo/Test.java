package io.netty.example.echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;


public class Test {

	
	
	 
	
	public static void main(String[] args) throws Exception {
		 final char[] DIGITS = "0123456789abcdef".toCharArray();
	        for (int i = 0; i < 256; i ++) {
	        	System.out.println("msg: "+(i << 1)+";;;:"+(DIGITS[i >>> 4 & 0x0F]));
	        	System.out.println("msg: "+((i << 1)+1)+";;;:"+DIGITS[(i & 0x0F)]);
	        /*    HEXDUMP_TABLE[ i << 1     ] = DIGITS[i >>> 4 & 0x0F];
	            HEXDUMP_TABLE[(i << 1) + 1] = DIGITS[i       & 0x0F];*/
	        }
	
		 
	}
	
	static void print(Object o) throws Exception{
		Selector selector= SelectorProvider.provider().openSelector();
		ServerSocketChannel sc = ServerSocketChannel.open();
		sc.socket().bind(new InetSocketAddress(9999));
		sc.configureBlocking(false);
		sc.register(selector,SelectionKey.OP_ACCEPT,"name");
		
		while(true){
			if(selector.select(1000l)>0){
				Set<SelectionKey> sk = selector.selectedKeys();
				if(sk!=null&&sk.size()>0){
					Iterator<SelectionKey> iter=sk.iterator();
					if(iter.hasNext()){
						SelectionKey key = iter.next();
						Object obj = key.attachment();
						System.out.println(obj);
					}
				}
				
				
			}
			System.out.println("runing ");
			Thread.currentThread().sleep(2000);
		}
		
	}
}
