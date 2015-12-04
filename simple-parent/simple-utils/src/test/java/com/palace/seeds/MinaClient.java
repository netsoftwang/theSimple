package com.palace.seeds;

import java.net.InetSocketAddress;

import javax.mail.internet.InternetAddress;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MinaClient {

	public NioSocketConnector connector;
	public void run(){
		connector= new NioSocketConnector();
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));  
		connector.setHandler(new IoHandler() {
			
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
				System.out.println(message);
				
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
		
		ConnectFuture cf = this.connector.connect(new InetSocketAddress("localhost", 9500));
		this.session = cf.getSession();
	}
	IoSession session;
	public void send(){
		 
	 WriteFuture wf = session.write(new String("dsasdf"));
	 //
	 
	 
	}
	
}
