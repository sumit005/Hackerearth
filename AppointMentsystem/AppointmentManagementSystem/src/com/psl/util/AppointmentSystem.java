package com.psl.util;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.psl.bean.Appointment;
import com.psl.exception.AppointmentNotPossibleException;

public interface AppointmentSystem {

	Set<Appointment> populateData();//discard appointments before the present date and arrange them in the ascending order of there date 
	Appointment  showVisitorAppointment(Set<Appointment> treeSet,int visitorid);
	List<Appointment> getVisitorsByMonth(Set<Appointment> treeSet,int month);//this will show the appointments for a given month
	boolean bookAppointment(Set<Appointment> treeSet,Date date) throws AppointmentNotPossibleException;
	//determine whether appointment is possible for given date only one appointment for a given day if day not available throw exception.
	
	
	
}
