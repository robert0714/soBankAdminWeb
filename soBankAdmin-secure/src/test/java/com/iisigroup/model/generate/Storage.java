package com.iisigroup.model.generate;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Storage {

    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    Properties properties = new Properties();

    public static void main(String[] args){
    	getConnection() ;
    }
    //This method is used to verify whether the pre-requisites are satisfied before a reservation is done

    

    //The method corresponding to the getReservationDetails() in ReservationService
    // This is used to get details of a particular reservation from RESERVATION_T table

    

    //This method takes care of establishing the jdbc connection with HOTEL_RESERVATION_DB

    public static Connection getConnection()  {
        String driverName = "org.h2.Driver";
        String conectionURI = null;        
        conectionURI = "jdbc:h2:~/sec_db;INIT=RUNSCRIPT FROM 'classpath:database/h2/security.sql'";



		try {
			Class driverClass = Class.forName(driverName);
			Connection connection = DriverManager.getConnection(conectionURI);
			connection.setAutoCommit(true);
			return connection;
		} catch (Exception e) {
			throw new RuntimeException("Can not get the data base conneciton",
					e);
		}
    }


}
