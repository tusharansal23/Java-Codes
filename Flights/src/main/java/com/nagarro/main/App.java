/*
 * Author : Ishika Maheshwari
 */

package com.nagarro.main;

import java.util.Timer;
import java.util.TimerTask;
import com.nagarro.folderThread.FolderThread;
import com.nagarro.handler.InputHandler;
import com.nagarro.entity.EndUser;

/* Main Class */
public class App {

	/*
	 * Get the input from enduser and at runtime apply timer task to load the csv files
	 */

	public static void main(String[] args) {
		EndUser obj = InputHandler.get();
		Timer timer = new Timer();
		FolderThread f = new FolderThread(obj);
		TimerTask task = (TimerTask) f;
		timer.schedule(task, 1000, 50000000);
	}
}
