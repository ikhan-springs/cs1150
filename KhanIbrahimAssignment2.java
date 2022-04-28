/*
 * Name: Ibrahim Khan
 * Class: CS1150-06
 * Due: Sept. 12, 2019
 * Description: Assignment #2
 * This assignment shows understanding of boolean expressions and if statements through a car rental program.
 */

import java.util.Scanner; //for obtaining user input
import java.text.DecimalFormat; //to format decimal places

public class KhanIbrahimAssignment2 {

	public static void main(String[] args) {
		
		//Menu
		System.out.println("Welcome to CS1150 Car Rental");
		System.out.println("");
		System.out.println("Option    Car            Rental Fee Per Day");
		System.out.println("-------------------------------------------");
		System.out.println(" 1        Economy        $ 23.00");
		System.out.println(" 2        Mid-Size       $ 33.00");
		System.out.println(" 3        Full Size      $ 35.00");
		System.out.println(" 4        Premium        $ 40.00");
		System.out.println("");
		
		//Declaring taxes and fees variable
		final double TAXES_FEES = .105;
		DecimalFormat money = new DecimalFormat("00.##"); 
		
		//User selection for type of car
		System.out.println("Select type of car (1, 2, 3, or 4): ");
		Scanner keyboard1 = new Scanner (System.in);
		int option = keyboard1.nextInt();
		
		//Making sure a valid car menu option is selected
		if (option == 1 || option == 2 || option == 3 || option == 4) {
			System.out.println("How many days (1 to 30)?");
			Scanner keyboard2 = new Scanner (System.in);
			int days = keyboard2.nextInt();
			
			//Making sure the number of days is between 1 and 30
			if (days <= 0 || days >= 31) {
				System.out.println(days+" is not a valid number of days. Please run program again.");
			}
			else {
				
				//Calculations for economy car
				if (option == 1) {
					int econ = days*23;
					double econtaxes = econ*TAXES_FEES;
				
					System.out.println("-------------------------");
					System.out.println("Type              Economy");
					System.out.println(days+" days            $ "+econ+".00");
					System.out.println("Taxes and Fees    $ "+money.format(econtaxes));
					System.out.println("-------------------------");
					System.out.println("Total Cost        $ "+money.format((econ+econtaxes)));
				}
				
				//Calculations for mid-size car
				else if (option == 2) {
					int mid = days*33;
					double midtaxes = mid*TAXES_FEES;
				
					System.out.println("-------------------------");
					System.out.println("Type              Mid-Size");
					System.out.println(days+" days            $ "+mid+".00");
					System.out.println("Taxes and Fees    $ "+money.format(midtaxes));
					System.out.println("-------------------------");
					System.out.println("Total Cost        $ "+money.format((mid+midtaxes)));
				}
				
				//Calculations for full size car
				else if (option == 3) {
					int full = days*35;
					double fulltaxes = full*TAXES_FEES;
				
					System.out.println("-------------------------");
					System.out.println("Type              Full Size");
					System.out.println(days+" days            $ "+full+".00");
					System.out.println("Taxes and Fees    $ "+money.format(fulltaxes));
					System.out.println("-------------------------");
					System.out.println("Total Cost        $ "+money.format((full+fulltaxes)));
				}
				
				//Calculations for premium car
				else if (option == 4) {
					int prem = days*40;
					double premtaxes = prem*TAXES_FEES;
				
					System.out.println("-------------------------");
					System.out.println("Type              Premium");
					System.out.println(days+" days            $ "+prem+".00");
					System.out.println("Taxes and Fees    $ "+money.format(premtaxes));
					System.out.println("-------------------------");
					System.out.println("Total Cost        $ "+money.format((prem+premtaxes)));
				}
			}						
		}
		
		else {
			System.out.println(option+" is not a valid car menu option. Please run program again.");
		}
	}
}
