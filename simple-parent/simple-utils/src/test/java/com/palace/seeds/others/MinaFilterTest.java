package com.palace.seeds.others;

import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;

public class MinaFilterTest extends IoFilterAdapter {

	@Override
	public void sessionCreated(NextFilter nextFilter, IoSession session)
			throws Exception {
		
		System.out.println("do what you want to do ");
		nextFilter.messageReceived(session, "dddsss");
		super.sessionCreated(nextFilter, session);
	}
}
