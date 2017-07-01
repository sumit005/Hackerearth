package com.psl.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.psl.bean.Appointment;
import com.psl.bean.Visitor;
import com.psl.exception.AppointmentNotPossibleException;

public class AppointmentSystemfinal implements AppointmentSystem{

	public static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	@Override
	public Set<Appointment> populateData() {
		
		 Set<Appointment> treeSet = new TreeSet<Appointment>();
		
		try {
			Scanner sc = new Scanner(new File("src/appointment.txt"));
			while(sc.hasNext())
			{
				String[] words= sc.nextLine().split("\\t");
				
				java.util.Date date = sdf.parse(words[1].trim());
				Calendar cal = Calendar.getInstance();
				
			//	if(date.after(cal.getTime())){    //this is condition but we have all inputs before present date so commentted out  
				int appointmentId = Integer.parseInt(words[0].trim());
				java.sql.Date datefinal =   new java.sql.Date(date.getTime());
				Double fee = Double.parseDouble(words[2].trim());
				int visitorId= Integer.parseInt(words[3].trim());
				Visitor visitor = null;
				
				Appointment apt = new Appointment(appointmentId,null,fee,visitorId,visitor);
				
				apt.setDate(datefinal);
				treeSet.add(apt);
			//	}
			}
			List<Visitor> visitorlist = new ArrayList<Visitor>();
			sc = new Scanner(new File("src/vistors.txt"));
			while(sc.hasNext())
			{
				String[] word = sc.nextLine().split(",");
				int visitorId = Integer.parseInt(word[0].trim());
				String visitorName = word[1].trim();
				String problemDescription = word[2].trim();
				
				visitorlist.add(new Visitor(visitorId,visitorName,problemDescription));
			}
			
			for(Appointment apt : treeSet)
			{
				for(Visitor visitor : visitorlist)
				{
					if(apt.getVisitorId()==visitor.getVisitorId())
						apt.setVisitor(visitor);
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return treeSet;
	}

	@Override
	public Appointment showVisitorAppointment(Set<Appointment> treeSet,
			int visitorid) {
		
		for(Appointment apt:treeSet)
		{
			if(apt.getVisitorId()==visitorid)
				return apt;
		}
		
		return null;
	}

	@Override
	public List<Appointment> getVisitorsByMonth(Set<Appointment> treeSet,
			int month) {
			Calendar date = Calendar.getInstance();
			List<Appointment> appList = new ArrayList<Appointment>();
			for(Appointment appointment:treeSet)
			{
				date.setTime(appointment.getDate());
				if(date.get(Calendar.MONTH) == 8-1)
				{	
					appList.add(appointment);
				}
			}
					
		return appList;
	}

	@Override
	public boolean bookAppointment(Set<Appointment> treeSet, Date date)
			throws AppointmentNotPossibleException {
	
		boolean isPossible = true;
		for(Appointment appointment:treeSet)
		{
		//	System.out.println(appointment.getDate());
		//	System.out.println);
		//	Date d = new java.sql.Date(appointment.getDate().getTime());
		
			if(appointment.getDate().equals(date))
			{
				System.out.println(appointment.getDate());
				isPossible=false;
			}
			
		}
		if(!isPossible)
			throw new AppointmentNotPossibleException();
		else
		{	System.out.println(date);
			System.out.println("Possible");
		return true;}
	}

	
}
