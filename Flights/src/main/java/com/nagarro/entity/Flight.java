package com.nagarro.entity;

/* A class which is used to set and get flight data to calculate the prefered flights */
public class Flight {

	private String flight_No;
	private String dep;
	private String arr;
	private String valid;
	private int flight_time;
	private float flight_dur;
	private float fare;
	private String seat;
	private String flight_class;

	public String getFlight_No() {
		return flight_No;
	}

	public void setFlight_No(String flight_No) {
		this.flight_No = flight_No;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getArr() {
		return arr;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public int getFlight_time() {
		return flight_time;
	}

	public void setFlight_time(int flight_time) {
		this.flight_time = flight_time;
	}

	public float getFlight_dur() {
		return flight_dur;
	}

	public void setFlight_dur(float flight_dur) {
		this.flight_dur = flight_dur;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getFlight_class() {
		return flight_class;
	}

	public void setFlight_class(String flight_class) {
		this.flight_class = flight_class;
	}

	// @override

	public String toString() {
		return "flightNo" + " " + flight_No + "  " + "fare" + " " + fare + "  " + "Flight_Dur" + " " + flight_dur;
	}

}
