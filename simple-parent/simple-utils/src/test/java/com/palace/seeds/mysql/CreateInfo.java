package com.palace.seeds.mysql;

import org.apache.tomcat.jdbc.pool.PoolProperties;

import com.jfinal.plugin.activerecord.Db;
import com.palace.seeds.util.RandomVal;

public class CreateInfo {

	org.apache.tomcat.jdbc.pool.DataSource ds;
	
	public static void main(String[] args) {
		CreateInfo ci = new CreateInfo();
		ci.initDataSource();
		//ci.insertNodeInfo();
		//ci.insertOrg();
		//ci.insertPlatInfo();
		//ci.insertFileAccess();
		//ci.insertUserLogin();
		System.out.println("");
		
	}
	
	public void test(){
		Db.query(this.ds,"select 1 ");
		System.out.println("test sql");
	}
	//创建一千万FileAccess
	public void insertFileAccess(){
		String orgInsertSql="insert into fileAccess(id,logType,platMac,riskLevel,protectedFile,illegalProgram,fileSize"
				+ ",signCompany,signCheck,happendTime,operationRes) values(?,?,?,?,?,?,?,?,?,?,?)";
		for(int i=1;i<=10000000;i++){
			if(i%5000==0){
				System.out.println(" file access num "+i);
			}
			Db.update(this.ds,orgInsertSql,i,i%256,"platMacBegin"+RandomVal.randomInt(1000, 2000)+"paltMacEnd",i%256,RandomVal.randomStr(896)+"protectedFile",
					RandomVal.randomStr(1000)+"illegalprogram",i,RandomVal.randomStr(200)+"company",
					i%256,System.currentTimeMillis()/1000,i%256);
		}
	}
	//创建一个亿userlogin
	public void insertUserLogin(){
		String orgInsertSql="insert into userLogin(id,logType,platMac,platName,userName,clientIp,protectedFile,illegalProgram,fileSize,signCompany,happendTime) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		for(int i=21298719;i<=100000000;i++){
			if(i%5000==0){
				System.out.println(" userlogin num "+i);
			}
			Db.update(this.ds,orgInsertSql,i,i%256,"platMacBegin"+RandomVal.randomInt(1000, 2000)+"paltMacEnd",RandomVal.randomStr(100)+"platName",
					RandomVal.randomStr(200)+"userName",i+"ip",RandomVal.randomStr(896)+"protectedFile",
					RandomVal.randomStr(1000)+"illegalprogram",i,RandomVal.randomStr(200)+"company",System.currentTimeMillis()/1000);
		}
		
	}
	//创讲200个机构  id=200--400
	public void insertOrg(){
		String orgInsertSql="insert into org(id,province,pcode,city,ccode,district,dcode) values(?,?,?,?,?,?,?)";
		for(int i=200;i<=400;i++){
			Db.update(this.ds,orgInsertSql,i,"provice"+i,"pcode"+i,"city"+i,i,"district"+i,i);
		}
		System.out.println(" org end ");
	}
	//创建300个节点   200--500
	public void insertNodeInfo(){
		String  nodeSql="insert into nodeinfo(id,uuid,websitedomainname,x,y,code,netaddress,institution,devicenum,principal,phone,linkstatus,type)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(int i=200;i<=500;i++){
			Db.update(this.ds,nodeSql,i,RandomVal.randomStr(46),RandomVal.randomStr(46),RandomVal.randomFloat(10000),RandomVal.randomFloat(20000),
					i+"code",i+"netaddress",i+"institution",i,RandomVal.randomStr(32),"phone"+RandomVal.randomStr(5),i,i);
		}
		System.out.println(" nodinfo end ");
	}
	//创建一千台主机信息 1000--2000
    public void insertPlatInfo(){
    	String  nodeSql="insert into platInfo(id,platMac,nodeInfoId,org,serverName,platName,sysName,sysType,ip,status)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		for(int i=1000;i<=2000;i++){
			Db.update(this.ds,nodeSql,i,"platMacBegin"+i+"paltMacEnd",RandomVal.randomInt(200, 501),RandomVal.randomInt(200, 401),
					RandomVal.randomStr(90)+"serverName",RandomVal.randomStr(50)+"platName",
					"sysName"+RandomVal.randomStr(50),"systype"+i,"ip"+RandomVal.randomStr(8),"sta");
		}
		System.out.println(" platinfo end ");
    }
    
    public void initDataSource(){
    	 int maxActive = 400;
         int initialSize = 20;
         int maxWait = 10000;
         int minIdle = 5;
         int maxIdle = 10;
          String url = "jdbc:mysql://localhost:3306/nlsm?useUnicode=true&characterEncoding=utf8";
           PoolProperties p = new PoolProperties();
           p.setUrl(url);
           p.setDriverClassName("com.mysql.jdbc.Driver");
           p.setUsername("root");
           p.setPassword("111111");
           p.setJmxEnabled(true);
           p.setTestWhileIdle(false);
           p.setTestOnBorrow(true);
           p.setValidationQuery("SELECT 1");
           p.setTestOnReturn(false);
           p.setValidationInterval(30000);
           p.setTimeBetweenEvictionRunsMillis(30000);
           p.setRemoveAbandonedTimeout(60);
           p.setMinEvictableIdleTimeMillis(30000);
           p.setLogAbandoned(true);
           p.setRemoveAbandoned(true);
           p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
           p.setMinIdle(minIdle);
           p.setMaxIdle(maxIdle);
           p.setMaxActive(maxActive);
           p.setInitialSize(initialSize);
           p.setMaxWait(maxWait);
           this.ds  = new org.apache.tomcat.jdbc.pool.DataSource();
           this.ds.setPoolProperties(p);
    }
}
