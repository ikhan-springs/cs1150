/*
 * Name: Ibrahim Khan
 * Class: CS1150-06
 * Due: Oct. 17, 2019
 * Description: Assignment #7
 * This assignment demonstrates the use of various methods with different parameters and return types.  Some methods are used in other
 * methods and the code in the main method is significantly reduced.
 */

import java.util.Scanner; //required to gather user input

public class KhanIbrahimAssignment7 {

	public static void main(String[] args) {
		
		//Welcome statement that will only print once
		System.out.println("Welcome to the Health Monitor");
		
		//This variable is used for the getHealthCheck method
		int healthCheckNumber = 1; //Set to 1 so that while loop starts running
		
		//while loop that repeats the program until user exits
		while (healthCheckNumber == 1 || healthCheckNumber == 2 || healthCheckNumber == 3) {
			
			//Menu
			System.out.println("\nOption\tHealth Check");
			System.out.println("--------------------------");
			System.out.println("1\tBMI");
			System.out.println("2\tBlood Pressure");
			System.out.println("3\tCholesterol");
			System.out.println("4\tExit");
			System.out.print("\nWhich health check? Select option 1, 2, 3, or 4: ");
			
			//Gets user input and converts it to string and int
			Scanner input = new Scanner (System.in);
			String number = input.nextLine();
			healthCheckNumber = Integer.parseInt(number);
			
			//Inner while loop to check that user presses only the available options (1, 2, 3, or 4)
			while (getHealthCheck(number) == 0) {
				
				//Invalid number shown
				System.out.println(number+" is not a valid entry - try again.");
				
				//Menu reprinted
				System.out.println("\nOption\tHealth Check");
				System.out.println("--------------------------");
				System.out.println("1\tBMI");
				System.out.println("2\tBlood Pressure");
				System.out.println("3\tCholesterol");
				System.out.println("4\tExit");
				System.out.print("\nWhich health check? Select option 1, 2, 3, or 4: ");
				
				//New user input that is converted to string and int
				input = new Scanner (System.in);
				number = input.nextLine();
				healthCheckNumber = Integer.parseInt(number);
			}
			
			//When user selects option 1 (BMI)
			if (healthCheckNumber == 1) {
				
				//Gets user's weight and converts to string
				System.out.print("\nEnter weight in pounds: ");
				Scanner input1 = new Scanner (System.in);
				String weight = input1.nextLine();
				
				//Gets user's height in feet and converts to string
				System.out.print("Enter height in feet: ");
				Scanner input2 = new Scanner (System.in);
				String heightFt = input2.nextLine();
				
				//Gets user's height in inches and converts to string
				System.out.print("Enter height in inches: ");
				Scanner input3 = new Scanner (System.in);
				String heightIn = input3.nextLine();
				
				//Uses displayResults method to get result
				displayResults(healthCheckNumber,checkBMI(getBMI(weight, heightFt, heightIn)));
				//getBMI method used to calculate BMI and checkBMI method used to classify BMI value
			}
			
			//When user selects option 2 (Blood Pressure)
			else if (healthCheckNumber == 2) {
				
				//Gets user's systolic number and converts to string
				System.out.print("\nEnter top blood pressure (systolic): ");
				Scanner input1 = new Scanner (System.in);
				String systolic = input1.nextLine();
				
				//Gets user's diastolic number and converts to string
				System.out.print("Enter bottom blood pressure (diastolic): ");
				Scanner input2 = new Scanner (System.in);
				String diastolic = input2.nextLine();
				
				//Convert two user inputs to ints so that testBloodPressure method can be invoked
				int topResult = Integer.parseInt(systolic);
				int bottomResult = Integer.parseInt(diastolic);
				
				//Uses displayResults method to get result
				displayResults(healthCheckNumber,testBloodPressure(topResult, bottomResult));
				//testBloodMeasure method classifies results
			}
			
			//When user selects option 3 (Cholesterol)
			else if (healthCheckNumber == 3) {
				
				//Gets user's cholesterol measure and converts to string
				System.out.print("\nEnter cholesterol: ");
				Scanner input1 = new Scanner (System.in);
				String cholesterol = input1.nextLine();
				
				//Converts input to int so that checkCholesterol method can be invoked
				int cholesterolResult = Integer.parseInt(cholesterol);
				
				//Uses displayResults method to get result
				displayResults(healthCheckNumber,checkCholesterol(cholesterolResult));
				//checkCholesterol method classifies result
			}
			
			//When user selects option 4 (Exit)
			else if (healthCheckNumber == 4) {
				System.out.println("\nHave a healthy day! Goodbye");
				//This is not in displayResults method because parameter requires a result and this option is not a test. Hence, 
				//there is no result
			}
		}
	}
	
	//This method returns whether the user menu selection is valid or not.  If valid, there are three different return values for
	//the three medical checks and one return value to exit.
	public static int getHealthCheck(String input) {
		
		//when user selects 1, method will return 1
		if (input.equals("1")) {
			return 1;
		}
		
		//when user selects 2, method will return 2
		else if (input.equals("2")) {
			return 2;
		}
		
		//when user selects 3, method will return 3
		else if (input.equals("3")) {
			return 3;
		}
		
		//when user selects 4, method will return 4
		else if (input.equals("4")) {
			return 4;
		}
		
		//when user selects any other number, method will return 0
		else {
			return 0;
		}
	}
	
	//This method gathers three strings to calculate the BMI
	public static double getBMI(String input1, String input2, String input3) {
		
		//The strings are converted to ints so that mathematical operations can be used
		int weight = Integer.parseInt(input1);
		int heightFt = Integer.parseInt(input2);
		int heightIn = Integer.parseInt(input3);
		
		//Calculates the total height in inches
		int height = (heightFt * 12) + heightIn;
		
		//BMI equation
		double BMI = ((703 * weight) / (height*height));
		
		//returns BMI
		return BMI;
	}
	
	//This method uses the BMI value from the getBMI method and returns if underweight, normal, or overweight
	public static String checkBMI(double bodyMassIndex) {
		
		//When BMI is less than 18.5, user is underweight 
		if (bodyMassIndex < 18.5) {
			return "Underweight";
		}
		
		//When BMI is greater than 25, user is overweight
		else if (bodyMassIndex > 25) {
			return "Overweight";
		}
		
		//When BMI is between 18.5 and 25, user is normal
		else {
			return "Normal";
		}
	}
	
	//This method checks blood pressure status using the systolic and diastolic measures
	public static String testBloodPressure(int topNumber, int bottomNumber) {
		
		//Normal blood pressure
		if (topNumber <= 120 && bottomNumber <= 80) {
			return "Normal";
		}
		
		//Elevated blood pressure
		else if (topNumber <= 129 && bottomNumber <= 80) {
			return "Elevated";
		}
		
		//Stage 1 high blood pressure
		else if (topNumber <= 139 && bottomNumber <= 89) {
			return "Stage 1 high blood pressure";
		}
		
		//Stage 2 high blood pressure
		else {
			return "Stage 2 high blood pressure";
		}
	}
	
	//This method checks cholesterol level and outputs if it is normal, high, or close to being high
	public static String checkCholesterol(int cholesterol) {
		
		//When cholesterol is less than 200, user's cholesterol level is good
		if (cholesterol < 200) {
			return "Good";
		}
		
		//When cholesterol is greater than 239, user's cholesterol level is high
		else if (cholesterol > 239) {
			return "High";
		}
		
		//When cholesterol is between 200 and 239, user's cholesterol level is borderline
		else {
			return "Borderline";
		}
	}
	
	//This method displays the results of each health check that user asks for
	public static void displayResults(int healthCheck, String result) {
		
		//Results of BMI check
		if (healthCheck == 1) {
			
			System.out.println("\n****************************************");
			System.out.println("BMI Result = "+result);
			System.out.println("****************************************");
		}
		
		//Results of blood pressure check
		else if (healthCheck == 2) {
			
			System.out.println("\n****************************************");
			System.out.println("Blood Pressure Result = "+result);
			System.out.println("****************************************");
		}
		
		//Results of cholesterol check
		else if (healthCheck == 3) {
			
			System.out.println("\n****************************************");
			System.out.println("Cholesterol Result = "+result);
			System.out.println("****************************************");
		}
	}
}
