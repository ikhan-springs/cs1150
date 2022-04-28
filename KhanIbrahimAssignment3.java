/*
 * Name: Ibrahim Khan
 * Class: CS1150-06
 * Due: Sept. 19, 2019
 * Description: Assignment #3
 * This assignment shows understanding of the math method, especially with the exponent. This assignment also uses tabs and 
 * new lines instead of using the space bar several times. This program can be used to calculate the amount of money in two 
 * certificate of deposit accounts that have monthly compounded interest.
 */

import java.util.Scanner; //for obtaining user input
import java.text.DecimalFormat; //to format decimal places

public class KhanIbrahimAssignment3 {

	public static void main(String[] args) {
		
		//Program introduction to user
		System.out.println("Welcome. This program calculates the final amount in two certificate of deposits accounts.");
		System.out.println("Please enter the following values. Enter values one at a time and hit enter after each one.");
		
		//Gathering CD #1 variables
		System.out.println("\nCD #1 Information");
		System.out.println("---------------------------------");
		System.out.println("Enter principle deposited: ");
		Scanner keyboard1 = new Scanner(System.in);
		double principle1 = keyboard1.nextDouble();
		System.out.println("Enter annual interest rate: ");
		Scanner keyboard2 = new Scanner(System.in);
		double interest_rate1 = keyboard2.nextDouble();
		System.out.println("Enter number of years: ");
		Scanner keyboard3 = new Scanner(System.in);
		double years1 = keyboard3.nextDouble();
		
		//Gathering CD #2 variables
		System.out.println("\nCD #2 Information");
		System.out.println("---------------------------------");
		System.out.println("Enter principle deposited: ");
		Scanner keyboard4 = new Scanner(System.in);
		double principle2 = keyboard4.nextDouble();
		System.out.println("Enter annual interest rate: ");
		Scanner keyboard5 = new Scanner(System.in);
		double interest_rate2 = keyboard5.nextDouble();
		System.out.println("Enter number of years: ");
		Scanner keyboard6 = new Scanner(System.in);
		double years2 = keyboard6.nextDouble();
		
		//Declaring constant
		final int TIMES_COMPOUNDED = 12;
		
		//Calculations for CD #1
		double percent_interest_rate1 = interest_rate1 / 100;
		double finalamt1 = principle1 * Math.pow((1 + (percent_interest_rate1 / TIMES_COMPOUNDED)),(TIMES_COMPOUNDED * years1));
		double interest_earned1 = finalamt1 - principle1;
		
		//Calculations for CD #2
		double percent_interest_rate2 = interest_rate2 / 100;
		double finalamt2 = principle2 * Math.pow((1 + (percent_interest_rate2 / TIMES_COMPOUNDED)),(TIMES_COMPOUNDED * years2));
		double interest_earned2 = finalamt2 - principle2;
		
		//Totals
		double total_principle = principle1 + principle2;
		double total_interest = interest_earned1 + interest_earned2;
		double both_amts = finalamt1 + finalamt2;
		
		//Decimal Format
		DecimalFormat money = new DecimalFormat("000.##");
		
		//Table with final amounts
		System.out.println("\n\n********************************************************************************");
		System.out.println("\t\t\tCertificate of Deposits");
		System.out.println("********************************************************************************");
		System.out.println("\t\tPrinciple\tRate\tYears\tInterest Earned\t  Final Amount");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("CD #1\t\t"+principle1+"0\t\t"+interest_rate1+"\t"+years1+"\t"+money.format(interest_earned1)+
				"\t\t  "+money.format(finalamt1));
		System.out.println("CD #2\t\t"+principle2+"0\t\t"+interest_rate2+"\t"+years2+"\t"+money.format(interest_earned2)+
				"\t\t  "+money.format(finalamt2));
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Totals\t\t"+total_principle+"0\t\t\t\t"+money.format(total_interest)+"\t\t  "+money.format(both_amts));
	}
}
