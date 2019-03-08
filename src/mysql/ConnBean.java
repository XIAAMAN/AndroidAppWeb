/*
 * ConnBean类的作用是对数据库进行连接和关闭以及
 * 一些字段的获得和修改
 * */

package mysql;

import java.sql.*;
public class ConnBean {
	private String driver = "com.mysql.jdbc.Driver";
	private String jdbcurl = "jdbc:mysql://localhost:3306/";
	private String database = "xiaaman_db";
	private String userName="root";
	private String password = "X5331069";
	
    private Connection conn = null;

   public Connection getConnection() {
	   try {
		Class.forName(driver);
		conn = DriverManager.getConnection(jdbcurl+database,userName,password);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch(SQLException e2) {
		e2.printStackTrace();
	}
	   return conn;
   }
	
	public void closeConnection() {		//关闭数据库连接
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e3) {
			e3.printStackTrace();
		}
	}
	
}
