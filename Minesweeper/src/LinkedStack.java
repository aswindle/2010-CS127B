/*Alex Swindle
 * C SC 127B
 * Section Leader: Andrew Emmott
 * Creates a stack using a singly linked structure; allows
 * adding elements, removing top element, and peeking at the top element
 */

import java.util.EmptyStackException;

public class LinkedStack<E> implements OurStack<E> {

	// Private class used to create linked structure
	private class Node {

		// Instance vars
		private E data;
		private Node next;

		// Constructor for Node
		public Node(E element, Node link) {
			data = element;
			next = link;
		}
	}

	// Instance vars
	private Node top;
	private int size;

	// Constructor
	public LinkedStack() {
		top = null;
		size = 0;
	}

	// Returns true if size is 0
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	// Returns reference to top element without removing it
	public E peek() throws EmptyStackException {
		if (size == 0)
			throw new EmptyStackException();
		else
			return top.data;
	}

	// Returns top element and updates first to the next node and decreases size
	public E pop() throws EmptyStackException {
		if (size == 0)
			throw new EmptyStackException();
		else {
			E temp = top.data;
			top = top.next;
			size--;
			return temp;
		}
	}

	// Adds new element to the top of the stack
	public void push(E element) {
		top = new Node(element, top);
		size++;
	}

}
