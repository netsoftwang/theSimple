package com.palace.seeds;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class SimpleTest {

	public static void main(String[] args) throws SQLException {
		
		Connection c =   (Connection) DriverManager.getConnection("jdbc:mysql://localhost:5106", "root","111111");
		Statement st= c.createStatement();
		 st.execute("insert into seeds.action(entId,actionVal,actionGroup) values(100,'actionVal','actionGroup')");
	}
}
