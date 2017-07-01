package com.psl.exception;

public class AppointmentNotPossibleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7529323974500736888L;

	@Override
	public String getMessage() {
		System.out.println("Can not arrange the appointment on the given date !");
		return super.getMessage();
	}

}
