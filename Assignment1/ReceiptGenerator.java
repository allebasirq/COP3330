// Author: Isabella Rodrigues Quesada
// Assignment 1
// Note: This program prints out a receipt from fictitious store with a randomly generated receipt number and date.
// It collects input from user (items and prices) and outputs the total of items and total price.

package assignment1;

import java.util.Scanner;
import java.util.Random;

public class ReceiptGenerator {
	
	static final int MAX_ASTERISK = 30;
	static final int ASTERISK_INNER_LOGO = 6;
	static final int ASTERISK_OUTER_LOGO = 15;
	static final String STORE = "S store";
	
	static final Scanner scan = new Scanner(System.in);
	static final Random random = new Random();
	
	public static void main(String[] args) {
		
		printTopLogo();
		generateReceipt();
		
		String finalDate = generateDate();
		System.out.println(finalDate);
		
		getUserInput();
		printLogoBottom();
		
		scan.close();
		
		
	}

	// Method to randomly generate receipt number
	public static void generateReceipt() {
		
		int receiptNum = random.nextInt(1000, 2000);									// From [1000, 2000)
		System.out.println("\nreceipt number      " + receiptNum);						// Append 6 spaces
		
	}
	
	// Method to randomly generate date (date, month and year)
	public static String generateDate() {
	
		String dateToString = "";
		int date = random.nextInt(1, 28+1);												// 28+1 to make 28 inclusive, thus [1, 29)
		
		if ((date >= 1) && (date <= 9)) {
			dateToString = "0" + date;													// Appends zeros if date generated is >= 1 and <= 9
		} else {
			dateToString = "" + date;
		}
	
		
		int year = random.nextInt(1900, 2099+1);
		String yearToString = year + "";
		
		int month = random.nextInt(1, 12+1);											// Randomly generate month. 12+1 to make December inclusive
		
		switch(month) {
			case 1:
				return "January" + " " + dateToString + " " + yearToString;
			case 2:
				return "February" + " " + dateToString + " " + yearToString;
			case 3:
				return "March" + " " + dateToString + " " + yearToString;
			case 4:
				return "April" + " " + dateToString + " " + yearToString;
			case 5:
				return "May" + " " + dateToString + " " + yearToString;
			case 6:
				return "June" + " " + dateToString + " " + yearToString;
			case 7:
				return "July" + " " + dateToString + " " + yearToString;
			case 8:
				return "August" + " " + dateToString + " " + yearToString;
			case 9:
				return "September" + " " + dateToString + " " + yearToString;
			case 10:
				return "October" + " " + dateToString + " " + yearToString;
			case 11:
				return "November" + " " + dateToString + " " + yearToString;
			case 12:
				return "December" + " " + dateToString + " " + yearToString;
			default:																			// I think it is impossible to reach default in this case (due to random range)
				return "January" + " " + dateToString + " " + yearToString;						// but I think it might be good practice to always have the default
		}
		
		
	}

	// Method to get user input (items and prices). Also prints out final result
	public static void getUserInput() {
		
		int counter = 0;
		double price, total = 0;
		double taxRegular = 0.3;
		
		String item, lowerItem, finalItem, formattedItem = "";				// Initialize all strings
		char firstChar, finalChar;
		
		
		do {
			System.out.print("Write item name ");
			item = scan.next();
			
			if(item.equals("DONE") ) {										// Exit if user enters "DONE"
				price = 0;
				break;
			}
			
			System.out.print("Write price ");
			price = scan.nextDouble();
			
			counter++;														// Counter to check how many items were added
			
			if(!(item.equals("Food")) && (!(item.equals("food")))) {
				price += price*taxRegular;
			}
			
			lowerItem = item.toLowerCase();									// Lower case the user input
			finalItem = lowerItem.substring(1);								// Remove the first char
			
			firstChar = item.charAt(0);										// Gets first char
			finalChar = Character.toUpperCase(firstChar);					// Make first char upper case
			
			formattedItem = finalChar + finalItem;							// Final formatted item
			
			System.out.println("item number " + counter + " " + formattedItem + " " + String.format("%.2f", price));
			
			total += price;
			
			
		} while (true); 
		
		System.out.println(counter + " items      "+ "total " + String.format("%,.2f", total));
	
	}

	// Method to generate the receipt's top logo
	public static void printTopLogo() {
		
		for(int i=0; i<MAX_ASTERISK; i++) {
			System.out.print("*");
		}
		
		System.out.println("");															// Jump to next line
		
		for(int i=0; i<ASTERISK_INNER_LOGO; i++) {
			System.out.print("*");
		}
		
		System.out.print(" " + STORE + " ");
		
		for(int i=0; i<ASTERISK_OUTER_LOGO; i++) {
			System.out.print("*");
		}
		
		System.out.println("");
		
		for(int i=0; i<MAX_ASTERISK; i++) { 
			System.out.print("*");
		}
		
		System.out.print("");															// Extra line to separate asterisk from date
	}
	
	// Method to generate the receipt's bottom logo
	
	public static void printLogoBottom() {
		
		for(int i=0; i<3; i++) { 														// Hardcoded 3 for the 3 bottom lines
		
			for(int j=0; j<MAX_ASTERISK; j++) {
				System.out.print("*");
			}
		
			System.out.println("");														// Extra space for consecutive lines
		
		}
		
	}

}
