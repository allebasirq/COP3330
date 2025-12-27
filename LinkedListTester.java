// Author: Isabella Rodrigues Quesada
// PID: 5770193 && NID: is749945
// Assignment 4
// Note: This program will create and populate a linked list with numbers given from a file. I will only create each individual node that fit in the requirement
//		 of values greater then zero. Eventually, it will process the final list based on the condition X[i] = X[i-1] x 2 + 7, where i indicates our current node.
// 		 If the value found matches the data of X[i], the two nodes, X[i] and X[i-1] will be removed from the list and replaced by a new node with a "counter" data,
// 		 starting at -100, which will increment accordingly with each new created node. Finally, the resulting list will be written in a new file file called "processeddata.txt".

package assignment4;

import java.util.Scanner;

public class LinkedListTester {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String fileName = scanner.nextLine();
		
		// Creating the list and calling construct
		LinkedList list = new LinkedList();
		list.construct(fileName);
		
		String result = "processeddata.txt";
		
		list.printToFile(result);
		
		scanner.close();
	}
	
	
}
