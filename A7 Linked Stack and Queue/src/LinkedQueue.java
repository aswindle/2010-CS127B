/*Alex Swindle
 * C SC 127B
 * Section Leader: Andrew Emmott
 * Creates a prioritized queue using a singly linked structure; allows
 * adding elements, removing top element, and peeking at the top element
 */

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements OurQueue<E> {

	// Private class used to build linked structure
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
	private Node first;
	private Node back;
	private int size = 0;

	// Constructor
	public LinkedQueue() {
		first = null;
		back = first;
		size = 0;
	}

	// Adds new element to the back of the line; updates back node appropriately
	public void add(E newEl) {
		if (size == 0) {
			first = new Node(newEl, null);
			back = first;
		} else {
			back.next = new Node(newEl, null);
			back = back.next;
		}
		size++;
	}

	// Returns true is size is 0
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	// Returns reference to first element without removing it
	public E peek() throws NoSuchElementException {
		if (size == 0)
			throw new NoSuchElementException();
		else
			return first.data;
	}

	/*
	 * Removes top element, deals with 3 possible cases: 1)It's empty, and
	 * throws exception 2)It's got enough size that first can just move on
	 * without hitting the end 3)Size is 1 or 2, in which case first becomes
	 * back
	 */
	public E remove() throws NoSuchElementException {
		if (size == 0)
			throw new NoSuchElementException();
		else if (size > 2) {
			E temp = first.data;
			first = first.next;
			size--;
			return temp;
		} else {
			E temp = first.data;
			first = back;
			size--;
			return temp;
		}
	}

}
