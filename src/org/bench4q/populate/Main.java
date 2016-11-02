package org.bench4q.populate;

import java.text.DecimalFormat;

import org.bench4q.utility.ConfigParser;
import org.bench4q.utility.DBHelper;

public class Main {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		pupulate();
		long end = System.currentTimeMillis();
		DecimalFormat fnum = new DecimalFormat("##0.00");    
		String time=fnum.format((float)(end-start)/1000);       
		System.out.println(DBHelper.itemNum + " scale tables populated in : " + time + " s");
		
	}
	
	private static void pupulate() {
		ConfigParser.loadConfig();
		String dbType = DBHelper.getDbType().toLowerCase();
		switch (dbType) {
		case "mysql":
			MysqlPopulate.start();
			break;
		case "shentong":
			ShenTongPopulate.start();
			break;
		case "oracle":
			OraclePopulate.start();
			break;
		default:
			try {
				throw new Exception("wrong dbType:" + dbType);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}
}
