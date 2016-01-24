package com.palace.seeds.chain;

public class MyEntery {

	public MyEntery pre;
	public MyEntery next;
	public Filter filter;
	public MyEntery getPre() {
		return pre;
	}
	public void setPre(MyEntery pre) {
		this.pre = pre;
	}
	public MyEntery getNext() {
		return next;
	}
	public void setNext(MyEntery next) {
		this.next = next;
	}
	public Filter getFilter() {
		return filter;
	}
	public void setFilter(Filter filter) {
		this.filter = filter;
	}
	
	
	
	
}
