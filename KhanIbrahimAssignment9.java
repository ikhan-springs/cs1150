/* 
 * Name: Ibrahim Khan
 * Class: CS1150-06
 * Due: Nov. 14, 2019
 * Description: Assignment #9
 * This assignment creates methods for calculating sums of arrays, retrieving specific pairs within an array, etc. This assignment also
 * creates a Dog class that is used to create dog objects with unique names and barks. 
 */

public class KhanIbrahimAssignment9 {

	public static void main(String[] args) {
		
		//Creating an array that will be used for all the methods below, except for the makeDogsBark method
		int[] mainArray = { 8, 2, 5, 3, 1, 7 };
		
		//Print statements for displaying each individual value of array
		System.out.println("Individual Values");
		System.out.println("-----------------------------------");
		display(mainArray); //Invoke display method to display individual values
		
		//Print statements for sum of all array values
		System.out.println("\nSum of All Values");
		System.out.println("-----------------------------------");
		System.out.println(computeSum(mainArray)); //Invoke computeSum method to get total sum
		
		//Print statements for sums of each consecutive pair
		System.out.println("\nSum of Each Consecutive Pair");
		System.out.println("-----------------------------------");
		displaySumOfEachConsecutivePair(mainArray); //Invoke displaySumOfEachConsecutivePair method to display sums of pairs
		
		//Print statements for sum of all consecutive pairs
		System.out.println("\nSum of All Consecutive Pairs");
		System.out.println("-----------------------------------");
		System.out.println(sumOfAllConsecutivePairs(mainArray)); //Invoke sumOfAllConsecutivePairs method to get consecutive pairs' sum
		
		//Print statements for sum of all possible pairs
		System.out.println("\nSum of All Possible Pairs");
		System.out.println("-----------------------------------");
		displaySumOfAllPairs(mainArray); //Invoke displaySumOfAllPairs to display sums of all pairs
		
		//Print statements for getting pairs whose sum is 10
		System.out.println("\nAny Pair Whose Sum is 10");
		System.out.println("-----------------------------------");
		displayPairsWithSpecificSum(mainArray, 10); //Invoke displayPairsWithSpecificSum and set number to 10 to get pairs equal to 10
		
		//Print statements for pair with largest sum
		System.out.println("\nPair With Largest Sum");
		System.out.println("-----------------------------------");
		displayPairWithLargestSum(mainArray); //Invoke displayPairWithLargestSum to get pair with largest sum
		
		//New array for five dog objects
		Dog[] dogArray = new Dog[5];
		
		//Creating five dog objects with names and barks
		Dog dog1 = new Dog("Rover", "woof woof");
		Dog dog2 = new Dog("Max", "arf arf arf");
		Dog dog3 = new Dog("Tiny", "yap yap yap");
		Dog dog4 = new Dog("Trooper", "ruff ruff ruff");
		Dog dog5 = new Dog("Magoo", "bow wow bow wow");
		
		//Putting all five dog objects into array
		dogArray[0] = dog1;
		dogArray[1] = dog2;
		dogArray[2] = dog3;
		dogArray[3] = dog4;
		dogArray[4] = dog5;
		
		//Print statements for dog array
		System.out.println("\nAn Array of Dog Objects");
		System.out.println("-----------------------------------");
		makeDogsBark(dogArray); //Invoke makeDogsBark method to get each dog's name and bark

	}

	//Displays the values in the array
	public static void display(int[] numbers) {

		//for loop that prints each value of the array
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("array[" + i + "] = " + numbers[i]);
		}
	}

	//Computes and returns the sum of the values in the array
	public static int computeSum(int[] numbers) {
		
		int sum = 0; //sum variable initialized to 0 and each array value will be added to this variable

		//for loop that adds each array value to the sum variable
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}

		return sum; //total sum of array values has been computed and is returned
	}

	//Computes and displays the sum of each consecutive pair
	public static void displaySumOfEachConsecutivePair(int[] numbers) {

		//for loop that adds each consecutive pair in an array
		for (int i = 0; i < (numbers.length - 1); i++) {
			
			//sum variable that adds current array value with the next one (does not do so for the last array value since there is no
			//value after the last one
			int sum = numbers[i] + numbers[i + 1];
			
			//Print statement that displays sum of each consecutive pair
			System.out.println(numbers[i] + " + " + numbers[i + 1] + " = " + sum);
		}
	}

	//Computes and returns the sum of all consecutive pairs in the array
	public static int sumOfAllConsecutivePairs(int[] numbers) {

		int totalSum = 0; //totalSum variable initialized to 0 and each pair sum will be added to this variable
		
		//for loop similar to one in previous method that adds each consecutive pair in an array
		for (int i = 0; i < (numbers.length - 1); i++) {
			
			//sum variable that adds current array value with the next one (does not do so for the last array value since there is no
			//value after the last one
			int sum = numbers[i] + numbers[i + 1];
			
			totalSum += sum; //each pair's sum is added to totalSum variable
		}

		return totalSum; //totalSum has each pair's sum added together and is returned
	}

	//Displays the sum of all possible pairs
	public static void displaySumOfAllPairs(int[] numbers) {

		//for loop that goes through each number and sets it as first addend
		for (int i = 0; i < (numbers.length - 1); i++) {

			//inner for loop that retrieves the second addend
			for (int j = i + 1; j < numbers.length; j++) {
				
				int sum = numbers[i] + numbers[j]; //adds the two addends together
				
				//Print statement that displays both addends and their sum
				System.out.println(numbers[i] + " + " + numbers[j] + " = " + sum);
			}
		}
	}

	//Find and display all pairs that have a specific sum
	public static void displayPairsWithSpecificSum(int[] numbers, int sum) {

		//for loop that goes through each number and sets it as first addend
		for (int i = 0; i < (numbers.length - 1); i++) {

			//inner for loop that retrieves second addend
			for (int j = i + 1; j < numbers.length; j++) {

				int eachSum = numbers[i] + numbers[j]; //adds the two addends together

				//if statement that checks if the sum of the two addends matches the specific sum from method's parameter
				if (eachSum == sum) {
					
					//Print statement if sum does equal specific sum
					System.out.println(
							"Pair at index " + i + " and " + j + " -> (" + numbers[i] + " + " + numbers[j] + ")");
				}
			}
		}
	}

	//Find and display the pair with the largest sum
	public static void displayPairWithLargestSum(int[] numbers) {

		int largestSum = 0; //largest sum variable initialized to 0 and will change when a higher sum is found
		int index1 = 0; //index1 variable for first addend of largest sum
		int index2 = 0; //index2 variable for second addend of largest sum

		//for loop that goes through each number and sets it as first addend
		for (int i = 0; i < (numbers.length - 1); i++) {

			//inner for loop that retrieves second addend
			for (int j = i + 1; j < numbers.length; j++) {
				
				int sum = numbers[i] + numbers[j]; //adds the two addends together

				//if statement that checks if new sum is greater than largestSum
				if (sum > largestSum) {
					largestSum = sum; //largestSum set to new sum since new sum is bigger
					index1 = i; //index1 set equal to array index of first addend
					index2 = j; //index2 set equal to array index of second addend
				}
			}
		}

		//Print statement of where pair with largest sum is located
		System.out.println("Pair at index " + index1 + " and " + index2 + " -> (" + numbers[index1] + " + "
				+ numbers[index2] + ")");
	}
	
	//Make each dog in the array bark
	public static void makeDogsBark(Dog[] dogArray) {
		 
		//for loop that goes through a Dog array, retrieves each dog's name, and how it barks
		for (int i = 0; i < dogArray.length; i++) {
			System.out.println(dogArray[i].getName()+" barks like this: "+dogArray[i].getBark());
		}
	}
	
} //Assignment 9

class Dog {

	private String name;
	private String bark;

	public Dog(String name, String bark) {
		this.name = name;
		this.bark = bark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBark() {
		return bark;
	}

	public void setBark(String bark) {
		this.bark = bark;
	}
}
