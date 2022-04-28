/*
 * Name: Ibrahim Khan
 * Class: CS1150-06
 * Due: Sept. 26, 2019
 * Description: Assignment #4
 * This assignment shows understanding of the random method in the math class as well as understanding of characters and strings.
 * The program uses user input, string methods, and if statements to create random ticket numbers for the four DisneyWorld parks.
 */

import java.util.Scanner;

public class KhanIbrahimAssignment4 {

	public static void main(String[] args) {
		
		//Starting menu
		System.out.println("Welcome to DisneyWorld Ticket Central! Please enter two characters based on the following criteria.");
		System.out.println("E: Epcot\tM: Magic Kingdom\tH: Hollywood Studios\tA: Animal Kingdom");
		System.out.println("1: One Park\t2: Park Hopper");
		
		//Gathering user input
		Scanner keyboard = new Scanner (System.in);
		String selection = keyboard.next();
		
		//Declaring constant characters for the four parks
		final char EPCOT = 'E';
		final char MAGIC = 'M';
		final char HOLLYWOOD = 'H';
		final char ANIMAL = 'A';
		final char ONE_PARK = '1';
		final char PARK_HOPPER = '2';
		
		//Random variables
		char randomCharacter = (char)('A' + Math.random() * ('Z' - 'A' + 1));
		char randomCharacter2 = (char)('A' + Math.random() * ('Z' - 'A' + 1));
		int randomNumber = 0 + (int)(Math.random() * 10);
		int random2Digit = 10 + (int)(Math.random() * 90);
		int random3Digit = 100 + (int)(Math.random() * 900);
		int random3Digit2 = 100 + (int)(Math.random() * 900);
		int random5Digit = 10000 + (int)(Math.random() * 90000);
		
		//if statements for selecting Epcot
		if (selection.toUpperCase().charAt(0) == EPCOT) {
			if (selection.charAt(1) == ONE_PARK) {
				System.out.println("Epcot: " + randomCharacter + " " + random3Digit + " " + random3Digit2 + " -- One Park Only Ticket");
			}
			else if (selection.charAt(1) == PARK_HOPPER) {
				System.out.println("Epcot: " + randomCharacter + " " + random3Digit + " " + random3Digit2 + " -- Park Hopper");
			}
			else {
				System.out.println("You have entered an invalid input. Please run program again.");
			}
		}
		
		//if statements for selecting Magic Kingdom
		else if (selection.toUpperCase().charAt(0) == MAGIC) {
			if (selection.charAt(1) == ONE_PARK) {
				System.out.println("Magic Kingdom: " + random2Digit + "-" + random3Digit + " MK -- One Park Only Ticket");
			}
			else if (selection.charAt(1) == PARK_HOPPER) {
				System.out.println("Magic Kingdom: " + random2Digit + "-" + random3Digit + " MK -- Park Hopper");
			}
			else {
				System.out.println("You have entered an invalid input. Please run program again.");
			}
		}
		
		//if statements for selecting Hollywood Studios
		else if (selection.toUpperCase().charAt(0) == HOLLYWOOD) {
			if (selection.charAt(1) == ONE_PARK) {
				System.out.println("Hollywood Studios: " + randomNumber + " " + random5Digit + " " + randomCharacter + " -- One Park Only Ticket");
			}
			else if (selection.charAt(1) == PARK_HOPPER) {
				System.out.println("Hollywood Studios: " + randomNumber + " " + random5Digit + " " + randomCharacter + " -- Park Hopper");
			}
			else {
				System.out.println("You have entered an invalid input. Please run program again.");
			}
		}
		
		//if statements for selecting Animal Kingdom
		else if (selection.toUpperCase().charAt(0) == ANIMAL) {
			if (selection.charAt(1) == ONE_PARK) {
				System.out.println("Animal Kingdom: " + random2Digit + " " + randomCharacter + randomCharacter2 + " -- One Park Only Ticket");
			}
			else if (selection.charAt(1) == PARK_HOPPER) {
				System.out.println("Animal Kingdom: " + random2Digit + " " + randomCharacter + randomCharacter2 + " -- Park Hopper");
			}
			else {
				System.out.println("You have entered an invalid input. Please run program again.");
			}
		}
		
		else {
			System.out.println("You have entered an invalid input. Please run program again.");
		}
	}
}
