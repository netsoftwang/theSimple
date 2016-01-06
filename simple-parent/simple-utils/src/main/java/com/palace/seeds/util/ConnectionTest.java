package com.palace.seeds.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.junit.Before;
import org.junit.Test;

import com.jfinal.plugin.activerecord.Db;

public class ConnectionTest {

	
	DataSource ds=null;
	private Random random = new Random(99999999);
	public int getRandom(){
		return random.nextInt();
	}
	public String getUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}
	@Before
	public void  init(){
		PoolProperties p = new PoolProperties();
		p.setUrl("jdbc:mysql://127.0.0.1:5106/mysqltest?useUnicode=true&characterEncoding=utf8");
		p.setDriverClassName("com.mysql.jdbc.Driver");
		p.setUsername("root");
		p.setPassword("83150FC75274C5C5");
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
		org.apache.tomcat.jdbc.pool.DataSource jdbcDatasources = new org.apache.tomcat.jdbc.pool.DataSource();
		jdbcDatasources.setPoolProperties(p);
		ds= jdbcDatasources;
	}
	@Test
	public void diffrentDatabaseTest(){
		List<Object> objList= Db.query(ds,"select * from htsaudit.cscaudit  where id <200");
		System.out.println("dd");
	}
	
	public List<String> getSqlList(){
		List<String> list= new ArrayList<String>();
		StringBuilder sb=null;
		for(int i=0;i<100;i++){
			sb=new StringBuilder();
			sb.append("insert into dataIndex50(sip,sport,shash,dip,"
					+ "dport,dhash,proc) values(")
			.append("'"+getUUID()+"',").append(getRandom()).append(",'"+getUUID()+"',").append("'"+getUUID()+"',")
			.append(getRandom()).append(",'"+getUUID()+"',").append("'"+getUUID()+"'").append(")");
			list.add(sb.toString());
		}
		return list;
	}
	
	public void run(){
		Db.batch(ds,getSqlList(),getSqlList().size());
	}
	
	public static void main(String[] args) {
		ConnectionTest mst= new ConnectionTest();
		mst.init();
		for(int i=0;i<5000;i++){
			System.out.println("number is "+i+" start");
			mst.run();
			System.out.println("number is "+i+" end ");
		}
		System.out.println(" the end ");
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
