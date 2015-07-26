package com.palace.seeds.helper;

import java.util.HashMap;
import java.util.Map;

public class Result {

	public static final Integer WARING_CODE =100;
	public static final Integer SUCC_CODE   =200;
	public static final Integer ERROR_CODE  =400;
	public Map<String,Object> res=null;
	private String msg;
	private Integer code;
	
	public Result(Integer code,String msg){
		this.msg=msg;
		this.code=code;
	}
	public static Result succ(){
		return new Result(200,"ok");
	}
	public static Result err(String msg){
		return new Result(400,msg);  
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}

	public Map<String, Object> getRes() {
		return res;
	}

	public void setRes(Map<String, Object> res) {
		this.res = res;
	}
	
	public Result add(String key,Object val){
		if(res==null)
			res=new HashMap<String,Object>();
		res.put(key, val);
		return this;
	}
}
 