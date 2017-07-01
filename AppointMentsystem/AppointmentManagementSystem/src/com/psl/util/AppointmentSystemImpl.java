package com.psl.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.psl.bean.Appointment;
import com.psl.bean.Visitor;
import com.psl.exception.AppointmentNotPossibleException;

public class AppointmentSystemImpl implements AppointmentSystem {

	@Override
	public Set<Appointment> populateData() {
		Set<Appointment> returnSet = new TreeSet<Appointment>(
				new Comparator<Appointment>() {

					@Override
					public int compare(Appointment a1, Appointment a2) {
						return a1.getDate().compareTo(a2.getDate());
					}
				});

		List<Visitor> listVisitor = new ArrayList<Visitor>();

		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		connection = new ConnectionManagerImpl().getConnection();
		// if(connection!=null)System.out.println("connected succefully !");
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM visitor v;");

			while (rs.next()) {
				int visitorId = rs.getInt(1);
				String visitorName = rs.getString(2);
				String problemDescription = rs.getString(3);

				listVisitor.add(new Visitor(visitorId, visitorName,
						problemDescription));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// System.out.println(listVisitor.size());
		// for (Visitor visitor : listVisitor) {
		// System.out.println(visitor);
		// }

		connection = new ConnectionManagerImpl().getConnection();
		// if(connection!=null)System.out.println("connected succefully !");
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM appointment a;");

			while (rs.next()) {

				int appointmentId = rs.getInt(1);
				Date date = rs.getDate(2);
				Double fee = rs.getDouble(3);
				int visitorId = rs.getInt(4);
				Visitor visitor = null;

				returnSet.add(new Appointment(appointmentId, date, fee,
						visitorId, visitor));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// System.out.println(returnSet.size());
		// for (Appointment appointment : returnSet) {
		// System.out.println(appointment.getDate());
		// }

		for (Appointment appointment : returnSet) {
			for (Visitor visitor : listVisitor) {
				if (visitor.getVisitorId() == appointment.getVisitorId()) {
					appointment.setVisitor(visitor);
				}
			}
		}
		Calendar currCal = Calendar.getInstance();
		Iterator<Appointment> iterator = returnSet.iterator();
		while (iterator.hasNext()) {
			Appointment appointment = iterator.next();
			if (appointment.getDate().before(currCal.getTime())) {
				iterator.remove();
			}

		}

		return returnSet;
	}

	@Override
	public Appointment showVisitorAppointment(Set<Appointment> treeSet,int visitorid) {
		
		for (Appointment appointment : treeSet) {
			if(appointment.getVisitor().getVisitorId()==visitorid){
				return appointment;
			}
		}
		return null;
		
	}

	@Override
	public List<Appointment> getVisitorsByMonth(Set<Appointment> treeSet,int month) {
		
		List<Appointment> returnList=new ArrayList<Appointment>();
		for (Appointment appointment : treeSet) {
			Calendar cal=Calendar.getInstance();
			cal.setTime(appointment.getDate());
			if((cal.get(Calendar.MONTH)+1)==month){
				returnList.add(appointment);
			}
		}
		return returnList;
		
	}

	@Override
	public boolean bookAppointment(Set<Appointment> treeSet, Date date)throws AppointmentNotPossibleException {
		
		boolean repeat=false;
		for (Appointment appointment : treeSet) {
			if(appointment.getDate().equals(date)){
				repeat=true;
			}
		}
		
		if(repeat){
			throw new AppointmentNotPossibleException();
		}
		
		return true;
	}

}
