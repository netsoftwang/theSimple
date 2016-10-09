package com.palace.seeds.others;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;


public class Ehcache {

	
	public static void main(String[] args) {
		new Ehcache().init();
	}
	public void init(){
		CacheManager manager= CacheManager.create();
		Cache  myCache =new Cache("myCache",5000, false, false, 5, 2);
		manager.addCache(myCache);
		Element ele=new Element("key", new String("value"));
		myCache.put(ele);
		Element obj = myCache.get("key");
		System.out.println(obj.getObjectValue());
		
		ele=new Element(new String("key2"), new Long(1222));
		myCache.put(new Element(new String("keyStr"), new Long("34234")));
		System.out.println(myCache.get(new String("keyStr")).getObjectValue());
		System.out.println("the end");
	
	
		myCache.put(new Element(new Inner(),new String("ddssd")));
	}
	
class Inner{
	
}
}
