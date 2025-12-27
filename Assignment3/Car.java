// Author: Isabella Rodrigues Quesada
// Assignment 3
// Note: This program will create and populate an Array List with different cars - including brand name, price and battery type (for the electric cars) - and output
// an overall summary of each object and the total price of all cars. The main goal is of this assignment is to practice inheritance, polymorphism and handling data files.

package assignment3;

import java.util.StringTokenizer;

public class Car {
	
	private String brandName;
	private int price;
	
	// Constructor with brand and price parameters
	public Car(String brandName, int price) {
		this.brandName = brandName;
		this.price = price;
	}
	
	// Constructor that will read the line from file in order to create a new car
	public Car(String line) {
		
		StringTokenizer st = new StringTokenizer(line);
		
		String brand = st.nextToken();
		String stringPrice = st.nextToken();
		int intPrice = Integer.parseInt(stringPrice);
		
		brandName = brand;
		price = intPrice;
		
	}
	
	// Constructor without parameters
	public Car() {
		brandName = "Invalid";
		price = -1;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName; // void?
	}
	
	public String toString() {
		
		String result = "GCar brandname: " + brandName + " price: " + price;
		return result;
		
	}
	
}
