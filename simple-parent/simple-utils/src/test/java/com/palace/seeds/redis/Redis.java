package com.palace.seeds.redis;

import java.util.List;

import javax.swing.JDialog;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Redis {
	
	

	@Test
	public void testMsg(){
		Jedis jedis=new Jedis("192.168.209.131",6379);
		
		jedis.set("firstKey","javaFirstValue");
		jedis.set("secodKey","1");
		
		jedis.multi();
		jedis.set("aa", "bb");
		
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jedis.get("aa"));
		 
/*		byte[] b ="abc".getBytes();
		for(int i=0;i<b.length;i++){
			System.out.println("i="+b[i]);
		}
		jedis.set("abc".getBytes(),"aa".getBytes());
		System.out.println("aa".getBytes());
		jedis.incr("abc".getBytes());
		byte[] by=jedis.get("abc".getBytes());
		System.out.println("abc:"+jedis.get("abc".getBytes()));
		jedis.set("thirdKey".getBytes(),"aa".getBytes());
		jedis.incr("secondKey");
		System.out.println("secondKey:"+jedis.get("secondKey"));
		System.out.println(jedis.get("firstKey"));*/
/*		jedis.lpush("list", "linux");
		jedis.lpush("list", "windows");
		List<String> list=jedis.lrange("list", 0,-1);
		for(String l :list){
			System.out.println(l);
		}*/
	}

}
