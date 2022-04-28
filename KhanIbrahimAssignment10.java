/* 
 * Name: Ibrahim Khan
 * Class: CS1150-06
 * Due: Nov. 21, 2019
 * Description: Assignment #10
 * This assignment uses object-oriented programming to create an array of Car objects, which are also used in a Dealership object.
 * A few Car objects are created and manipulations are performed on them, then the same manipulations are performed after the Car
 * objects are transferred to the Dealership object.
 */

public class KhanIbrahimAssignment10 {
	
	public static void main(String[] args) {
		
		//Creating 8 new Car objects with unique names and prices
		Car car1 = new Car("Toyota Tacoma   ", 29400);
		Car car2 = new Car("Ford Mustang    ", 31700);
		Car car3 = new Car("BMW X1          ", 31000);
		Car car4 = new Car("Tesla Model-S   ", 72900);
		Car car5 = new Car("Nissan Altima   ", 14300);
		Car car6 = new Car("Dodge Challenger", 17900);
		Car car7 = new Car("Mini Convertible", 26000);
		Car car8 = new Car("Porsche Cayenne ", 43500);
		
		//Creating new array to hold Car objects
		Car[] carArray = new Car[8];
		
		//The 8 Car objects are added to the array
		carArray[0] = car1;
		carArray[1] = car2;
		carArray[2] = car3;
		carArray[3] = car4;
		carArray[4] = car5;
		carArray[5] = car6;
		carArray[6] = car7;
		carArray[7] = car8;
		
		//Print statements to see cars in array
		System.out.println("**********************************");
		System.out.println("\tCars in Array");
		System.out.println("**********************************");
		System.out.println("\nCar\t\t\t\tPrice");
		System.out.println("-----------------------------------------");
		
		//for loop that iterates through each Car object in array and prints each object's name and price
		for (int i = 0; i < carArray.length; i++) {
			
			//Print statement for object
			System.out.printf("%s\t\t%.2f\n", carArray[i].getName(), carArray[i].getPrice());
		}
		
		//Print statements to see car with highest price in the array
		System.out.println("\nCar with highest price in the array of cars");
		System.out.println("----------------------------------------------------");
		
		int highestPriceIndex = 0; //index variable set to 0, so there is no need of iterating through first object in for loop
		
		//for loop iterates through carArray and finds car with highest price
		for (int i = 1; i < carArray.length; i++) {
			
			double price1 = carArray[i].getPrice(); //price1 variable set to price of Car object that is iterated on
			double price2 = carArray[highestPriceIndex].getPrice(); //price2 variable set to current highest priced car
			
			//if a higher price is found
			if (price1 > price2) {
				highestPriceIndex = i; //new index variable that identifies Car object with highest price
			}
			
		}
		
		//Print statements for highest priced Car object's name and price
		System.out.println("Car:\t"+carArray[highestPriceIndex].getName());
		System.out.printf("Price:\t%7.2f", carArray[highestPriceIndex].getPrice());
		
		//new Dealership object created with same length as carArray
		Dealership carDealership = new Dealership(carArray.length);
		
		//Adding all 8 Car objects to Dealership object
		carDealership.addCar(car1);
		carDealership.addCar(car2);
		carDealership.addCar(car3);
		carDealership.addCar(car4);
		carDealership.addCar(car5);
		carDealership.addCar(car6);
		carDealership.addCar(car7);
		carDealership.addCar(car8);
		
		//Print statements to see cars in Dealership object
		System.out.println("\n\n******************************************");
		System.out.println("\tCars in Dealership Object");
		System.out.println("******************************************");
		System.out.println("\nCar\t\t\t\tPrice");
		System.out.println("-----------------------------------------");
		
		//for loop that iterates through each Car object in Dealership object and prints each Car object's name and price
		for (int i = 0; i < carDealership.getNumCars(); i++) {
			
			//Car variable created and set to the Car object that is being iterated on
			Car iteratedCar = carDealership.getCarAtIndex(i);
			
			//Print statement for Car object
			System.out.printf("%s\t\t%7.2f\n", iteratedCar.getName(), iteratedCar.getPrice());
		}
		
		//Print statements to see car with highest price in the Dealership object
		System.out.println("\nCar with highest price in dealership that contains an array of cars");
		System.out.println("----------------------------------------------------------------------");
		
		int highestDealershipPriceIndex = 0; //index variable set to 0
		
		//for loop iterates through Dealership object and finds car with highest price
		for (int i = 1; i < carArray.length; i++) {

			double price1 = carArray[i].getPrice(); //price1 variable set to price of Car object that is iterated on
			double price2 = carArray[highestDealershipPriceIndex].getPrice(); //price2 variable set to current highest priced car

			// if a higher price is found
			if (price1 > price2) {
				highestDealershipPriceIndex = i; //new index variable that identifies Car object with highest price
			}

		}

		//Print statements for highest priced Car object's name and price
		System.out.println("Car:\t" + carArray[highestDealershipPriceIndex].getName());
		System.out.printf("Price:\t%7.2f", carArray[highestDealershipPriceIndex].getPrice());
	}
	
} //Assignment 10

//Class that represents one car
class Car {
	
	private String name; //String identifier for car's name
	private double price; //double identifier for car's price
	
	//Constructor that initializes name and price to incoming name and price
	public Car (String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	//Getter that returns car's name
	public String getName() {
		return this.name;
	}
	
	//Getter that returns car's price
	public double getPrice() {
		return this.price;
	}
	
} //Car class

//Class that represents one car dealership that contains a maximum number of cars
class Dealership {
	
	private Car[] cars; //Array of Car objects
	private int numCars; //int identifier for number of Car objects that dealership currently has
	
	//Constructor that allocates memory for cars array
	public Dealership(int maxNumCars) {
		
		this.cars = new Car[maxNumCars]; //Length of array is set to maxNumCars
		this.numCars = 0; //numCars initialized to 0 since there are no cars yet in the dealership
	}
	
	//Getter that returns the number of cars in the dealership
	public int getNumCars() {
		
		return this.numCars;
	}
	
	//Getter that returns a car at a given index location in the dealership's array of cars
	public Car getCarAtIndex(int index) {
		
		return this.cars[index];
	}
	
	//Setter that adds a car to the dealership's array of cars
	public void addCar (Car carToAdd) {
		
		cars[numCars] = carToAdd;
		numCars++; //numCars incremented since a car has been added
	}
	
} //Dealership class