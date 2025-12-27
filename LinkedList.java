// Author: Isabella Rodrigues Quesada
// PID: 5770193 && NID: is749945
// Assignment 4
// Note: This program will create and populate a linked list with numbers given from a file. I will only create each individual node that fit in the requirement
//		 of values greater then zero. Eventually, it will process the final list based on the condition X[i] = X[i-1] x 2 + 7, where i indicates our current node.
// 		 If the value found matches the data of X[i], the two nodes, X[i] and X[i-1] will be removed from the list and replaced by a new node with a "counter" data,
// 		 starting at -100, which will increment accordingly with each new created node. Finally, the resulting list will be written in a new file file called "processeddata.txt".

package assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class LinkedList {
	
	private Node head;
	
	public LinkedList() {
		head = null;
	}
	
	// Method to add nodes to the head (will not use this for this code but decided to add it to implement other methods)
	public void addToHead(int el) {
		
		Node newNode = new Node(el);
		newNode.setNext(head);
		head = newNode;
		
	}
	
	// Method to add nodes to the tail
	public void addToTail(int el) {
		
		// If the list is empty, then add to the head
		if(isEmpty()) {
			addToHead(el);
			return;
		}
		
		// curNode is a walker so we don't loose the head reference
		Node curNode = head;
		
		// Go to the node at the tail
		while(curNode.getNext() != null) {
			curNode = curNode.getNext();
		}
		
		Node newNode = new Node(el);
		curNode.setNext(newNode);
		
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	// Method to construct the linked list by reading the file.
	public void construct(String fname) {
		
		BufferedReader br = null;
		String info = null;
		
		try {
			
			br = new BufferedReader(new FileReader(fname));
			String newLine = null;
			
			while((newLine = br.readLine()) != null) {
				
				// Read into a variable for easy access
				info = newLine;
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		StringTokenizer st = new StringTokenizer(info);
		
		while(st.hasMoreTokens()) {
			
			String p = st.nextToken();

			int num = Integer.parseInt(p);
			
			// If the number is less than or equal to zero, go to the next one
			if(num <= 0) {
				continue;
			}
			
			// Then insert to the list IFF is not less than or equal to zero
			addToTail(num);
			
		}
		
		process();
		
	}
	
	// Method to process the linked list based on the requirements of the assignment
	public void process() {
		
		if(isEmpty()) {
			return;
		}
		
		int count = -100;
		
		Node curNode = head;
		int valCur, valNext, valNextNext, calc;
		
		// Edge case: Checking the first two nodes
		if(curNode == head) {
			
			valCur = curNode.getData();
			
			if(curNode.getNext() != null) {
				valNext = curNode.getNext().getData();
				
				calc = (valCur*2) + 7;
				
				if(calc == valNext) {
					
					Node newNode = new Node(count);
					
					// Set next pointer to the third node
					newNode.setNext(curNode.getNext().getNext());
					
					// Head now is the new node
					head = newNode;
					
					// Move to the head next node 
					curNode = head.getNext();
					count++;
				}
			}			
		} 
		
		// Added this for the case when the list has only two nodes and those two nodes fall under the process of deletion and replacement for "count" node
		if(curNode != null) {
		
			while(curNode.getNext() != null) {
				
				// I don't want to stop at the node that I might have to delete. Thus, I must stop at one before so I can reassign the next references
				if(curNode.getNext().getNext() != null) {
						
					valNext = curNode.getNext().getData();
					valNextNext = curNode.getNext().getNext().getData();
						
					calc = (valNext*2) + 7;
						
					if(calc == valNextNext) {
							
						Node newNode = new Node(count);
							
						// Point to the third node
						newNode.setNext(curNode.getNext().getNext().getNext());
							
						// Reassign next from cur
						curNode.setNext(newNode);
						count++;
							
					}
					
						
				}
					
				curNode = curNode.getNext();
				
			} // I know for sure that at the end of this while loop "curNode" will be at the tail
			
			// If the tail has a node that is positive, append the last processed data
			if(curNode.getData() > 0) {
				
				// Finally, set up the last node
				Node lastNode = new Node(count);
				curNode.setNext(lastNode);
			}
			
			
		}
		
		
	}
		
	// Method to print the resulting list into a file
	public void printToFile(String fileName) {
		
		BufferedWriter bw;
		
		try {
			
			bw = new BufferedWriter(new FileWriter(fileName));
			bw.write(toString());
			bw.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("");
		Node cur = head;
		
		while(cur != null) {
			sb.append(cur.toString());
			cur = cur.getNext();
		}
		
		return sb.toString();
	
	}
	
}
