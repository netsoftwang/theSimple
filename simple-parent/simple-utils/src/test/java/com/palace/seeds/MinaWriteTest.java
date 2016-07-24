package com.palace.seeds;

import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaWriteTest {
	
	private NioSocketAcceptor acceptor;
	public void init() throws Exception{
		this.acceptor=new NioSocketAcceptor();
		this.acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));  
		
		this.acceptor.bind(new InetSocketAddress(9500));
	}
	
	public static void main(String[] args) {
		try {
			new MinaWriteTest().init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void ioBuffTest(){
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		try {
			FileChannel ch = new FileInputStream(new File("I:\\soft\\eclipse-jee-kepler-R-win32-x86_64--4.3.zip1")).getChannel();
			int i=ch.read(buffer);
			System.out.println(i);
			while( (i=ch.read(buffer))>0){
				System.out.println(i);
				i=0;
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
