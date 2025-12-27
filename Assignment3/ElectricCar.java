// Author: Isabella Rodrigues Quesada
// Assignment 3
// Note: This program will create and populate an Array List with different cars - including brand name, price and battery type (for the electric cars) - and output
// an overall summary of each object and the total price of all cars. The main goal is of this assignment is to practice inheritance, polymorphism and handling data files.

package assignment3;

import java.util.StringTokenizer;

public class ElectricCar extends Car{

	private boolean isLithiumIon;
	
	// Constructor that takes brand and price
	public ElectricCar(String brandName, int price) {
		
		super();
		
		setBrandName(brandName);
		setPrice(price);
		
		isLithiumIon = false;
	}
	
	// Constructor that will read the line from file in order to create a new electric car
	public ElectricCar(String line) {
		 
		StringTokenizer st = new StringTokenizer(line);
				
		String brand = st.nextToken();
		setBrandName(brand);
		
		// Reading token into a string and changing it to int
		String stringPrice = st.nextToken();
		int price = Integer.parseInt(stringPrice);
		setPrice(price);
		
		String stringBattery = st.nextToken();
		
		if(stringBattery.equals("1")) {
			isLithiumIon = true;

		} else {
			isLithiumIon = false;
		}
		
	}
				
	public String batteryType() {
		
		// If isLithiumIon is true, then LithiumIon, else NickelMetal
		if(isLithiumIon) {
			return "LithiumIon";
		} else {
			return "NickelMetal";
		}
	}
	
	// Override parents getPrice method. Runtime Polymorphism
	@Override
	public int getPrice() {
		
		if(isLithiumIon) {
			int newPrice = (int)(super.getPrice()*1.2);
			return newPrice;
		} else {
			return super.getPrice();
		}
		
	}
	
	// Override parents toString method. Runtime Polymorphism
	@Override
	public String toString() {
		
		String result = "ECar brandname: " + getBrandName() + " price: " + getPrice() + " battery: " + batteryType();
		return result;
	
	}
}
