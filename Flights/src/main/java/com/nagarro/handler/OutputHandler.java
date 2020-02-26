package com.nagarro.handler;

import com.nagarro.entity.Flight;
import com.nagarro.constants.Constants;

/* Output Handler handles the output and displays the output on screen .
 * It increases fare if the flight class in business .
 */
public class OutputHandler {
	public static void display(Flight f) {
		if (f.getFlight_class().equalsIgnoreCase("EB")) {
			float fare = f.getFare();
			fare *= Constants.PERCENTAGE;
			f.setFare(fare);
		}
		System.out.println(f);
	}

}
