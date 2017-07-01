package com.psl.main;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import com.psl.bean.Appointment;
import com.psl.exception.AppointmentNotPossibleException;
import com.psl.util.AppointmentSystemfinal;


public class Client {

	public static void main(String[] args) {
	
		
//		Calendar cal=Calendar.getInstance();
//		System.out.println(cal.get(Calendar.MONTH));
		

		AppointmentSystemfinal final12 = new AppointmentSystemfinal();
		Set<Appointment> appointmentSet= final12.populateData();
		System.out.println(appointmentSet);
		
		Appointment appointment = final12.showVisitorAppointment(appointmentSet, 103);
		System.out.println(appointment);
		
		System.out.println();
		List<Appointment> appList = final12.getVisitorsByMonth(appointmentSet,8);
		System.out.println(appList);
		
		
		
		
		
	//	System.out.println(date);
		
		try {
			boolean isPossible = final12.bookAppointment(appointmentSet,Date.valueOf("2014-08-25"));
			isPossible = final12.bookAppointment(appointmentSet, Date.valueOf("2014-08-23"));
		} catch (AppointmentNotPossibleException e) {
			// TODO Auto-generated catch block
			System.out.println("Not Possible");;
		}
/*		AppointmentSystemImpl impl=new AppointmentSystemImpl();
		Set<Appointment>  set=impl.populateData();
*/		
		
//		System.out.println("\n\n\n\n\n");
//		System.out.println(set.size());
//		for (Appointment appointment : set) {
////			System.out.println(appointment.getVisitor().getVisitorId()+"\t"+appointment.getVisitorId());
//			System.out.println(appointment.getDate());
//		}
		
//		System.out.println(impl.showVisitorAppointment(set, 104));
		
//		System.out.println("\n\n\n\n\n");
//		List<Appointment> list=impl.getVisitorsByMonth(set, 11);
//		System.out.println(list.size());
//		for (Appointment appointment : list) {
//			System.out.println(appointment.getDate());
//		}
		
/*		try {
			System.out.println(impl.bookAppointment(set, Date.valueOf("2014-10-06")));
		} catch (AppointmentNotPossibleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
	}

}
