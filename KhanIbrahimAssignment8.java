/*
 * Name: Ibrahim Khan
 * Class: CS1150-06
 * Due: Nov. 7, 2019
 * Description: Assignment #8
 * This assignment deals with arrays and demonstrates four skills related to arrays, shown by each method.  These skills are: displaying an 
 * individual array in a list, removing duplicate numbers within an array, sorting an array, and finding common elements between multiple arrays. 
 */

public class KhanIbrahimAssignment8 {

	public static void main(String[] args) {
		
		//3 arrays that will be used in the methods of this program
		int[] array1 = {2, 12, 8, 14, 45, 6, 4, 10};
		int[] array2 = {4, 2, 2, 2, 45, 4};
		int[] array3 = {10, 4, 45, 2, 10, 2, 8};
		
		//Print statements for original arrays
		System.out.println("**********************************");
		System.out.println("Original Arrays");
		System.out.println("**********************************");
		
		//Invoking displayList method on the three arrays to display each array value
		displayList(array1, "Num1");
		displayList(array2, "Num2");
		displayList(array3, "Num3");
		
		//Print statements for arrays without duplicate values
		System.out.println("\n**********************************");
		System.out.println("Removing Duplicates");
		System.out.println("**********************************");
		
		//Invoking removeDuplicates method to remove duplicate values, then arrays displayed using displayList method
		displayList(removeDuplicates(array1), "Num1 - Duplicates Removed");
		displayList(removeDuplicates(array2), "Num2 - Duplicates Removed");
		displayList(removeDuplicates(array3), "Num3 - Duplicates Removed");
		
		//Print statements for sorted arrays
		System.out.println("\n**********************************");
		System.out.println("Sorting");
		System.out.println("**********************************");
		
		//Invoking sort method to sort non-duplicate arrays, then arrays displayed using displayList method
		displayList(sort(removeDuplicates(array1)), "Num1 - No Duplicates - Sorted");
		displayList(sort(removeDuplicates(array2)), "Num2 - No Duplicates - Sorted");
		displayList(sort(removeDuplicates(array3)), "Num3 - No Duplicates - Sorted");
		
		//Print statements for common elements array
		System.out.println("\n**********************************");
		System.out.println("Finding Common Elements");
		System.out.println("**********************************");
		
		//New array that contains common elements of the sorted first and second arrays and created with findCommonElements method
		int[] twoCombinedArrays = findCommonElements(sort(removeDuplicates(array1)), sort(removeDuplicates(array2)));
		//findCommonElements method compares new array with sorted third array
		//then one array with common elements is displayed using displayList method
		displayList(findCommonElements(sort(removeDuplicates(twoCombinedArrays)), sort(removeDuplicates(array3))), "Common Elements Between 3 Arrays");
		
	}
	
	//displays the values in an array whose name is provided
	public static void displayList (int[] array, String arrayName) {
		
		//print statement for array name
		System.out.println("\n"+arrayName);
		System.out.println("-----------------------------------------------");
		
		//for loop that prints each value of the array
		for (int i = 0; i < array.length; i++) {
			System.out.println("array["+i+"] =\t\t"+array[i]);
		}
	}
	
	//remove all duplicated values in the array
	public static int[] removeDuplicates(int[] arrayWithDuplicates) {
		
		//temporary array is created so that the original array's values are not changed
		int[] temporaryArray = new int[arrayWithDuplicates.length]; //array only contains zeros and is the same length as original array
		
		//temporary variable created to be used when copying from original array to temporary array
		int temporaryVariable = 0;
		
		//for loop that fills temporary array with non-duplicate values
		for (int i = 0; i < arrayWithDuplicates.length; i++) {
			
			//boolean created to check for duplicates in the inner for loop below
			boolean compare = false;
			
			//inner for loop that compares the original and temporary arrays to check for duplicate values
			for (int j = 0; j < arrayWithDuplicates.length; j++) {
				
				//if statement runs when array values do not match
				if (temporaryArray[j] != arrayWithDuplicates[i]) {
					compare = true;
				}
				//else statement runs when a duplicate value is found
				else {
					compare = false;
					j = arrayWithDuplicates.length; //causes inner for loop to end
				}
			}
			
			//if statement that will only run when there are no duplicates
			if (compare == true) {
				
				//copies unique value to temporary array
				temporaryArray[temporaryVariable] = arrayWithDuplicates[i];
				//temporary variable increased so that the next unique value can be copied into the next array index
				temporaryVariable++;
			}
		}
		
		int arrayLength = 0; //variable that determines the length of the returned array
		
		//for loop that increases arrayLength variable until a zero is found
		for (int i = 0; i < temporaryArray.length; i++) {
			
			//if statement runs when a zero is found in the temporary array
			if (temporaryArray[i] == 0) {
				i = temporaryArray.length; //causes for loop to end
			}
			else {
				arrayLength++; //length increased if zero is not found
			}
		}
		
		int[] arrayWithoutDuplicates = new int[arrayLength]; //new array that will be returned when method is invoked
		
		//for loop that copies temporary array values to new array except for the zeros
		for (int i = 0; i < arrayWithoutDuplicates.length; i++) {
			arrayWithoutDuplicates[i] = temporaryArray[i];
		}
		
		//returns the new array, which has no duplicates or zeros
		return arrayWithoutDuplicates;
	}
	
	//sorts arrays from smallest to largest values
	public static int[] sort(int[] arrayWithoutDuplicates) {
		
		//for loop that
		for (int i = 0; i < arrayWithoutDuplicates.length; i++) {
			
			int currentMinimum = arrayWithoutDuplicates[i]; //variable that allows values to be swapped when a smaller number is found
			int minimumIndex = i; //index variable to check whether numbers should be swapped or not
			
			//for loop that obtains smallest number after index i 
			for (int j = i + 1; j < arrayWithoutDuplicates.length; j++) {
				
				//if statement runs when a smaller number than the current array value is found
				if (currentMinimum > arrayWithoutDuplicates[j]) {
					currentMinimum = arrayWithoutDuplicates[j]; //holds number to be swapped
					minimumIndex = j; //index used to activate if statement below
				}
			}
			
			//if statement runs when a smaller number has been found than the value in the current index
			if (minimumIndex != i) {
				arrayWithoutDuplicates[minimumIndex] = arrayWithoutDuplicates[i]; //larger number placed in index of smaller number
				arrayWithoutDuplicates[i] = currentMinimum; //copies the smaller number that was found
			}
		}
		
		//returns sorted array
		return arrayWithoutDuplicates;
	}
	
	
	//find the elements that are common between the two arrays
	public static int[] findCommonElements(int[] array1, int[] array2) {
		//*****NOTE: THIS METHOD ASSUMES THAT ARRAYS HAVE BEEN SORTED USING THE ABOVE METHOD*****
		
		int largerLength = 0; //length variable created to determine length of a temporary array for this method
		//the length will be equal to the array that has the larger length
		
		//if statement runs when the first array's length is bigger
		if (array1.length > array2.length) {
			largerLength = array1.length;
		}
		//else statement runs when the second array's length is bigger
		else {
			largerLength = array2.length;
		}
		
		//temporary array created and is set to the larger length between the two arrays
		int[] temporaryArray = new int[largerLength];
		
		int temporaryVariable = 0; //temporary variable created to increase index of temporary array
		
		//for loop that runs through every value of the first array
		for (int i = 0; i < array1.length; i++) {
			
			//for loop that runs through every value of the second array
			for (int j = 0; j < array2.length; j++) {
				
				//if statement runs when an identical value is found
				if (array1[i] == array2[j]) {
					temporaryArray[temporaryVariable] = array2[j]; //identical value copied to temporary array
					temporaryVariable++; //temporary array's index increased to copy additional values
					j = array2.length; //causes inner for loop to end
				}
			}
		}
		
		int arrayLength = 0; //variable that determines the length of the returned array
		
		//for loop that increases arrayLength variable until a zero is found
		for (int i = 0; i < temporaryArray.length; i++) {
			
			//if statement runs when a zero is found in the temporary array
			if (temporaryArray[i] == 0) {
				i = temporaryArray.length; //causes for loop to end
			}
			else {
				arrayLength++; //length increased if zero is not found
			}
		}
		
		int[] commonArray = new int[arrayLength]; //new array that will be returned when method is invoked
		
		//for loop that copies temporary array values to new array except for the zeros
		for (int i = 0; i < commonArray.length; i++) {
			commonArray[i] = temporaryArray[i];
		}
		
		//returns a new array with common elements found between the two original arrays
		return commonArray;
	}
}
