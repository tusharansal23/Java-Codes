package com.nagarro.fareCompare;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import com.nagarro.entity.Flight;
import java.util.List;

/* it compare  the flights according to flight fare */
public class FareCompare {
	public static void get(ArrayList<Flight> arr) {
		Collections.sort(arr, new Comparator<Flight>() {
			public int compare(Flight f1, Flight f2) {
				return (int) (f1.getFare() - f2.getFare());
			}
		});
	}
}
