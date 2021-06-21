package db_connection;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import ExceptionHandling.WikipediaNoArcticleException;
import hua.dit.omada20.City;
import collections.*;

public class Db {
	public Db() {
		
	}
	
	public void insert_data(City city){
	
	String jdbcURL = "jdbc:oracle:thin:@oracle12c.hua.gr:1521:orcl";
	String username = "it21959";
    String password = "IT21959";
    
    Connection connection = null;
    
    //int batchsize = 20;
    try {
    	connection = DriverManager.getConnection(jdbcURL, username, password);
    	connection.setAutoCommit(false);
    	
    	String sql_city = "INSERT INTO citiesdb (cityName,cafe,sea, museum,restaurant,stadium,square,lat,lon) VALUES (?, ?,?,?,?,?,?,?,?)";
    	
    	PreparedStatement statement_vc = connection.prepareStatement(sql_city);
    	
    	statement_vc.setString(1, city.getName());
    	statement_vc.setInt(2,city.getTerms().get(0) );
    	statement_vc.setInt(3,city.getTerms().get(1) );
    	statement_vc.setInt(4,city.getTerms().get(2) );
    	statement_vc.setInt(5,city.getTerms().get(3) );
    	statement_vc.setInt(6,city.getTerms().get(4) );
    	statement_vc.setInt(7,city.getTerms().get(5) );
    	statement_vc.setDouble(8, city.getGeodesic().get(0));
    	statement_vc.setDouble(9, city.getGeodesic().get(1));
   
    	statement_vc.addBatch();
    	statement_vc.executeBatch();
    	
    	connection.commit();
        connection.close();
    }catch(SQLException exe) {
        exe.printStackTrace();

        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }	   
}
	
	public HashMap<String, City> return_data()throws  IOException, WikipediaNoArcticleException{
		//return data
		String jdbcURL = "jdbc:oracle:thin:@oracle12c.hua.gr:1521:orcl";
		String username = "it21959";
	    String password = "IT21959";
	    
	    Connection connection = null;
	    HashMap<String,City> tempMap = new HashMap<String,City>();
	    Mapping map_from_db = new Mapping();
	    try {
	    	connection = DriverManager.getConnection(jdbcURL, username, password);
	    	connection.setAutoCommit(false);
	    	
	    	String getCity = "SELECT * FROM  citiesdb ";
	    	
	    	Statement stmt = connection.createStatement();
	    	ResultSet rs = stmt.executeQuery(getCity);
	    	
	    	
	    	
	    	while (rs.next()) {
	           String s1  = rs.getString(1);
	           int a1 = rs.getInt(2);
	           int a2 = rs.getInt(3);
	           int a3  = rs.getInt(4);
	           int a4  = rs.getInt(5);
	           int a5  = rs.getInt(6);
	           int a6 = rs.getInt(7);
	           double d1  = rs.getDouble(8);
	           double d2 = rs.getDouble(9);
	           City tempCity = new City();
	           Vector<Integer> tempTerms = new Vector<Integer>();
	           Vector<Double> tempGeodesic = new Vector<Double>();
	           tempTerms.add(a1);
	           tempTerms.add(a2);
	           tempTerms.add(a3);
	           tempTerms.add(a4);
	           tempTerms.add(a5);
	           tempTerms.add(a6);
	           tempGeodesic.add(d1);
	           tempGeodesic.add(d2);
	           
	           tempCity.setName(s1);
	           tempCity.setTerms(tempTerms);
	           tempCity.setGeodesic(tempGeodesic);
	           
	           map_from_db.hashPut(tempMap, tempCity);
	           
	           
	           System.out.printf("from database "
	           +s1 +" " +a1 +" " +a2 +" " +a3 +" " +a4 +" " +a5 +" "
	        		   +a6 +" " +d1 +" " +d2  +"\n");
	           
	          }
	    	
	    	map_from_db.setCities_map(tempMap);
	    	
	    	connection.commit();
	        connection.close();
	        
	     } catch(SQLException exe) {
	         exe.printStackTrace();

	         try {
	             connection.rollback();
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	     
	         
	     	}
	    map_from_db.Iter(tempMap);
	    return map_from_db.getCities_map();
	}//end of return data	
}
