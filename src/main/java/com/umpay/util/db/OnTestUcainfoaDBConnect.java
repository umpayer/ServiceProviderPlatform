package com.umpay.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * 单例获取数据库连接
 * */
public class OnTestUcainfoaDBConnect {


	private static final String jdbcurl="jdbc:db2://xx.xx.xx.xx:xxxxx/upontest";
	private static final String user="xxxxxxxx";
	private static final String pwd="xxxxxxxx";
	public static Connection getConnect(){
		Connection conn1 = null;
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			conn1 = DriverManager.getConnection(jdbcurl, user,pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn1;
	}
	
	public static Connection getDB2Connect(String jdbcurl,String user,String pwd){
		 Connection resconn =null;
		if(resconn == null){
			synchronized(OnTestUcainfoaDBConnect.class){
				if(resconn == null){
					try {
						Class.forName("com.ibm.db2.jcc.DB2Driver");
						resconn = DriverManager.getConnection(jdbcurl, user,pwd);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return resconn;
	}
	
	public static void release(Connection conn, PreparedStatement pst, ResultSet rs){
		try {//首先尝试关闭结果集
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (conn != null)
				conn.close();
		} catch (SQLException sqle) {//发生异常是输出异常不处理
			sqle.printStackTrace();
		}
	}
}
