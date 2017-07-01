package com.psl.bean;

import java.sql.Date;

public class Appointment implements Comparable<Appointment>{

	private int appointmentId;
	private Date date;
	private Double fee;
	private int visitorId;
	private Visitor visitor;
	
	
	public Appointment()
	{
		
	}
	public Appointment(int appointmentId, Date date, Double fee, int visitorId,
			Visitor visitor) {
		super();
		this.appointmentId = appointmentId;
		this.date = date;
		this.fee = fee;
		this.visitorId = visitorId;
		this.visitor = visitor;
	}
	
	
	
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", date=" + date
				+ ", fee=" + fee + ", visitorId=" + visitorId + ", visitor="
				+ visitor + "]";
	}
	
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public Visitor getVisitor() {
		return visitor;
	}
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}
	public int getVisitorId() {
		return visitorId;
	}
	
	
	@Override
	public int compareTo(Appointment ap1) {
		// TODO Auto-generated method stub
		if(this.getAppointmentId()<ap1.getAppointmentId())
			return 1;
		else
			return -1;
		
	}
	
}
