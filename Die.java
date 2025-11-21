// Author: Isabella Rodrigues Quesada
// PID: 5770193 && NID: is749945
// Assignment 2
// Note: This program uses a Die class to create a Dice object. It uses randomness to roll the die and gets the sum of the faces for the dice.
// Finally, it outputs the frequency of sum of the dice in formatted manner and illustrates a histogram based on the data.

package assignment2;

import java.util.Random;

public class Die {

	private int faceValue;
	
	public Die() {									// No argument constructor that sets faceValue to 1
		faceValue = 1;		
	}
	
	public int getFaceValue() {						// Getter method to get faceValue
		return faceValue;
	}
	
	public void setFaceValue(int givenFaceValue) {				// Setter method to set faceValue with given parameter
		faceValue = givenFaceValue;
	}
	
	public void roll() {
		
		Random random = new Random();
		
		int upperbound = 6;
		
		int newFace = random.nextInt(1, upperbound+1);			// New face generates [1,7): meaning 1 to 6
		
		faceValue = newFace;
		
	}
	
}
