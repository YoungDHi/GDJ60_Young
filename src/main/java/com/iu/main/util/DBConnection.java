package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public void getConnection() throws Exception {
		//1. id
		String username="hr";
		//2. pw
		String password="hr";
		//3. url
		String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";
		//4. driver 정보
		String driver="oracle.jdbc.OracleDriver";
		
		Class.forName(driver);
		
		Connection connection = DriverManager.getConnection(url, username, password);
		
		String sql="SELECT * FROM EMPLOYEES";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString("FIRST_NAME"));
			System.out.println(rs.getString("PHONE_NUMBER"));
			System.out.println(rs.getDate("HIRE_DATE"));
			System.out.println(rs.getString("COMMISSION_PCT"));
			System.out.println("-------------------------");
			
			
			
			
		}
		
	}

}
