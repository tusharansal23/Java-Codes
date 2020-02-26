package com.nagarro.csvReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import com.nagarro.entity.Flight;

/* Read the csv files after that stores the flight object into ArrayList */
public class CsvReader {
	public static void getData(File file, List<Flight> arr) {
		Flight flight;
		try {
			Scanner sc = new Scanner(file);
			sc.next();
			while (sc.hasNext()) {
				String value = sc.next();
				String values[] = value.split(",");
				flight = new Flight();
				flight.setFlight_No(values[0]);
				flight.setDep(values[1]);
				flight.setArr(values[2]);
				flight.setValid(values[3]);
				flight.setFlight_time(Integer.parseInt(values[4]));
				flight.setFlight_dur(Float.parseFloat(values[5]));
				flight.setFare(Integer.parseInt(values[6]));
				flight.setSeat(values[7]);
				flight.setFlight_class(values[8]);
				arr.add(flight);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
}
