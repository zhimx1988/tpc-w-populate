package org.bench4q.populate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.bench4q.utility.DBHelper;
import org.bench4q.utility.GetRandomObject;

class ShenTongPopulate {
	
	private static Connection con = null;
	private static int batchNum = 1000;
	
	public static void createTables(){
		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE TABLE ADDRESS ( ADDR_ID int PRIMARY KEY, ADDR_STREET1 varchar(40),ADDR_STREET2 varchar(40), ADDR_CITY varchar(30), ADDR_STATE varchar(20),ADDR_ZIP varchar(10), ADDR_CO_ID int)");
			statement.executeUpdate();
			System.out.println("Created table ADDRESS");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create table: ADDRESS");
			ex.printStackTrace();
			System.exit(1);
		}
		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE SEQUENCE ADDRESS_SEQ minvalue 1 no maxvalue START WITH 1 increment by 1 no cycle no cache");
			statement.executeUpdate();
			System.out.println("Created table ADDRESS'S SEQUENCE");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create sequence: ADDRESS");
			ex.printStackTrace();
			System.exit(1);
		}
		
		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE TABLE AUTHOR ( A_ID int PRIMARY KEY, A_FNAME varchar(20), A_LNAME varchar(20), A_MNAME varchar(20), A_DOB date, A_BIO varchar(500))");
			statement.executeUpdate();
			System.out.println("Created table AUTHOR");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create table: AUTHOR");
			ex.printStackTrace();
			System.exit(1);
		}
		
		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE SEQUENCE AUTHOR_SEQ minvalue 1 no maxvalue start with 1 increment by 1 no cycle no cache");
			statement.executeUpdate();
			System.out.println("Created table AUTHOR'S SEQUENCE");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create sequence: AUTHOR");
			ex.printStackTrace();
			System.exit(1);
		}
		
		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE TABLE cc_xacts ( CX_O_ID int PRIMARY KEY, CX_TYPE varchar(10), CX_NUM varchar(20), CX_NAME varchar(30), CX_EXPIRE date, CX_AUTH_ID char(15), CX_XACT_AMT double Precision, CX_XACT_DATE date, CX_CO_ID int)");
			statement.executeUpdate();
			System.out.println("Created table CC_XACTS");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create table: CC_XACTS");
			ex.printStackTrace();
			System.exit(1);
		}

		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE TABLE country ( CO_ID int PRIMARY KEY, CO_NAME varchar(50), CO_EXCHANGE double Precision, CO_CURRENCY varchar(18))");
			statement.executeUpdate();
			System.out.println("Created table COUNTRY");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create table: COUNTRY");
			ex.printStackTrace();
			System.exit(1);
		}
		
		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE SEQUENCE COUNTRY_SEQ minvalue 1 no maxvalue start with 1 increment by 1 no cycle no cache");
			statement.executeUpdate();
			System.out.println("Created table COUNTRY'S SEQUENCE");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create sequence: COUNTRY");
			ex.printStackTrace();
			System.exit(1);
		}
		
		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE TABLE customer ( C_ID int PRIMARY KEY, C_UNAME varchar(20), C_PASSWD varchar(20), C_FNAME varchar(17), C_LNAME varchar(17), C_ADDR_ID int, C_PHONE varchar(18), C_EMAIL varchar(50), C_SINCE date, C_LAST_LOGIN date, C_LOGIN timestamp, C_EXPIRATION timestamp, C_DISCOUNT double Precision, C_BALANCE double Precision, C_YTD_PMT double Precision, C_BIRTHDATE date, C_DATA varchar(510))");
			statement.executeUpdate();
			System.out.println("Created table CUSTOMER");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create table: CUSTOMER");
			ex.printStackTrace();
			System.exit(1);
		}

		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE SEQUENCE CUSTOMER_SEQ minvalue 1 no maxvalue start with 1 increment by 1 no cycle no cache");
			statement.executeUpdate();
			System.out.println("Created table CUSTOMER'S SEQUENCE");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create sequence: CUSTOMER");
			ex.printStackTrace();
			System.exit(1);
		}
		
		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE TABLE item ( I_ID int PRIMARY KEY, I_TITLE varchar(60), I_A_ID int, I_PUB_DATE date, I_PUBLISHER varchar(60), I_SUBJECT varchar(60), I_DESC varchar(500), I_RELATED1 int, I_RELATED2 int, I_RELATED3 int, I_RELATED4 int, I_RELATED5 int, I_THUMBNAIL varchar(40), I_IMAGE varchar(40), I_SRP double Precision, I_COST double Precision, I_AVAIL date, I_STOCK int, I_ISBN char(13), I_PAGE int, I_BACKING varchar(15), I_DIMENSIONS varchar(25))");
			statement.executeUpdate();
			System.out.println("Created table ITEM");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create table: ITEM");
			ex.printStackTrace();
			System.exit(1);
		}

		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE SEQUENCE ITEM_SEQ minvalue 1 no maxvalue start with 1 increment by 1 no cycle no cache");
			statement.executeUpdate();
			System.out.println("Created table ITEM'S SEQUENCE");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create sequence: ITEM");
			ex.printStackTrace();
			System.exit(1);
		}
		
		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE TABLE order_line ( OL_ID int not null, OL_O_ID int not null, OL_I_ID int, OL_QTY int, OL_DISCOUNT double Precision, OL_COMMENTS varchar(110), PRIMARY KEY(OL_ID, OL_O_ID))");
			statement.executeUpdate();
			System.out.println("Created table ORDER_LINE");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create table: ORDER_LINE");
			ex.printStackTrace();
			System.exit(1);
		}

		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE TABLE orders ( O_ID int, O_C_ID int, O_DATE date, O_SUB_TOTAL double Precision, O_TAX double Precision, O_TOTAL double Precision, O_SHIP_TYPE varchar(10), O_SHIP_DATE date, O_BILL_ADDR_ID int, O_SHIP_ADDR_ID int, O_STATUS varchar(15), PRIMARY KEY(O_ID))");
			statement.executeUpdate();
			System.out.println("Created table ORDERS");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create table: ORDERS");
			ex.printStackTrace();
			System.exit(1);
		}

		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE SEQUENCE ORDERS_SEQ minvalue 1 no maxvalue start with 1 increment by 1 no cycle no cache");
			statement.executeUpdate();
			System.out.println("Created table ORDERS'S SEQUENCE");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create sequence: ORDERS");
			ex.printStackTrace();
			System.exit(1);
		}
		
		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE TABLE shopping_cart ( SC_ID  int, SC_TIME timestamp, PRIMARY KEY(SC_ID))");
			statement.executeUpdate();
			System.out.println("Created table SHOPPING_CART");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create table: SHOPPING_CART");
			ex.printStackTrace();
			System.exit(1);
		}
		
		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE SEQUENCE SHOPPING_CART_SEQ minvalue 1 no maxvalue start with 1 increment by 1 no cycle no cache");
			statement.executeUpdate();
			System.out.println("Created table SHOPPING_CART'S SEQUENCE");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create sequence: SHOPPING_CART");
			ex.printStackTrace();
			System.exit(1);
		}
		
		try {
			PreparedStatement statement = con
					.prepareStatement("CREATE TABLE shopping_cart_line ( SCL_SC_ID int not null, SCL_QTY int, SCL_I_ID int not null, PRIMARY KEY(SCL_SC_ID, SCL_I_ID))");
			statement.executeUpdate();
			System.out.println("Created table SHOPPING_CART_LINE");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to create table: SHOPPING_CART_LINE");
			ex.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void deleteTables() {
		int i;
		String[] tables = { "ADDRESS", "AUTHOR", "CC_XACTS", "COUNTRY", "CUSTOMER", "ITEM",
				"ORDER_LINE", "ORDERS", "SHOPPING_CART", "SHOPPING_CART_LINE"};
		int numTables = tables.length;
		for (i = 0; i < numTables; i++) {
			try {
				// Delete each table listed in the tables array
				PreparedStatement statement = con.prepareStatement("DROP TABLE " + tables[i]);
				statement.executeUpdate();
				System.out.println("Dropped table " + tables[i]);
			} catch (java.lang.Exception ex) {
				System.out.println("Unable to drop table " + tables[i]);
			}
			try {
				// Delete each table sequence in the tables array
				PreparedStatement statement = con.prepareStatement("DROP SEQUENCE " + tables[i]+"_SEQ");
				statement.executeUpdate();
				System.out.println("Dropped table sequence " + tables[i]);
			} catch (java.lang.Exception ex) {
				System.out.println("Unable to drop table sequence " + tables[i]);
			}
		}
		System.out.println("Done deleting tables!");
	}
	
	public static void populateCustomerTable(){
		String C_UNAME, C_PASSWD, C_LNAME, C_FNAME;
		int C_ADDR_ID, C_PHONE;
		String C_EMAIL;
		java.sql.Date C_SINCE, C_LAST_LOGIN;
		java.sql.Timestamp C_LOGIN, C_EXPIRATION;
		double C_DISCOUNT, C_BALANCE, C_YTD_PMT;
		java.sql.Date C_BIRTHDATE;
		String C_DATA;
		int i;
		try {
			PreparedStatement statement = con
					.prepareStatement("INSERT INTO CUSTOMER (C_ID,C_UNAME,C_PASSWD,C_FNAME,C_LNAME,C_ADDR_ID,C_PHONE,C_EMAIL,C_SINCE,C_LAST_LOGIN,C_LOGIN,C_EXPIRATION,C_DISCOUNT,C_BALANCE,C_YTD_PMT,C_BIRTHDATE,C_DATA) VALUES (CUSTOMER_SEQ.nextval,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)");
			for (i = 1; i <= DBHelper.customersNum; i++) {
				C_UNAME = GetRandomObject.DigSyl(i, 0);
				C_PASSWD = C_UNAME.toLowerCase();
				C_LNAME = GetRandomObject.getRandomAString(8, 15);
				C_FNAME = GetRandomObject.getRandomAString(8, 15);
				C_ADDR_ID = GetRandomObject.getRandomInt(1, 2 * DBHelper.customersNum);
				C_PHONE = GetRandomObject.getRandomNString(9, 16);
				C_EMAIL = C_UNAME + "@" + GetRandomObject.getRandomAString(2, 9) + ".com";

				GregorianCalendar cal = new GregorianCalendar();
				cal.add(Calendar.DAY_OF_YEAR, -1 * GetRandomObject.getRandomInt(1, 730));
				C_SINCE = new java.sql.Date(cal.getTime().getTime());
				cal.add(Calendar.DAY_OF_YEAR, GetRandomObject.getRandomInt(0, 60));
				if (cal.after(new GregorianCalendar()))
					cal = new GregorianCalendar();

				C_LAST_LOGIN = new java.sql.Date(cal.getTime().getTime());
				C_LOGIN = new java.sql.Timestamp(System.currentTimeMillis());
				cal = new GregorianCalendar();
				cal.add(Calendar.HOUR, 2);
				C_EXPIRATION = new java.sql.Timestamp(cal.getTime().getTime());

				C_DISCOUNT = (double) GetRandomObject.getRandomInt(0, 10);
				C_BALANCE = 0.00;
				C_YTD_PMT = (double) GetRandomObject.getRandomInt(0, 99999) / 100.0;
				int year = GetRandomObject.getRandomInt(1880, 2000);
				int month = GetRandomObject.getRandomInt(0, 11);
				int maxday = 31;
				int day;
				if (month == 3 | month == 5 | month == 8 | month == 10)
					maxday = 30;
				else if (month == 1)
					maxday = 28;
				day = GetRandomObject.getRandomInt(1, maxday);
				cal = new GregorianCalendar(year, month, day);
				C_BIRTHDATE = new java.sql.Date(cal.getTime().getTime());

				C_DATA = GetRandomObject.getRandomAString(100, 500);
				statement.setString(1, C_UNAME);
				statement.setString(2, C_PASSWD);
				statement.setString(3, C_FNAME);
				statement.setString(4, C_LNAME);
				statement.setInt(5, C_ADDR_ID);
				statement.setInt(6, C_PHONE);
				statement.setString(7, C_EMAIL);
				statement.setDate(8, C_SINCE);
				statement.setDate(9, C_LAST_LOGIN);
				statement.setTimestamp(10, C_LOGIN);
				statement.setTimestamp(11, C_EXPIRATION);
				statement.setDouble(12, C_DISCOUNT);
				statement.setDouble(13, C_BALANCE);
				statement.setDouble(14, C_YTD_PMT);
				statement.setDate(15, C_BIRTHDATE);
				statement.setString(16, C_DATA);
				statement.addBatch();
				if (i % batchNum == 0) {
					statement.executeBatch();
					statement.clearBatch();
				}
			}
			statement.executeBatch();
			statement.clearBatch();
			System.out.println("customer populated.");
		} catch (java.lang.Exception ex) {
			System.err.println("Unable to populate CUSTOMER table");
			ex.printStackTrace();
			System.exit(1);
		}
	}

	public static void populateAddressTable(){
		String ADDR_STREET1, ADDR_STREET2, ADDR_CITY, ADDR_STATE;
		String ADDR_ZIP;
		int ADDR_CO_ID;
		try {
			PreparedStatement statement = con
					.prepareStatement("INSERT INTO ADDRESS(ADDR_ID,ADDR_STREET1,ADDR_STREET2,ADDR_CITY,ADDR_STATE,ADDR_ZIP,ADDR_CO_ID) VALUES (ADDRESS_SEQ.nextval,?, ?, ?, ?, ?, ?)");
			for (int i = 1; i <= DBHelper.addrNum; i++) {
				ADDR_STREET1 = GetRandomObject.getRandomAString(15, 40);
				ADDR_STREET2 = GetRandomObject.getRandomAString(15, 40);
				ADDR_CITY = GetRandomObject.getRandomAString(4, 30);
				ADDR_STATE = GetRandomObject.getRandomAString(2, 20);
				ADDR_ZIP = GetRandomObject.getRandomAString(5, 10);
				ADDR_CO_ID = GetRandomObject.getRandomInt(1, 92);

				statement.setString(1, ADDR_STREET1);
				statement.setString(2, ADDR_STREET2);
				statement.setString(3, ADDR_CITY);
				statement.setString(4, ADDR_STATE);
				statement.setString(5, ADDR_ZIP);
				statement.setInt(6, ADDR_CO_ID);
				statement.addBatch();
				if (i % batchNum == 0){
					statement.executeBatch();
					statement.clearBatch();
				}
			}
			statement.executeBatch();
			statement.clearBatch();
			System.out.println("address populated.");
		} catch (java.lang.Exception ex) {
			System.err.println("Unable to populate ADDRESS table");
			ex.printStackTrace();
			System.exit(1);
		}
	}

	public static void populateAuthorTable(){
		String A_FNAME, A_MNAME, A_LNAME, A_BIO;
		java.sql.Date A_DOB;
		GregorianCalendar cal;
		try {
			PreparedStatement statement = con
					.prepareStatement("INSERT INTO AUTHOR(A_ID,A_FNAME,A_LNAME,A_MNAME,A_DOB,A_BIO) VALUES (AUTHOR_SEQ.nextval,?, ?, ?, ?, ?)");
			for (int i = 1; i <= DBHelper.authorsNum; i++) {
				int month, day, year, maxday;
				A_FNAME = GetRandomObject.getRandomAString(3, 20);
				A_MNAME = GetRandomObject.getRandomAString(1, 20);
				A_LNAME = GetRandomObject.getRandomAString(1, 20);
				year = GetRandomObject.getRandomInt(1800, 1990);
				month = GetRandomObject.getRandomInt(0, 11);
				maxday = 31;
				if (month == 3 | month == 5 | month == 8 | month == 10)
					maxday = 30;
				else if (month == 1)
					maxday = 28;
				day = GetRandomObject.getRandomInt(1, maxday);
				cal = new GregorianCalendar(year, month, day);
				A_DOB = new java.sql.Date(cal.getTime().getTime());
				A_BIO = GetRandomObject.getRandomAString(125, 500);
				statement.setString(1, A_FNAME);
				statement.setString(2, A_LNAME);
				statement.setString(3, A_MNAME);
				statement.setDate(4, A_DOB);
				statement.setString(5, A_BIO);
				statement.addBatch();
				if (i % batchNum == 0){
					statement.executeBatch();
					statement.clearBatch();
				}
			}
			statement.executeBatch();
			statement.clearBatch();
			System.out.println("author populated.");
		} catch (java.lang.Exception ex) {
			System.err.println("Unable to populate AUTHOR table");
			ex.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void populateCountryTable(){
		String[] countries = { "United States", "United Kingdom", "Canada", "Germany", "France",
				"Japan", "Netherlands", "Italy", "Switzerland", "Australia", "Algeria",
				"Argentina", "Armenia", "Austria", "Azerbaijan", "Bahamas", "Bahrain",
				"Bangla Desh", "Barbados", "Belarus", "Belgium", "Bermuda", "Bolivia", "Botswana",
				"Brazil", "Bulgaria", "Cayman Islands", "Chad", "Chile", "China",
				"Christmas Island", "Colombia", "Croatia", "Cuba", "Cyprus", "Czech Republic",
				"Denmark", "Dominican Republic", "Eastern Caribbean", "Ecuador", "Egypt",
				"El Salvador", "Estonia", "Ethiopia", "Falkland Island", "Faroe Island", "Fiji",
				"Finland", "Gabon", "Gibraltar", "Greece", "Guam", "Hong Kong", "Hungary",
				"Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Jamaica",
				"Jordan", "Kazakhstan", "Kuwait", "Lebanon", "Luxembourg", "Malaysia", "Mexico",
				"Mauritius", "New Zealand", "Norway", "Pakistan", "Philippines", "Poland",
				"Portugal", "Romania", "Russia", "Saudi Arabia", "Singapore", "Slovakia",
				"South Africa", "South Korea", "Spain", "Sudan", "Sweden", "Taiwan", "Thailand",
				"Trinidad", "Turkey", "Venezuela", "Zambia" };

		double[] exchanges = { 1, .625461, 1.46712, 1.86125, 6.24238, 121.907, 2.09715, 1842.64,
				1.51645, 1.54208, 65.3851, 0.998, 540.92, 13.0949, 3977, 1, .3757, 48.65, 2,
				248000, 38.3892, 1, 5.74, 4.7304, 1.71, 1846, .8282, 627.1999, 494.2, 8.278,
				1.5391, 1677, 7.3044, 23, .543, 36.0127, 7.0707, 15.8, 2.7, 9600, 3.33771, 8.7,
				14.9912, 7.7, .6255, 7.124, 1.9724, 5.65822, 627.1999, .6255, 309.214, 1, 7.75473,
				237.23, 74.147, 42.75, 8100, 3000, .3083, .749481, 4.12, 37.4, 0.708, 150, .3062,
				1502, 38.3892, 3.8, 9.6287, 25.245, 1.87539, 7.83101, 52, 37.8501, 3.9525, 190.788,
				15180.2, 24.43, 3.7501, 1.72929, 43.9642, 6.25845, 1190.15, 158.34, 5.282, 8.54477,
				32.77, 37.1414, 6.1764, 401500, 596, 2447.7 };

		String[] currencies = { "Dollars", "Pounds", "Dollars", "Deutsche Marks", "Francs", "Yen",
				"Guilders", "Lira", "Francs", "Dollars", "Dinars", "Pesos", "Dram", "Schillings",
				"Manat", "Dollars", "Dinar", "Taka", "Dollars", "Rouble", "Francs", "Dollars",
				"Boliviano", "Pula", "Real", "Lev", "Dollars", "Franc", "Pesos", "Yuan Renmimbi",
				"Dollars", "Pesos", "Kuna", "Pesos", "Pounds", "Koruna", "Kroner", "Pesos",
				"Dollars", "Sucre", "Pounds", "Colon", "Kroon", "Birr", "Pound", "Krone",
				"Dollars", "Markka", "Franc", "Pound", "Drachmas", "Dollars", "Dollars", "Forint",
				"Krona", "Rupees", "Rupiah", "Rial", "Dinar", "Punt", "Shekels", "Dollars",
				"Dinar", "Tenge", "Dinar", "Pounds", "Francs", "Ringgit", "Pesos", "Rupees",
				"Dollars", "Kroner", "Rupees", "Pesos", "Zloty", "Escudo", "Leu", "Rubles",
				"Riyal", "Dollars", "Koruna", "Rand", "Won", "Pesetas", "Dinar", "Krona",
				"Dollars", "Baht", "Dollars", "Lira", "Bolivar", "Kwacha" };

		int countryNum = countries.length;
//		System.out.println("country num :" + countries.length);

		try {
			PreparedStatement statement = con
					.prepareStatement("INSERT INTO COUNTRY(CO_ID,CO_NAME,CO_EXCHANGE,CO_CURRENCY) VALUES (COUNTRY_SEQ.nextval,?,?,?)");
			for (int i = 0; i < countryNum; i++) {
				statement.setString(1, countries[i]);
				statement.setDouble(2, exchanges[i]);
				statement.setString(3, currencies[i]);
				statement.addBatch();
				if (i % batchNum == 0){
					statement.executeBatch();
					statement.clearBatch();
				}
			}
			statement.executeBatch();
			statement.clearBatch();
			System.out.println("country populated.");
		} catch (java.lang.Exception ex) {
			System.err.println("Unable to populate COUNTRY table");
			ex.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void populateItemTable(){
		String I_TITLE;
		GregorianCalendar cal;
		int I_A_ID;
		java.sql.Date I_PUB_DATE;
		String I_PUBLISHER, I_SUBJECT, I_DESC;
		int I_RELATED1, I_RELATED2, I_RELATED3, I_RELATED4, I_RELATED5;
		String I_THUMBNAIL, I_IMAGE;
		double I_SRP, I_COST;
		java.sql.Date I_AVAIL;
		int I_STOCK;
		String I_ISBN;
		int I_PAGE;
		String I_BACKING;
		String I_DIMENSIONS;
		int itemNum = DBHelper.itemNum;
		
		String[] SUBJECTS = { "ARTS", "BIOGRAPHIES", "BUSINESS", "CHILDREN", "COMPUTERS",
				"COOKING", "HEALTH", "HISTORY", "HOME", "HUMOR", "LITERATURE", "MYSTERY",
				"NON-FICTION", "PARENTING", "POLITICS", "REFERENCE", "RELIGION", "ROMANCE",
				"SELF-HELP", "SCIENCE-NATURE", "SCIENCE_FICTION", "SPORTS", "YOUTH", "TRAVEL" };
		int subjectsNum = SUBJECTS.length;

		String[] BACKINGS = { "HARDBACK", "PAPERBACK", "USED", "AUDIO", "LIMITED-EDITION" };
		int backingsNum = BACKINGS.length;
		
		try {
			PreparedStatement statement = con
					.prepareStatement("INSERT INTO ITEM (I_ID,I_TITLE , I_A_ID, I_PUB_DATE, I_PUBLISHER, I_SUBJECT, I_DESC, I_RELATED1, I_RELATED2, I_RELATED3, I_RELATED4, I_RELATED5, I_THUMBNAIL, I_IMAGE, I_SRP, I_COST, I_AVAIL, I_STOCK, I_ISBN, I_PAGE, I_BACKING, I_DIMENSIONS) VALUES (ITEM_SEQ.nextval,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			for (int i = 1; i <= DBHelper.itemNum; i++) {
				int month, day, year, maxday;
				I_TITLE = GetRandomObject.getRandomAString(14, 60);
				if (i <= (DBHelper.itemNum / 4))
					I_A_ID = i;
				else
					I_A_ID = GetRandomObject.getRandomInt(1, DBHelper.itemNum / 4);

				year = GetRandomObject.getRandomInt(1983, 2009);
				month = GetRandomObject.getRandomInt(0, 11);
				maxday = 31;
				if (month == 3 | month == 5 | month == 8 | month == 10)
					maxday = 30;
				else if (month == 1)
					maxday = 28;
				day = GetRandomObject.getRandomInt(1, maxday);
				cal = new GregorianCalendar(year, month, day);
				I_PUB_DATE = new java.sql.Date(cal.getTime().getTime());

				I_PUBLISHER = GetRandomObject.getRandomAString(14, 60);
				I_SUBJECT = SUBJECTS[GetRandomObject.getRandomInt(0, subjectsNum - 1)];
				I_DESC = GetRandomObject.getRandomAString(100, 500);

				I_RELATED1 = GetRandomObject.getRandomInt(1, itemNum);
				do {
					I_RELATED2 = GetRandomObject.getRandomInt(1, itemNum);
				} while (I_RELATED2 == I_RELATED1);
				do {
					I_RELATED3 = GetRandomObject.getRandomInt(1, itemNum);
				} while (I_RELATED3 == I_RELATED1 || I_RELATED3 == I_RELATED2);
				do {
					I_RELATED4 = GetRandomObject.getRandomInt(1, itemNum);
				} while (I_RELATED4 == I_RELATED1 || I_RELATED4 == I_RELATED2
						|| I_RELATED4 == I_RELATED3);
				do {
					I_RELATED5 = GetRandomObject.getRandomInt(1, itemNum);
				} while (I_RELATED5 == I_RELATED1 || I_RELATED5 == I_RELATED2
						|| I_RELATED5 == I_RELATED3 || I_RELATED5 == I_RELATED4);

				I_THUMBNAIL = new String("thumb_" + i + ".jpg");
				I_IMAGE = new String("item_" + i + ".jpg");

				int tem = GetRandomObject.getRandomInt(1, 10000);
				if (tem < 9500) {
					I_SRP = tem / 100.0 + 100;
				} else {
					I_SRP = tem / 100.0 + 900;
				}
				I_COST = I_SRP * 0.9;
				cal.add(Calendar.DAY_OF_YEAR, GetRandomObject.getRandomInt(1, 30));
				I_AVAIL = new java.sql.Date(cal.getTime().getTime());
				I_STOCK = GetRandomObject.getRandomInt(10, 30);
				I_ISBN = GetRandomObject.getRandomAString(13);
				I_PAGE = GetRandomObject.getRandomInt(20, 9999);
				I_BACKING = BACKINGS[GetRandomObject.getRandomInt(0, backingsNum - 1)];
				I_DIMENSIONS = ((double) GetRandomObject.getRandomInt(1, 9999) / 100.0) + "x"
						+ ((double) GetRandomObject.getRandomInt(1, 9999) / 100.0) + "x"
						+ ((double) GetRandomObject.getRandomInt(1, 9999) / 100.0);

				// Set parameter
				statement.setString(1, I_TITLE);
				statement.setInt(2, I_A_ID);
				statement.setDate(3, I_PUB_DATE);
				statement.setString(4, I_PUBLISHER);
				statement.setString(5, I_SUBJECT);
				statement.setString(6, I_DESC);
				statement.setInt(7, I_RELATED1);
				statement.setInt(8, I_RELATED2);
				statement.setInt(9, I_RELATED3);
				statement.setInt(10, I_RELATED4);
				statement.setInt(11, I_RELATED5);
				statement.setString(12, I_THUMBNAIL);
				statement.setString(13, I_IMAGE);
				statement.setDouble(14, I_SRP);
				statement.setDouble(15, I_COST);
				statement.setDate(16, I_AVAIL);
				statement.setInt(17, I_STOCK);
				statement.setString(18, I_ISBN);
				statement.setInt(19, I_PAGE);
				statement.setString(20, I_BACKING);
				statement.setString(21, I_DIMENSIONS);
				statement.addBatch();
				if (i % batchNum == 0){
					statement.executeBatch();
					statement.clearBatch();
				}
			}
			statement.executeBatch();
			statement.clearBatch();
			System.out.println("item populated.");
		} catch (java.lang.Exception ex) {
			System.err.println("Unable to populate ITEM table");
			ex.printStackTrace();
			System.exit(1);
		}
	}
	
	@SuppressWarnings("unused")
	private static void populateOrdersAndCC_XACTSTable() {
		GregorianCalendar cal;
		String[] credit_cards = { "VISA", "MASTERCARD", "DISCOVER", "AMEX", "DINERS" };
		int num_card_types = credit_cards.length;
		String[] ship_types = { "AIR", "UPS", "FEDEX", "SHIP", "COURIER", "MAIL" };
		int num_ship_types = ship_types.length;

		String[] status_types = { "PROCESSING", "SHIPPED", "PENDING", "DENIED" };
		int num_status_types = status_types.length;

		// Order variables
		int O_C_ID;
		java.sql.Date O_DATE;
		double O_SUB_TOTAL;
		double O_TAX;
		double O_TOTAL;
		String O_SHIP_TYPE;
		java.sql.Date O_SHIP_DATE;
		int O_BILL_ADDR_ID, O_SHIP_ADDR_ID;
		String O_STATUS;

		String CX_TYPE;
		int CX_NUM;
		String CX_NAME;
		java.sql.Date CX_EXPIRY;
		String CX_AUTH_ID;
		int CX_CO_ID;

		System.out.println("Populating ORDERS, ORDER_LINES, CC_XACTS with " + DBHelper.ordersNum
				+ " orders");
		try {
			PreparedStatement statement = con
					.prepareStatement("INSERT INTO ORDERS(O_ID, O_C_ID, O_DATE, O_SUB_TOTAL, O_TAX, O_TOTAL, O_SHIP_TYPE, O_SHIP_DATE, O_BILL_ADDR_ID, O_SHIP_ADDR_ID, O_STATUS) VALUES (ORDERS_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			PreparedStatement statement2 = con
					.prepareStatement("INSERT INTO ORDER_LINE (OL_ID, OL_O_ID, OL_I_ID, OL_QTY, OL_DISCOUNT, OL_COMMENTS) VALUES (?, ?, ?, ?, ?, ?)");
			PreparedStatement statement3 = con
					.prepareStatement("INSERT INTO CC_XACTS(CX_O_ID,CX_TYPE,CX_NUM,CX_NAME,CX_EXPIRE,CX_AUTH_ID,CX_XACT_AMT,CX_XACT_DATE,CX_CO_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

			for (int i = 1; i <= DBHelper.ordersNum; i++) {
				int num_items = GetRandomObject.getRandomInt(1, 5);
				O_C_ID = GetRandomObject.getRandomInt(1, DBHelper.customersNum);
				cal = new GregorianCalendar();
				cal.add(Calendar.DAY_OF_YEAR, -1 * GetRandomObject.getRandomInt(1, 60));
				O_DATE = new java.sql.Date(cal.getTime().getTime());
				O_SUB_TOTAL = (double) GetRandomObject.getRandomInt(1000, 999999) / 100;
				O_TAX = O_SUB_TOTAL * 0.0825;
				O_TOTAL = O_SUB_TOTAL + O_TAX + 3.00 + num_items;
				O_SHIP_TYPE = ship_types[GetRandomObject.getRandomInt(0, num_ship_types - 1)];
				cal.add(Calendar.DAY_OF_YEAR, GetRandomObject.getRandomInt(0, 7));
				O_SHIP_DATE = new java.sql.Date(cal.getTime().getTime());

				O_BILL_ADDR_ID = GetRandomObject.getRandomInt(1, 2 *  DBHelper.customersNum);
				O_SHIP_ADDR_ID = GetRandomObject.getRandomInt(1, 2 *  DBHelper.customersNum);
				O_STATUS = status_types[GetRandomObject.getRandomInt(0, num_status_types - 1)];

				// Set parameter
				statement.setInt(1, i);
				statement.setInt(2, O_C_ID);
				statement.setDate(3, O_DATE);
				statement.setDouble(4, O_SUB_TOTAL);
				statement.setDouble(5, O_TAX);
				statement.setDouble(6, O_TOTAL);
				statement.setString(7, O_SHIP_TYPE);
				statement.setDate(8, O_SHIP_DATE);
				statement.setInt(9, O_BILL_ADDR_ID);
				statement.setInt(10, O_SHIP_ADDR_ID);
				statement.setString(11, O_STATUS);
				statement.addBatch();

				for (int j = 1; j <= num_items; j++) {
					int OL_ID = j;
					int OL_O_ID = i;
					int OL_I_ID = GetRandomObject.getRandomInt(1, DBHelper.itemNum);
					int OL_QTY = GetRandomObject.getRandomInt(1, 300);
					double OL_DISCOUNT = (double) GetRandomObject.getRandomInt(0, 30) / 100;
					String OL_COMMENTS = GetRandomObject.getRandomAString(20, 100);
					statement2.setInt(1, OL_ID);
					statement2.setInt(2, OL_O_ID);
					statement2.setInt(3, OL_I_ID);
					statement2.setInt(4, OL_QTY);
					statement2.setDouble(5, OL_DISCOUNT);
					statement2.setString(6, OL_COMMENTS);
					statement2.addBatch();
				}
				
				CX_TYPE = credit_cards[GetRandomObject.getRandomInt(0, num_card_types - 1)];
				CX_NUM = GetRandomObject.getRandomNString(16);
				CX_NAME = GetRandomObject.getRandomAString(14, 30);
				cal = new GregorianCalendar();
				cal.add(Calendar.DAY_OF_YEAR, GetRandomObject.getRandomInt(10, 730));
				CX_EXPIRY = new java.sql.Date(cal.getTime().getTime());
				CX_AUTH_ID = GetRandomObject.getRandomAString(15);
				CX_CO_ID = GetRandomObject.getRandomInt(1, 92);
				statement3.setInt(1, i);
				statement3.setString(2, CX_TYPE);
				statement3.setInt(3, CX_NUM);
				statement3.setString(4, CX_NAME);
				statement3.setDate(5, CX_EXPIRY);
				statement3.setString(6, CX_AUTH_ID);
				statement3.setDouble(7, O_TOTAL);
				statement3.setDate(8, O_SHIP_DATE);
				statement3.setInt(9, CX_CO_ID);
				statement3.addBatch();
				if (i % batchNum == 0){
					statement.executeBatch();
					statement.clearBatch();
					statement2.executeBatch();
					statement2.clearBatch();
					statement3.executeBatch();
					statement3.clearBatch();
				}
			}
			statement.executeBatch();
			statement.clearBatch();
			statement2.executeBatch();
			statement2.clearBatch();
			statement3.executeBatch();
			statement3.clearBatch();
			System.out.println("oders populated.");
			System.out.println("cc_xacts populated.");
		} catch (java.lang.Exception ex) {
			System.err.println("Unable to populate CC_XACTS table");
			ex.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void addIndexes() {
		System.out.println("Adding Indexes...");
		try {
			PreparedStatement statement1 = con
					.prepareStatement("create index author_a_lname on author(a_lname)");
			statement1.executeUpdate();
			PreparedStatement statement2 = con
					.prepareStatement("create index address_addr_co_id on address(addr_co_id)");
			statement2.executeUpdate();
			PreparedStatement statement3 = con
					.prepareStatement("create index addr_zip on address(addr_zip)");
			statement3.executeUpdate();
			PreparedStatement statement4 = con
					.prepareStatement("create index customer_c_addr_id on customer(c_addr_id)");
			statement4.executeUpdate();
			PreparedStatement statement5 = con
					.prepareStatement("create index customer_c_uname on customer(c_uname)");
			statement5.executeUpdate();
			PreparedStatement statement6 = con
					.prepareStatement("create index item_i_title on item(i_title)");
			statement6.executeUpdate();
			PreparedStatement statement7 = con
					.prepareStatement("create index item_i_subject on item(i_subject)");
			statement7.executeUpdate();
			PreparedStatement statement8 = con
					.prepareStatement("create index item_i_a_id on item(i_a_id)");
			statement8.executeUpdate();
			PreparedStatement statement9 = con
					.prepareStatement("create index order_line_ol_i_id on order_line(ol_i_id)");
			statement9.executeUpdate();
			PreparedStatement statement10 = con
					.prepareStatement("create index order_line_ol_o_id on order_line(ol_o_id)");
			statement10.executeUpdate();
			PreparedStatement statement11 = con
					.prepareStatement("create index country_co_name on country(co_name)");
			statement11.executeUpdate();
			PreparedStatement statement12 = con
					.prepareStatement("create index orders_o_c_id on orders(o_c_id)");
			statement12.executeUpdate();
			PreparedStatement statement13 = con
					.prepareStatement("create index scl_i_id on shopping_cart_line(scl_i_id)");
			statement13.executeUpdate();
			System.out.println("Add Indexes done");
		} catch (java.lang.Exception ex) {
			System.out.println("Unable to add indexes");
			ex.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void start() {
		con = DBHelper.getConnection();
		deleteTables();
		createTables();
		populateAddressTable();
		populateAuthorTable();
		populateCountryTable();
		populateItemTable();
		populateCustomerTable();
		addIndexes();
		DBHelper.closeConnection(con);
	}
}
