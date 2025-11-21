// Author: Isabella Rodrigues Quesada
// PID: 5770193 && NID: is749945
// Assignment 2
// Note: This program uses a Die class to create a Dice object. It uses randomness to roll the die and gets the sum of the faces for the dice.
// Finally, it outputs the frequency of sum of the dice in formatted manner and illustrates a histogram based on the data.

package assignment2;

public class Dice {

	private Die firstDie, secondDie;
	
	// No argument constructor
	public Dice() {
		
		firstDie = new Die();								// Initialize firstDie and secondDie
		secondDie = new Die();
		
		firstDie.setFaceValue(1);
		secondDie.setFaceValue(1);
		
	}
	
	public int sumFaceValues() {
		
		return firstDie.getFaceValue() + secondDie.getFaceValue();						// Returns the sum of faceValues
	}
	
	// Method to run both dice
	public void rollDice() {
		
		firstDie.roll();
		secondDie.roll();
	}
}
