package com.nagarro.folderThread;

import java.io.File;
import com.nagarro.csvReader.CsvReader;
import com.nagarro.entity.Flight;
import com.nagarro.flightLogic.*;
import com.nagarro.entity.EndUser;
import java.util.TimerTask;
import java.util.ArrayList;

/* It apply the timer task and get the .csv files from the given path.
 *  After this stores the file data into ArrayList .
 *  After this calculate the desired flights 
 */
public class FolderThread extends TimerTask {
	EndUser obj;
	ArrayList<Flight> arr;

	public FolderThread(EndUser obj) {
		this.arr = new ArrayList<Flight>();
		this.obj = obj;
	}
	
	/* @override */

	public void run() {

		File file = new File("D://Assignment//Links/");
		File files[] = file.listFiles();
		for (File f : files) {
			CsvReader.getData(f, arr);
		}
		FlightLogic.calculate(arr, obj);
	}

}
