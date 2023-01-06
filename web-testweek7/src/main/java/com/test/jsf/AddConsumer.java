package com.test.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;



public class AddConsumer  {

	private String meterID;
	private int currMeterReading;
	private int prevMeterReading;
	private String zone;



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



public String add()
{
SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
int i = 0;

if(meterID !=null)
{
PreparedStatement ps = null;
Connection con = null; 
try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/record", "root", "priyanka@1");
String sql = "INSERT INTO user1(meterID, currMeterReading, prevMeterReading, zone) VALUES(?,?,?,?)";
ps= con.prepareStatement(sql); 
ps.setString(1, meterID);
ps.setInt(2, currMeterReading);
ps.setInt(3,prevMeterReading);
ps.setString(4, zone);
if(con!=null)
{
	System.out.println("iam in");
}
else
{
	System.out.println("not yet");
}
i = ps.executeUpdate();
System.out.println("Data Added Successfully");
}
catch(Exception e)
{
System.out.println(e); 
}
finally
{
try
{
con.close();
ps.close();
}
catch(Exception e)
{
e.printStackTrace();
}
}
if(i >0)
{
return "output";
}
else
{
return "invalid";
}
}
else
{
return "invalid";
}
} 
}