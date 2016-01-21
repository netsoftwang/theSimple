package com.palace.seeds.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class ConnectionTest {

	private  Logger logger= Logger.getLogger(PropertiesKit.class);
	private org.apache.tomcat.jdbc.pool.DataSource dataSource;
	String  userName;
	String  password;
	String  driverClass;
	String  url;
	public void loadMsg(){
		this.userName=PropertiesKit.getPro("mysql.userName");
		this.password=PropertiesKit.getPro("mysql.password");
		this.driverClass=PropertiesKit.getPro("mysql.driverClass");
		this.url=PropertiesKit.getPro("mysql.url");
		logger.info(" jdbc info : userName="+this.userName+",password="+this.password+",driverClass="+this.driverClass+",url="+this.url);
	}
	
	public void  init(){
		loadMsg();
	}
 
	public void jdbcTest(){
		try {
			Class.forName(this.driverClass);
			Connection con = DriverManager.getConnection(this.url,this.userName,this.password);
			PreparedStatement ps=  con.prepareStatement("select 1 ");
			ResultSet res= ps.executeQuery();
			if(res.next()){
				System.out.println(" jdbc  resultset next is true");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void  tomcatDataSourceTest(){
		PoolProperties p = new PoolProperties();
		p.setUrl(this.url);
		p.setDriverClassName(this.driverClass);
		p.setUsername(this.userName);
		p.setPassword(this.password);
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
		this.dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		this.dataSource.setPoolProperties(p);
		try {
			Connection con =this.dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select 1 "); 
			ResultSet res = ps.executeQuery();
			if(res.next()){
				System.out.println("  tomcat datasource  resultset next is true");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		ConnectionTest ct = new ConnectionTest();
		ct.loadMsg();
		if(args.length>0){
			if("jdbc".equals(args[0])){
				ct.jdbcTest();
			}else if("dataSource".equals(args[0])){
				ct.tomcatDataSourceTest();
			}
		}else{
			//ct.jdbcTest();
			ct.tomcatDataSourceTest();
		}
	}
	
	
	
	
}





/*drop table 	if EXISTS `data`;
create table `data`(
`id` int  auto_increment,
`sip` varchar(32),
`sport` int ,
`shash` varchar(32),
`dip` varchar(32),
`dport` int,
`dhash` varchar(32),
`proc` varchar(125),
PRIMARY key (id)
);*/
