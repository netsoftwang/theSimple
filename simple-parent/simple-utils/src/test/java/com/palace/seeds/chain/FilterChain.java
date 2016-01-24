package com.palace.seeds.chain;

public class FilterChain {

	MyEntery e;
	
	public void begin(){
		
		Filter f = e.filter;
		//do something
		
		
		//next 就是链本身，next.open("","")
		
		MyEntery netxt = e.next;
		netxt.getFilter().open(netxt,"");
		
		
	}
	
	
	
}
