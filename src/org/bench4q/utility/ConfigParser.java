package org.bench4q.utility;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigParser {

	private static final String configFilePath = "db.properties";

	// singleton
	private static ConfigParser configParser = null;
	
	private ConfigParser() {
	}
	
	public static ConfigParser getInstance() {
		if (configParser == null) {
			configParser = new ConfigParser();
		}
		return configParser;
	}

	public static void loadConfig() {
		try {
			Properties prop = new Properties();
			InputStream in = ConfigParser.class.getResourceAsStream("/" + configFilePath);
//			System.out.println(ConfigParser.class.getResource("").getPath());
//			System.out.println(ConfigParser.class.getResource("/").getPath());
//			System.out.println(ConfigParser.class.getClassLoader().getResource("").getPath());
//			System.out.println(ConfigParser.class.getClassLoader().getResource("/").getPath());
			if (in != null) {
				prop.load(in);
				String dbType = prop.getProperty("dbType").trim();
				String driverName = prop.getProperty("driverName").trim();
				String url = prop.getProperty("url").trim();
				String userName = prop.getProperty("userName").trim();
				String password = prop.getProperty("password").trim();
				int ebNum = Integer.parseInt(prop.getProperty("ebNum").trim());
				int itemNum = Integer.parseInt(prop.getProperty("itemNum").trim());
				DBHelper.init(itemNum, ebNum);
				DBHelper.init(dbType, url, driverName, userName, password);
			} else {
				throw new IOException("warning :can't find db.properties");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

