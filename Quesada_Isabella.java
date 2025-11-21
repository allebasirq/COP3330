// Author: Isabella Rodrigues Quesada
// PID: 5770193 && NID: is749945
// Assignment 2
// Note: This program uses a Die class to create a Dice object. It uses randomness to roll the die and gets the sum of the faces for the dice.
// Finally, it outputs the frequency of sum of the dice in formatted manner and illustrates a histogram based on the data.

package assignment2;

public class Quesada_Isabella {
	
	static final int MAX_ROLLS = 1000;						// Number of rolls given in the instructions
	static final int MAX_NUM = 12;							// Since the max of one faceValue of die is 6, two dies max will be 12

	public static void main(String[] args) {
		
		int[] rollArr = new int[MAX_NUM];
		Dice thisDice = new Dice();
		
		
		getRolls(thisDice, rollArr);
		
	}
	
	
	// This method will store the frequency of each random roll of dice in arr array
	public static void getRolls(Dice myDice, int[] arr) {
		
		for(int i=0; i<MAX_ROLLS; i++) {
			
			myDice.rollDice(); 											// Rolling the dice each round
			
			int temp = myDice.sumFaceValues();							// Temporary variable to get the sum of face values
			
			arr[temp-1] = arr[temp-1] + 1; 								// Update the frequency
			
		}
		
		// Printing the array to output results
		// Note that i starts at 1 since we will never get a sum of 1
		for(int i=1; i<MAX_NUM; i++) {
			
			System.out.println("Number of " + (i+1) + "s are " + arr[i]);
			
		}
		
		System.out.println("");
		
		getHistogram(myDice, arr);
		
	}
	
	
	public static void getHistogram(Dice thisDice, int[] myArr) {
		
		int yAxis = 175;
		int numRows = 8;			// '8' because we will have 8 rows (from 0 to 175, jumping by 25, gets 7 + the row 0 = 8)
		
		String[][] myGrid = new String[numRows][MAX_NUM];
		
		
		// Filling the y-axis in the first column
		while(yAxis != -25) {
			
			for(int i=0; i<numRows; i++) {
			
				if(yAxis >= 100) {							// Considering 3 digit numbers
					myGrid[i][0] = yAxis + "|";
				}
			
				if(yAxis >= 10 && yAxis < 100) {			// Considering 2 digit numbers
					myGrid[i][0] = " " + yAxis + "|";
				
				}
			
				if (yAxis >= 0 && yAxis < 10) {				// Considering 1 digit numbers
					myGrid[i][0] = "  " + yAxis + "|";
				}
				
				yAxis -= 25;								// Move down the y-axis 
			
			}
		}
		
		yAxis = 175;				// Reset to 725 to start populating the grid
		
		
		// Loop through myGrid (ignoring column 0 since it is already filled with the y-axis information)
		for(int i=0; i<numRows; i++) {
			for(int j=1; j< MAX_NUM; j++) {
				
				if(myArr[j] >= yAxis) {								// If the occurrences in myArr are greater or equal the yAxis, add a '*'
					myGrid[i][j] = " * ";
				} else {											// Otherwise, add white space
					myGrid[i][j] = "   ";
				}
				
			}
			
			yAxis -= 25;											// Move down the y-axis 
		}
		
		// Printing final grid
		System.out.println("Graph");
		
		for(int i=0; i<numRows; i++) {
			for(int j=0; j<MAX_NUM; j++) {
				
				System.out.print(myGrid[i][j]);
			}
			
			System.out.println("");							// New line to start the x-axis
			
		}	
		
			for(int i=0; i<myGrid[i][0].length(); i++) {		// Add white space with equivalent length of the string in column 0. In this case, it is always 4
				System.out.print(" ");
			}
			
			for(int i=0; i<33; i++) {						// Print '-'s. Note: Hard coded '33' to fit nicely with the '*' and numbers below
				System.out.print("-");
			}
			
			System.out.println("");							// Skip one line
			
			for(int i=0; i<myGrid[i][0].length(); i++) {		// Move numbers towards the right (same idea with previous ' ' added)
				System.out.print(" "); 
			}
			
				
			// Using this for loop to format the x-axis
			for(int i=1; i<MAX_NUM; i++) {
				
				if(i >= 10) {								// If the number has 2 digits, only add one white space
					System.out.print((i+1) + " ");
				} else {									// Otherwise add two
					System.out.print(" " + (i+1) + " ");
				}
				
			}
			
		
		
	}
	

}
