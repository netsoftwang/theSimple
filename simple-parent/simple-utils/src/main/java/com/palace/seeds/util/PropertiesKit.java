package com.palace.seeds.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;

public class PropertiesKit {
	static Map<String,Object> map=new HashMap<String, Object>();
	static Properties p;
	static {
		URL url = PropertiesKit.class.getClass().getResource("/");
		String path = url.getPath();
		try {
			p=new Properties();
			p.load(new InputStreamReader(new FileInputStream(new File(path+"conf.properties"))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getPro(String name){
		return (String)p.get(name);
	}
	public static Integer getProToInt(String name){
		return (Integer)p.get(name);
	}
	public static Long getProToLong(String name){
		return (Long)p.get(name);
	}
	@Test
	public void testPath(){
		
	}
}
