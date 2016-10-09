package com.palace.seeds.others;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaSSLServer {

	
	public void run(){
	/*	NioSocketAcceptor acceptor= new NioSocketAcceptor();
		//acceptor.addListener();  what is the ioListener
		acceptor.setHandler(new IoHandler() {
			
			@Override
			public void sessionOpened(IoSession session) throws Exception {
				 System.out.println("session opend ");
				
			}
			
			@Override
			public void sessionIdle(IoSession session, IdleStatus status)
					throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sessionCreated(IoSession session) throws Exception {
				System.out.println("session create");
				
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
				System.out.print("message receive");
				
			}
			
			@Override
			public void exceptionCaught(IoSession session, Throwable cause)
					throws Exception {
				// TODO Auto-generated method stub
				
			}
		});*/
	}
}
