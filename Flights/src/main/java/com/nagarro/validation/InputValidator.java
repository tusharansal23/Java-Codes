package com.nagarro.validation;

/* Validate the inputs */
public class InputValidator {

	/*
	 * Validate Arrival Location . The input locations should be 3 letter location
	 * code format
	 */
	public static boolean isValidateArr(String s) {
		try {
			if (s.length() == 0 || s.length() != 3) {
				throw new InvalidInputException("Invalid");
			}
			for (int i = 0; i < 3; i++) {
				char ch = Character.toLowerCase(s.charAt(i));
				if (ch >= 'a' && ch <= 'z') {

				} else {
					throw new InvalidInputException("Invalid");
				}
			}
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	/*
	 * Validate Departure Location . The input locations should be 3 letter location
	 * code format
	 */

	public static boolean isValidateDep(String s) {
		try {
			if (s.length() == 0 || s.length() != 3) {
				throw new InvalidInputException("Invalid");
			}
			for (int i = 0; i < 3; i++) {
				char ch = Character.toLowerCase(s.charAt(i));
				if (ch >= 'a' && ch <= 'z') {
				} else {
					throw new InvalidInputException("Invalid");
				}
			}
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	/* Validate Flight date */

	public static boolean isValidDate(String s) {
		int res = 0;
		try {
			if (s.length() == 0 || s.length() > 10) {
				throw new InvalidInputException("Invalid");
			}
			for (int i = 0; i < s.length(); i++) {
				if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
					if (s.charAt(i) == '-') {
						res++;
					} else {
						throw new InvalidInputException("Invalid");
					}
				}
			}
			if (res != 2) {
				throw new InvalidInputException("Invalid");
			}
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;

	}

	/* Validate Flight Class. It Should be E or EB */
	public static boolean isValidClass(String s) {
		try {
			if (s.length() == 0) {
				throw new InvalidInputException("Invalid");
			}
			if (!s.equalsIgnoreCase("E") && !s.equalsIgnoreCase("EB")) {
				throw new InvalidInputException("Invalid");
			}
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;

	}

	/*
	 * Validate Output Preferences. It suggests whether flight result should be
	 * sorted only by fare or by both fare and flight duration.
	 */
	public static boolean isValidOut(String s) {
		try {
			if (s.length() == 0) {
				throw new InvalidInputException("Invalid");
			}
			if (!s.equals("1") && !s.equals("2")) {
				throw new InvalidInputException("Invalid");
			}
		} catch (InvalidInputException e) {
			System.err.print(e.getMessage());
			return false;
		}
		return true;
	}

}
