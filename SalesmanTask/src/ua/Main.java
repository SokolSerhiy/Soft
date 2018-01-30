package ua;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Engine engine = new Engine();
		while (true) {
			System.out.println("Enter 1 to add city");
			System.out.println("Enter 2 to calculate result");
			switch (new Scanner(System.in).next()) {
			case "1":
				engine.add();
				break;
			case "2":
				engine.result();
				break;
			default:
				break;
			}
			
		}
	}
}