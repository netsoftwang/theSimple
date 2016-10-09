package com.palace.seeds.others;

public class MyEnum {

	enum enumIns{
		name("wenjian",1,"hua");
		
		//需要一个构造器
		private enumIns(String a,Integer aa,String aaa){
			this.namea=a;
			this.aa=aa;
			this.ad=aaa;
		}
		private String namea;
		private Integer aa;
		private String  ad;
		public String getNamea() {
			return namea;
		}
		public void setNamea(String namea) {
			this.namea = namea;
		}
		public Integer getAa() {
			return aa;
		}
		public void setAa(Integer aa) {
			this.aa = aa;
		}
		public String getAd() {
			return ad;
		}
		public void setAd(String ad) {
			this.ad = ad;
		}
	}
}
