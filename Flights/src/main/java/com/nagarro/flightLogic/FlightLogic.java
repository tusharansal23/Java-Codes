package com.nagarro.flightLogic;

import com.nagarro.entity.Flight;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collection;

import com.nagarro.entity.EndUser;
import com.nagarro.handler.OutputHandler;
import com.nagarro.fareCompare.FareCompare;
import com.nagarro.fareDuration.FareDuration;

/* Calculate the prefered flights according to  enduser and sort 
 *the flights only by fare or by both  fare and flight duration.*/

public class FlightLogic {
	public static void calculate(ArrayList<Flight> arr, EndUser obj) {
		ArrayList<Flight> myList = new ArrayList<Flight>();
		SimpleDateFormat smd = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date d1 = smd.parse(obj.getFdate());
			for (Flight flight : arr) {
				Date d2 = smd.parse(flight.getValid());
				if (flight.getSeat().equals("Y") && (d1.compareTo(d2) <= 0)
						&& flight.getDep().equalsIgnoreCase(obj.getDep())
						&& flight.getArr().equalsIgnoreCase(obj.getArv())
						&& flight.getFlight_class().equalsIgnoreCase(obj.getFclass())) {
					myList.add(flight);
				}
			}
		} catch (ParseException e) {
			System.out.println(e);
		}

		/* If there is no prefered flight then display the message */
		if (myList.isEmpty()) {
			System.err.println("Departure Location or Arrival Location does not exist");
			System.exit(0);
		}

		/*
		 * If output preference equals to 1 then sort by fare else sort by both fare and
		 * duration
		 */

		if (obj.getOutpre().equals("1")) {
			FareCompare.get(myList);
		} else {
			FareDuration.get(myList);
		}

		for (Flight f : myList) {
			OutputHandler.display(f);
		}
	}

}
