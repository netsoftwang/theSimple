package com.palace.seeds;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

public class NioTest {

	
	public void test(){
		try {
			Selector selector= SelectorProvider.provider().openSelector();
			int selectRes = selector.select(); 
			Set<SelectionKey>  set =selector.selectedKeys();
			SelectionKey sk = (SelectionKey) new Object();
			SelectableChannel ssc=sk.channel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void register() throws Exception{
		Selector selector= SelectorProvider.provider().openSelector();
        ServerSocketChannel channel = null;
        channel = ServerSocketChannel.open();
        ServerSocket socket = channel.socket();
        socket.bind(null,1);
        channel.register(selector, SelectionKey.OP_ACCEPT);
	}
}
