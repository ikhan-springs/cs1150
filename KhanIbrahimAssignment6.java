/*
 * Name: Ibrahim Khan
 * Class: CS1150-06
 * Due: Oct. 10, 2019
 * Description: Assignment #6
 * This assignment shows understanding of nested loops with a while loop and a for loop nested within a while loop. This program 
 * creates a simple slot machine that continues until user quits or until all money is gone.
 */

import java.util.Scanner; //required to gather user input

public class KhanIbrahimAssignment6 {

	public static void main(String[] args) {

		//Starting menu
		System.out.println("Starting slot machine simulation...");
		System.out.print("Enter dollar amount to start slot machine simulation: ");

		//Scanner to gather initial amount
		Scanner keyboard1 = new Scanner (System.in);
		String startCredits = keyboard1.nextLine();

		//Converts user input from string to int
		int startAmount = Integer.parseInt(startCredits);

		//Starting slot screen with all sevens
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("\tSEVENS\t\tSEVENS\t\tSEVENS");
		System.out.println("-----------------------------------------------------------");
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("| Credits\t"+startAmount+"\t| Won\t0\t| Lost\t0\t|");
		System.out.println("-----------------------------------------------------------");
		
		//Initialize variables for number of credits won and lost
		int winCredits = 0, lostCredits = 0;
		
		//Initialize bet to 1 so that while loop starts
		int bet = 1;
		
		//Outer while loop to check that credits are available and user wants to play
		while (startAmount > 0 && bet > 0) {
			
			//Asks for betting amount
			System.out.print("\nYou have "+startAmount+" credits. How many do you want to bet? ");

			//Scanner to get user's betting amount
			Scanner keyboard2 = new Scanner (System.in);
			String betCredits = keyboard2.nextLine();
			
			//Converts user input from string to int
			bet = Integer.parseInt(betCredits);
			
			//Inner while loop to check bet is less than amount inserted
			while (bet > startAmount) {
				
				//Asks user for new bet
				System.out.print("\n"+betCredits+" is invalid. How many do you want to bet? ");
				
				//Scanner to get user's new betting amount
				Scanner keyboard3 = new Scanner (System.in);
				betCredits = keyboard3.nextLine();
				
				//Converts user input from string to int
				bet = Integer.parseInt(betCredits);
			}
			
			//Inner for loop to spin the slot machine
			for (int spin = 0; spin <= bet; bet--) {
				
				//Initialize strings for SlotMachine method
				String reel1 = "", reel2 = "", reel3 = "";

				//Strings that invoke SlotMachine method
				String word1 = SlotMachine(reel1);
				String word2 = SlotMachine(reel2);
				String word3 = SlotMachine(reel3);
				
				//if statement when all three reels match
				if (word1 == word2 && word1 == word3) {
					winCredits += 3; //3 credits added to amount of credits won
					startAmount += 3; //3 credits added to initial amount
					
					System.out.println("\nSpinning...");

					//Displays the slot machine after spin is complete
					System.out.println("-----------------------------------------------------------");
					System.out.println("\t"+word1+"\t\t"+word2+"\t\t"+word3);
					System.out.println("-----------------------------------------------------------");

					//Number of credits won displayed
					System.out.println("|\t\t***** "+winCredits+" CREDITS WON! *****\t\t|");

					//Totals of available credits, credits won, and credits lost
					System.out.println("-----------------------------------------------------------");
					System.out.println("| Credits\t"+startAmount+"\t| Won\t"+winCredits+"\t| Lost\t"+lostCredits+"\t|");
					System.out.println("-----------------------------------------------------------");
				}

				//else if statement when two reels match
				else if (word1 == word2 || word1 == word3 || word2 == word3) {
					winCredits += 2; //2 credits added to amount of credits won
					startAmount += 2; //2 credits added to initial amount
					
					System.out.println("\nSpinning...");

					//Displays the slot machine after spin is complete
					System.out.println("-----------------------------------------------------------");
					System.out.println("\t"+word1+"\t\t"+word2+"\t\t"+word3);
					System.out.println("-----------------------------------------------------------");

					//Number of credits won displayed
					System.out.println("|\t\t***** "+winCredits+" CREDITS WON! *****\t\t|");

					//Totals of available credits, credits won, and credits lost
					System.out.println("-----------------------------------------------------------");
					System.out.println("| Credits\t"+startAmount+"\t| Won\t"+winCredits+"\t| Lost\t"+lostCredits+"\t|");
					System.out.println("-----------------------------------------------------------");
				}

				//else statement when no reels match
				else {
					lostCredits ++; //1 credit added to amount of credits lost
					startAmount--; //1 credit subtracted from initial amount
					
					System.out.println("\nSpinning...");

					//Displays the slot machine after spin is complete
					System.out.println("-----------------------------------------------------------");
					System.out.println("\t"+word1+"\t\t"+word2+"\t\t"+word3);
					System.out.println("-----------------------------------------------------------");

					//Totals of available credits, credits won, and credits lost
					System.out.println("\n-----------------------------------------------------------");
					System.out.println("| Credits\t"+startAmount+"\t| Won\t"+winCredits+"\t| Lost\t"+lostCredits+"\t|");
					System.out.println("-----------------------------------------------------------");
				}
				
				//if statement when spins are done and user can still play
				if (startAmount > 0 && bet == 1) {
					
					//Asks user to play again
					System.out.print("\nYou have "+startAmount+" credits. Spin again? Y/N ");
					
					//Scanner to get user's response
					Scanner keyboard4 = new Scanner (System.in);
					String spinAgain = keyboard4.nextLine();
					
					//while loop if user pressed something other than y or n, disregarding case
					while (!(spinAgain.equalsIgnoreCase("y") || spinAgain.equalsIgnoreCase("n"))) {
						
						//Asks user to play again
						System.out.print("\n"+spinAgain+" is invalid. Spin again? Y/N ");
						
						//Scanner to get user's new response
						Scanner keyboard5 = new Scanner (System.in);
						spinAgain = keyboard5.nextLine();
					}
					
					//if statement when user wants to play again
					if (spinAgain.equalsIgnoreCase("y")) {
						spin = 2;
						bet = 1;
						break;
					}
					
					//else statement when user wants to stop
					else if (spinAgain.equalsIgnoreCase("n")) {
						spin = 100; //spin is set to 100 so that for loop ends
					}
				}
			}
		}
		
		//Convert start amount (user input) from string to an int
		int startCredits2 = Integer.parseInt(startCredits);

		//Equation to see how much will be dispensed
		final int dispenseAmount = (startCredits2 + winCredits) - lostCredits;

		//End results
		System.out.println("\nGame over!");
		System.out.println("Started with\t$"+startCredits);
		System.out.println("Winnings\t$"+winCredits);
		System.out.println("Lost\t\t$"+lostCredits);
		System.out.println("Dispensing\t$"+dispenseAmount);
	}
	
	//SlotMachine method returns a random string for a slot machine reel
	public static String SlotMachine (String reel) {
		
		//random int to get an integer [1,6]
		int random = 1 + (int) (Math.random() * 6);
		
		//Initialize string for reel
		String word = "";
		
		//switch statement to match random number with a specific word
		switch (random) {
		case 1: word = "CHERRIES"; break;
		case 2: word = "SEVENS"; break;
		case 3: word = "PLUMS"; break;
		case 4: word = "BELLS"; break;
		case 5: word = "MELONS"; break;
		case 6: word = "BARS"; break;
		}
		
		//returns the random word
		return word;
	}
}
