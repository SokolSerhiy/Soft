package ua;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Engine engine = new Engine(sc);
		while (true) {
			System.out.println("Enter 1 to add city");
			System.out.println("Enter 2 to calculate result");
			switch (sc.next()) {
			case "1":
				engine.addNode();
				break;
			case "2":
				engine.calculate();
				break;
			default:
				break;
			}
		}
	}

}
