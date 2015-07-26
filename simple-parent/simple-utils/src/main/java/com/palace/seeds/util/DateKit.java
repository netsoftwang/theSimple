package com.palace.seeds.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateKit {

	
	public String getNow(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		return sdf.format(Calendar.getInstance().getTime());
	}
	public String getNowYMD(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(Calendar.getInstance().getTime());
	}
	public long getNowMillis(){
		return System.currentTimeMillis();
	}
	//将毫秒转化成指定格式的时间串
	public  String millToSDF(Long val){
		 return  new SimpleDateFormat("yyyy-MM-dd HH:ss:mm").format(new Date(val));
	}
	
	public long get(int month, int day,int hour,int sec){
		Calendar c=Calendar.getInstance();
		if(month>0)
			c.set(Calendar.MONTH,month);
		if(day>0)
			c.set(Calendar.DATE,day);
		if(hour>0)
			c.set(Calendar.HOUR, hour);
		if(sec>0)
			c.set(Calendar.SECOND, sec);
		return c.getTimeInMillis();
	}
}
