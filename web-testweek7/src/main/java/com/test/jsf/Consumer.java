package com.test.jsf;

public class Consumer {

	private String meterID;
	private int currMeterReading;
	private int prevMeterReading;
	private String zone;
	
	
	
	/**
	 * @return the meterID
	 */
	public String getMeterID() {
		return meterID;
	}



	/**
	 * @param meterID the meterID to set
	 */
	public void setMeterID(String meterID) {
		this.meterID = meterID;
	}



	/**
	 * @return the currMeterReading
	 */
	public int getCurrMeterReading() {
		return currMeterReading;
	}



	/**
	 * @param currMeterReading the currMeterReading to set
	 */
	public void setCurrMeterReading(int currMeterReading) {
		this.currMeterReading = currMeterReading;
	}



	/**
	 * @return the prevMeterReading
	 */
	public int getPrevMeterReading() {
		return prevMeterReading;
	}



	/**
	 * @param prevMeterReading the prevMeterReading to set
	 */
	public void setPrevMeterReading(int prevMeterReading) {
		this.prevMeterReading = prevMeterReading;
	}



	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}



	/**
	 * @param zone the zone to set
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}



	public Consumer( String meterID,int currMeterReading, int prevMeterReading, String zone) {
		super();
		this.meterID = meterID;
		this.currMeterReading = currMeterReading;
		this.prevMeterReading = prevMeterReading;
		this.zone = zone;
	}
	

}
	