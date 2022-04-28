/*
 * Name: Ibrahim Khan
 * Class: CS1150-06
 * Due: Oct. 3, 2019
 * Description: Assignment #5
 * This assignment demonstrates understanding of loops, specifically while and for loops.  Loops are used to repeat lines of code,
 * so that the code does not have to be re-written over and over again.
 */

import java.util.Scanner;

public class KhanIbrahimAssignment5 {

	public static void main(String[] args) {
		
		//Instructions for user
		System.out.print("Enter sequence of strings ending with the string \"exit\": ");
		
		//Using the Scanner to obtain user input
		Scanner keyboard = new Scanner (System.in);
		String input = keyboard.nextLine();
		
		//if statement to make sure user's input contains the word "exit"
		if (input.contains("exit") == true) {
			
			//if statement to make sure user's input ends with the word "exit"
			if (input.endsWith("exit") == true) {
				
				//Calculating word count and character count
				int wordCount = 0;
				int characterCount = 0;
				for (int spaceCheck = 0; spaceCheck < (input.length() - 4); spaceCheck++) {
					if (input.charAt(spaceCheck) == ' ') {
						wordCount++;
					}
					else {
						characterCount++;
					}
				}
				
				//Calculating number of vowels and consonants
				int vowelCount = 0;
				int consonantCount = 0;
				for (int letterCheck = 0; letterCheck <= (input.length() - 5); letterCheck++) {
					if (input.charAt(letterCheck) == 'a' || input.charAt(letterCheck) == 'e' || input.charAt(letterCheck) == 'i' ||
							input.charAt(letterCheck) == 'o' || input.charAt(letterCheck) == 'u' || input.charAt(letterCheck) == 'A' ||
							input.charAt(letterCheck) == 'E' || input.charAt(letterCheck) == 'I' || input.charAt(letterCheck) == 'O' ||
							input.charAt(letterCheck) == 'U') {
						
						vowelCount++;
					}
					else if (input.charAt(letterCheck) == 'b' || input.charAt(letterCheck) == 'c' || input.charAt(letterCheck) == 'd' ||
							input.charAt(letterCheck) == 'f' || input.charAt(letterCheck) == 'g' || input.charAt(letterCheck) == 'h' ||
							input.charAt(letterCheck) == 'j' || input.charAt(letterCheck) == 'k' || input.charAt(letterCheck) == 'l' ||
							input.charAt(letterCheck) == 'm' || input.charAt(letterCheck) == 'n' || input.charAt(letterCheck) == 'p' ||
							input.charAt(letterCheck) == 'q' || input.charAt(letterCheck) == 'r' || input.charAt(letterCheck) == 's' ||
							input.charAt(letterCheck) == 't' || input.charAt(letterCheck) == 'v' || input.charAt(letterCheck) == 'w' ||
							input.charAt(letterCheck) == 'x' || input.charAt(letterCheck) == 'y' || input.charAt(letterCheck) == 'z' ||
							input.charAt(letterCheck) == 'B' || input.charAt(letterCheck) == 'C' || input.charAt(letterCheck) == 'D' ||
							input.charAt(letterCheck) == 'F' || input.charAt(letterCheck) == 'G' || input.charAt(letterCheck) == 'H' ||
							input.charAt(letterCheck) == 'J' || input.charAt(letterCheck) == 'K' || input.charAt(letterCheck) == 'L' ||
							input.charAt(letterCheck) == 'M' || input.charAt(letterCheck) == 'N' || input.charAt(letterCheck) == 'P' ||
							input.charAt(letterCheck) == 'Q' || input.charAt(letterCheck) == 'R' || input.charAt(letterCheck) == 'S' ||
							input.charAt(letterCheck) == 'T' || input.charAt(letterCheck) == 'V' || input.charAt(letterCheck) == 'W' ||
							input.charAt(letterCheck) == 'X' || input.charAt(letterCheck) == 'Y' || input.charAt(letterCheck) == 'Z') {
						
						consonantCount++;
					}
				}
				//Variables for calculating smallest and longest words
				int longestLength = 0, smallestLength = input.length();
				String longestWord = "", smallestWord = "";
				
				//while loop to process each word and obtain the first character, last character, and length of each word
				while (input.indexOf(" ") > 0) {
					
					String word = input.substring(0, input.indexOf(" "));
					
					System.out.println("\nProcessing word\t\t"+word);
					System.out.println("First character is\t"+word.charAt(0));
					System.out.println("Last character is\t"+word.charAt(word.length()-1));
					System.out.println("Length is\t\t"+word.length());
					
					input = input.substring(input.indexOf(" ") + 1, input.length());
					
					//if statement for getting smallest word
		            if (smallestLength > word.length()) {			
		            	
		            	smallestWord = word;
		            	smallestLength = word.length();
		            }
					
		            //if statement for getting longest word
					if (longestLength < word.length()) {
		            	
		            	longestWord = word;
		            	longestLength = word.length();
		            }
				}
				
				//if statement for no words entered except "exit"
				if (wordCount == 0) {
					System.out.println("\nNo words were entered except \"exit\"");
				}
				
				else {
				//Outputs for entire string statistics
				System.out.println("\nNumber of words\t\t= " + wordCount);
				System.out.println("Number of characters\t= " + characterCount);
				System.out.println("Number of vowels\t= " + vowelCount);
				System.out.println("Number of consonants\t= " + consonantCount);
				System.out.println("The smallest word\t= " + smallestWord);
				System.out.println("The largest word\t= " + longestWord);
				
				}
			}
		}
		
		//if user input did not have the word "exit"
		else {
			System.out.println("\nThe string does not contain the word \"exit\"");
		}
	}
}
