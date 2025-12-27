// Author: Isabella Rodrigues Quesada
// Assignment 4
// Note: This program will create and populate a linked list with numbers given from a file. I will only create each individual node that fit in the requirement
//		 of values greater then zero. Eventually, it will process the final list based on the condition X[i] = X[i-1] x 2 + 7, where i indicates our current node.
// 		 If the value found matches the data of X[i], the two nodes, X[i] and X[i-1] will be removed from the list and replaced by a new node with a variable "counter" data,
// 		 starting at -100, which will increment accordingly with each new created node. Finally, the resulting list will be written in a new file file called "processeddata.txt".

package assignment4;

public class Node {
	
	private int data;
	private Node next;
	
	// Constructor without parameters
	public Node() {
		data = 0;
		next = null;
	}
	
	// Constructor with parameter data
	public Node(int gData) {
		data = gData;
		next = null;
	}
	
	public int getData() {
		return data;
	}
	
	// Method to set next reference of the node
	public void setNext(Node gNext) {
		next = gNext;
	}

	// Method to return the next next node
	public Node getNext() {
		return next;
	}
	
	@Override 
	public String toString() {
		
		String result = data + " ";
		return result;
		
	}
}
