/*
 * Name: Ibrahim Khan
 * Class: CS1150-06
 * Due: Sept. 5, 2019
 * Description: Assignment #1
 * This assignment shows that I know how to print statements about myself in a few paragraphs.  This program also has a second
 * part which deals with expressions and conversions.
 */
public class KhanIbrahimAssignment1 {

	public static void main (String []args) {
		//Introduction
		System.out.println("Welcome! This program has two parts. First, you will read about the author of this program.");
		System.out.println("Second, you will access a conversion table showing conversions from kilometers to miles, feet, and "
				+ "inches.");
		System.out.println("");
		System.out.println("");
		
		
		//Part 1: About Me
		System.out.println("Part One: About Me");
		System.out.println("");
		
		//1st paragraph
		System.out.println("  My name is Ibrahim Khan.");
		System.out.println("I am a Colorado native.");
		System.out.println("I graduated from Rampart High School.");
		System.out.println("I am currently a sophomore at UCCS.");
		System.out.println("My intended major is B.I. Computer Security.");
		System.out.println("I am a part-time employee at Panera Bread.");
		System.out.println("I am looking forward to learning Java in this class.");
		System.out.println("");
		
		//2nd paragraph
		System.out.println("  I love the outdoors.");
		System.out.println("I enjoy hiking and fishing.");
		System.out.println("I also like to read in my spare time.");
		System.out.println("My favorite movie genre is comedy.");
		System.out.println("I have travelled to India several times.");
		System.out.println("My parents are from India.");
		System.out.println("All of my cousins reside in India.");
		System.out.println("");
		System.out.println("");
		
		
		//Part 2: Conversion Table
		System.out.println("Part Two: Kilometers Conversion Table");
		System.out.println("");
		
		//Declare all kilometer values
		int km1 = 1;
		int km5 = 5;
		int km10 = 10;
		int km100 = 100;
		
		//All kilometer to meter conversions
		double mi1 = km1 * 0.62;
		double mi5 = km5 * 0.62;
		double mi10 = km10 * 0.62;
		double mi100 = km100 * 0.62;
		
		//All kilometer to feet conversions
		double ft1 = km1 * 3280.84;
		double ft5 = km5 * 3280.84;
		double ft10 = km10 * 3280.84;
		double ft100 = km100 * 3280.84;
		
		//All kilometer to inch conversions
		double in1 = km1 * 39370.1;
		double in5 = km5 * 39370.1;
		double in10 = km10 * 39370.1;
		double in100 = km100 * 39370.1;
		
		//Table
		System.out.println("Kilometers   Miles    Feet       Inches");
		System.out.println("----------------------------------------");
		System.out.println(km1+"            "+mi1+"     "+ft1+"    "+in1);
		System.out.println(km5+"            "+mi5+"      "+ft5+"    "+in5);
		System.out.println(km10+"           "+mi10+"      "+ft10+"    "+in10);
		System.out.println(km100+"          "+mi100+"     "+ft100+"   "+in100);
		System.out.println("");
		System.out.println("");
		
		
		//Conclusion
		System.out.println("Thank you for your time in viewing this program.");
	}
}
