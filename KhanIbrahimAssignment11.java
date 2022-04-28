/* 
 * Name: Ibrahim Khan
 * Class: CS1150-06
 * Due: Nov. 28, 2019
 * Description: Assignment #11
 * This assignment uses object-oriented programming to create an array of Car objects. Each car object has a FuelGauge object that
 * determines whether fuel is left in the car after driving a certain amount of miles.  This program tests which Car object runs out
 * of gas first out of all the cars in the array.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class KhanIbrahimAssignment11 {

	public static void main(String[] args) throws IOException {
		
		Car[] carArray = new Car[5]; //array created to hold 5 Car objects
		carSetup(carArray); //carSetup method invoked to construct the Car objects
		
		//Print statements for beginning of simulation
		System.out.println("Cars at start of simulation");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Owner\t\tBrand\t\tFuel Economy\tGallons");
		System.out.println("-------------------------------------------------------------");
		
		printCars(carArray); //printCars method invoked to print details of each Car object in the array
		
		boolean allCarsHaveGas = true; //boolean variable created to end the while loop when one Car runs out of gas
		int milesTraveled = 1; //milesTraveled variable created to see how far the Car travels before running out of gas
		String oneWhoRunsOut = ""; //String variable created for owner of Car 
		
		//while loop that runs until one car runs out of gas
		while (allCarsHaveGas == true) {
			
			//for loop that iterates through each car for every mile traveled
			for (int i = 0; i < carArray.length; i++) {
				
				carArray[i].updateFuel(milesTraveled); //updateFuel method invoked to reduce gallons in Car
				
				//if statement when one Car runs out of gas
				if (carArray[i].getFuelGauge().getGallons() <= 0) {
					allCarsHaveGas = false; //causes while loop to end
					oneWhoRunsOut = carArray[i].getOwner().trim(); //obtains owner of Car that ran out of gas
				}
			}
			
			milesTraveled++; //milesTraveled incremented to keep track of miles traveled
		}
		
		//Print statements for end of simulation
		System.out.println("\nCars at end of simulation");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Owner\t\tBrand\t\tFuel Economy\tGallons");
		System.out.println("-------------------------------------------------------------");
		
		printCars(carArray); //printCars method invoked to print details of each Car object in the array
		
		//Print statement that shows which Car ran out of gas after how many miles
		System.out.println("\n"+oneWhoRunsOut+"'s car ran out of gas after "+(milesTraveled-1)+" miles");
		//milesTraveled is subtracted by 1 since it was initialized to 1 instead of 0
	}
	
	//Set up the cars for the simulation based on the table 
	public static void carSetup(Car[] cars) {
		
		cars[0] = new Car("Shrek   ", "Toyota Tundra", 17, 12);
		cars[1] = new Car("Fiona   ", "Audi Q7 ", 20, 20);
		cars[2] = new Car("Donkey  ", "Jeep CJ5", 15, 5);
		cars[3] = new Car("Farquaad", "Smart Car", 40, 5);
		cars[4] = new Car("Dragon  ", "Chevy Suburban", 14, 30);
	}

	//Print the details for each car in the array 
	public static void printCars(Car[] cars) {
		
		for (int i = 0; i < cars.length; i++) {
			System.out.printf("%s\t%s\t%.2f\t\t%.2f\n", cars[i].getOwner(), cars[i].getBrand(), cars[i].getFuelEconomy(), cars[i].getFuelGauge().getGallons());
		}
	}
	
	//Method that prints each car's details to a file
	public static void writeCarDetailsToFile(Car[] cars) throws IOException {

		//Setup the file reference variable to refer to the text file.
		//Assignment11.txt is the file that will be created on your hard drive.
		File fileName = new File("Assignment11.txt");

		//Create the file that the cars will be written to. This means:
		//Connect Assignment11.txt on your hard drive to the variable resultsFile in the code.
		PrintWriter resultsFile = new PrintWriter(fileName);

		//Write the details for each car to the file
		resultsFile.println("Car Details");
		for (int i = 0; i < cars.length; i++) {
			resultsFile.println(cars[i].getOwner());
			resultsFile.println(cars[i].getBrand());
			resultsFile.println(cars[i].getFuelEconomy());
			resultsFile.println(cars[i].getFuelGauge().getGallons());
			resultsFile.println();
		}

		resultsFile.close();

	} // writeCarDetailsToFile
	
} //Assignment 11

class Car {
	
	private String owner; //Initialize owner variable
	private String brand; //Initialize brand variable
	private double fuelEconomy; //Initialize fuelEconomy variable
	private FuelGauge fuelGauge; //Initialize fuelGauge variable
	
	//Car constructor
	public Car(String owner, String brand, double fuelEconomy, double gallons) {
		
		this.owner = owner; //owner given to Car
		this.brand = brand; //brand given to Car
		this.fuelEconomy = fuelEconomy; //fuelEconomy given to Car
		fuelGauge = new FuelGauge(); //allocate memory for fuelGauge variable
		fuelGauge.setGallons(gallons); //set number of gallons in car to fuelGauge
	}
	
	//Getter for owner
	public String getOwner() {
		return owner;
	}
	
	//Getter for Car brand
	public String getBrand() {
		return brand;
	}
	
	//Getter for fuel economy
	public double getFuelEconomy() {
		return fuelEconomy;
	}
	
	//Getter for fuel gauge
	public FuelGauge getFuelGauge() {
		return fuelGauge;
	}
	
	//updateFuel method that decreases the amount of fuel after each mile traveled
	public void updateFuel(double milesTraveled) {
		double gallonsUsed = milesTraveled / fuelEconomy; //gallonsUsed is set to number of gallons used so far
		fuelGauge.decrementGallons(gallonsUsed); //decrementGallons method invoked to reduce gallons by gallonsUsed
	}
	
} //Car class

class FuelGauge {
	
	private double initialGallons; //Initialize initialGallons variable which remains constant
	private double currentGallons; //Initialize currentGallons variable which changes after each mile traveled
	
	//Getter that returns the amount of gallons remaining in the Car
	public double getGallons() {
		return currentGallons;
	}
	
	//Setter that sets amount of gallons in Car (i.e. similar to refilling gas)
	public void setGallons(double gallons) {
		this.initialGallons = gallons;
		this.currentGallons = gallons;
	}
	
	//Method that decrements gallons after each mile traveled
	public void decrementGallons(double gallonsUsed) {
		this.currentGallons = this.initialGallons - gallonsUsed;
	}
	
} //FuelGauge class