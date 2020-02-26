package com.nagarro.fareDuration;

import java.util.Collections;
import java.util.Comparator;

import com.nagarro.entity.Flight;
import java.util.List;

/* It compare the flights according to fare and duration */
public class FareDuration {
	public static void get(List<Flight> arr) {
		Collections.sort(arr, new Comparator<Flight>() {
			public int compare(Flight f1, Flight f2) {
				int fareCompare = f1.getFare() == f2.getFare() ? 0 : (f1.getFare() > f2.getFare() ? 1 : -1);
				int duraCompare = f1.getFlight_dur() == f2.getFlight_dur() ? 0
						: (f1.getFlight_dur() > f2.getFlight_dur() ? 1 : -1);
				if (fareCompare == 0) {
					return duraCompare;
				} else {
					return fareCompare;
				}
			}
		});
	}

}