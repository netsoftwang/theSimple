package com.palace.seeds;

import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoHandler;
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
	
	

}
