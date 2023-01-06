package com.test.jsf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="data")
@RequestScoped
public class ConsumerData {
	private String meterID;
	private int currMeterReading;
	private int prevMeterReading;
	private String zone;
	
		 
	private static final List<Consumer> consList = new ArrayList<>();
	
	
	public List<Consumer> getConsumers(){
		
	if(consList.size() == 0) {
		
	
    Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = null;
	        //Scanner sc = new Scanner(System.in);
	        String url = "jdbc:mysql://localhost:3306/infinite";
	        String user = "root";
	        String pass = "priyanka@1";
	        con = DriverManager.getConnection(url,user,pass);
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from consumer");
	        while(rs.next()) {
	        	consList.add(new Consumer(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4)));
	        	
	        }
	        String sql = "INSERT INTO user1(meterID, currMeterReading, prevMeterReading, zone) VALUES(?,?,?,?)";
	    	ps= con.prepareStatement(sql); 
	    	ps.setString(1, getMeterID());
	    	ps.setInt(2, getCurrMeterReading());
	    	ps.setInt(3,getPrevMeterReading());
	    	ps.setString(4, getZone());
	        
	       
		 }  
	        catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return consList;
	}
	else {
		return consList;
	}
	}
	
	
	
	public void addConsumer() {
		consList.add(new Consumer(meterID, currMeterReading, prevMeterReading, zone));
		
		
	}

	public String getMeterID() {
		return meterID;
	}

	public void setMeterID(String meterID) {
		this.meterID = meterID;
	}

	public int getCurrMeterReading() {
		return currMeterReading;
	}

	public void setCurrMeterReading(int currMeterReading) {
		this.currMeterReading = currMeterReading;
	}

	public int getPrevMeterReading() {
		return prevMeterReading;
	}

	public void setPrevMeterReading(int prevMeterReading) {
		this.prevMeterReading = prevMeterReading;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public static List<Consumer> getConslist() {
		return consList;
	}
	
	
	
}