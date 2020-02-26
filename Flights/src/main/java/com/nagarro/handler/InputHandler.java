package com.nagarro.handler;

import java.util.Scanner;
import com.nagarro.validation.InputValidator;
import com.nagarro.entity.EndUser;

/* It is a class which handles the enduser input and store it on an object */
public class InputHandler {
	public static EndUser get() {
		String dep;
		String arv;
		String fdate;
		String fclass;
		String outpre;
		Scanner sc = new Scanner(System.in);
		EndUser obj = new EndUser();
		while (true) {
			System.out.println("Enter Departure Location");
			dep = sc.nextLine();
			if (InputValidator.isValidateDep(dep)) {
				obj.setDep(dep);
				break;
			}
		}
		while (true) {
			System.out.println("Enter Arrival Location");
			arv = sc.nextLine();
			if (InputValidator.isValidateArr(arv)) {
				obj.setArv(arv);
				break;
			}
		}
		while (true) {
			System.out.println("Enter Flight date in Format(dd-mm-yyyy)");
			fdate = sc.nextLine();
			if (InputValidator.isValidDate(fdate)) {
				obj.setFdate(fdate);
				break;
			}
		}
		while (true) {
			System.out.println("Enter Flight Class E for Economic EB for Business");
			fclass = sc.nextLine();
			if (InputValidator.isValidClass(fclass)) {
				obj.setFclass(fclass);
				break;
			}
		}
		while (true) {
			System.out.println(
					"Enter 1 for sorted according to fare and 2 for sorted according to both fare and duration");
			outpre = sc.nextLine();
			if (InputValidator.isValidOut(outpre)) {
				obj.setOutpre(outpre);
				break;
			}
		}
		sc.close();
		return obj;
	}
}
