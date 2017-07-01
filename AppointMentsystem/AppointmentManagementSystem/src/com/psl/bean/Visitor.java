package com.psl.bean;

public class Visitor {

	private int visitorId;
	private String visitorName;
	private String problemDescription;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Visitor [visitorId=" + visitorId + ", visitorName="
				+ visitorName + ", problemDescription=" + problemDescription
				+ "]";
	}
	public Visitor(int visitorId, String visitorName, String problemDescription) {
		super();
		this.visitorId = visitorId;
		this.visitorName = visitorName;
		this.problemDescription = problemDescription;
	}
	public int getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
