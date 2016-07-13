package io.netty.example.echo;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;


public class Test {

	public static void main(String[] args) throws Exception {
		
		Selector selector= SelectorProvider.provider().openSelector();
		ServerSocketChannel sc = ServerSocketChannel.open();
		sc.socket().bind(new InetSocketAddress(9999));
		
		while(true){
			SocketChannel channel = sc.accept();
			SelectionKey sk = channel.register(selector,SelectionKey.OP_READ);
			System.out.println(sk.readyOps());
			
		}
		
		
		/*print(SelectionKey.OP_ACCEPT);
		print(SelectionKey.OP_CONNECT);
		print(SelectionKey.OP_READ);
		print(SelectionKey.OP_WRITE);*/
	}
	
	static void print(Object o){
		System.out.println("res:"+o);
	}
}
