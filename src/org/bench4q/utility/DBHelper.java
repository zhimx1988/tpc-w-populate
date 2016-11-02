package org.bench4q.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
	
	public static int itemNum = 1000;
	public static int ebNum = 5;
	public static int customersNum;
	public static int addrNum;
	public static int authorsNum;
	public static int ordersNum;
	private static String dbType;
	private static String url;
	private static String driverName;
	private static String userName;
	private static String password;
	
	public static void init(int itemNum, int ebNum){
		DBHelper.itemNum = itemNum;
		DBHelper.ebNum = ebNum;
		customersNum = ebNum * 2880;
		addrNum = 2 * customersNum;
		authorsNum = (int) (0.25 * itemNum);
		ordersNum = (int) (0.9 * customersNum);	
	}
	
	public static void init(String dbType, String url, String driverName, String userName, String password) {
		DBHelper.dbType = dbType;
		DBHelper.url = url;
		DBHelper.driverName = driverName;
		DBHelper.userName = userName;
		DBHelper.password = password;
	}
	
	public static String getDbType() {
		return dbType;
	}
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, password);
			return con;
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
	}
}
