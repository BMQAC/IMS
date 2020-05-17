package com.qa.interoperability;

import java.util.Scanner;

public class Scan {

	static Scanner scan = new Scanner(System.in);

	public String inputString() {
		String input;
		input = scan.nextLine();
		return input;
	}

	public int inputInt() {
		int input;
		input = scan.nextInt();
		scan.nextLine();
		return input;
	}
	
	public Double inputDouble() {
		double input;
		input = scan.nextDouble();
		scan.nextLine();
		return input;
	}

	public void closeScan() {
		scan.close();
	}
}
