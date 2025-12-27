// Author: Isabella Rodrigues Quesada
// PID: 5770193 && NID: is749945
// Assignment 3
// Note: This program will create and populate an Array List with different cars - including brand name, price and battery type (for the electric cars) - and output
// an overall summary of each object and the total price of all cars. The main goal is of this assignment is to practice inheritance, polymorphism and handling data files.

package assignment3;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class CarDataProcessClass {
	
	public static void main(String[] args) {
		
		ArrayList<Car> myArr = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		String userInput = scan.next();				// Scanning .txt from user
		
		myArr = readIntoArrayList(userInput);
		printCars(myArr);
		
		int theTotal = getTotal(myArr);
		
		System.out.println("The total price is " + theTotal);
		
		scan.close();
		
	}
	
	// Method to open file, read each line and create each car object. Finally, it will populate an Array List will all cars.
	public static ArrayList<Car> readIntoArrayList(String fname) {
	
		ArrayList<Car> arr = new ArrayList<>();
		
		BufferedReader br = null;
		
		try { 
			br = new BufferedReader(new FileReader(fname));
			String newline = null;
			
			while((newline = br.readLine() )!= null) {
				
				// The rest of information about the car will be guaranteed to start at index 2
				String carInfo = newline.substring(2, newline.length());
				
				// Getting the car type from string read from file
				String carType = newline.substring(0,1);
				
				// If the car is an electric car, create an electric car object
				if(carType.equals("e")) {
					ElectricCar myCar = new ElectricCar(carInfo);
					arr.add(myCar);
				
				// If the car is just a car, create a car object
				} else if(carType.equals("g")) {
					Car myCar = new Car(carInfo);
					arr.add(myCar);
				}
				
			}
			
			br.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return arr;
		
	}
	
	// Method to calculate the total price in the ArrayList.
	public static int getTotal(ArrayList<Car> arr) {
		
		int sum=0;
		
		for(int i=0;i< arr.size(); i++) {
			sum = sum + arr.get(i).getPrice();
		}
		
		return sum;
	}
	
	// Method to print out the Array List in formatted order.
	public static void printCars(ArrayList<Car> arr) {
		
		// All electric cars are cars
		for(int i=0; i<arr.size(); i++) {
		    System.out.println(arr.get(i).toString());
		}
	}
}
