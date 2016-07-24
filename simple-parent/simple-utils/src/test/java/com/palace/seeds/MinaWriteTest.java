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
		this.acceptor.setHandler(new IoHandler() {
<<<<<<< HEAD
			
			@Override
			public void sessionOpened(IoSession session) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sessionIdle(IoSession session, IdleStatus status)
					throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sessionCreated(IoSession session) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sessionClosed(IoSession session) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void messageSent(IoSession session, Object message) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void messageReceived(IoSession session, Object message)
					throws Exception {
				session.write("result:"+message);
=======
			@Override
			public void sessionOpened(IoSession session) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sessionIdle(IoSession session, IdleStatus status)
					throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sessionCreated(IoSession session) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sessionClosed(IoSession session) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void messageSent(IoSession session, Object message) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void messageReceived(IoSession session, Object message)
					throws Exception {
>>>>>>> branch 'master' of git@github.com:netsoftwang/theSimple.git
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void inputClosed(IoSession session) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void exceptionCaught(IoSession session, Throwable cause)
					throws Exception {
				// TODO Auto-generated method stub
				
			}
		});
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
