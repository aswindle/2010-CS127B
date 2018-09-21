/*Alex Swindle
 * C SC 127B
 * Section Leader: Andrew Emmott
 * Creates a prioritized linked list whose elements can be inserted, removed,
 * and have their priority level changed 
 */

public class LinkedPriorityList<E> implements PriorityList<E> {

	// Private class used to create each link in the list
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

	// Instance vars for public class
	private Node first;
	private int size;

	// Create an empty list with zero elements
	public LinkedPriorityList() {
		first = null;
		size = 0;
	}

	// Returns the Node at a given index; saves a lot of typing for later
	// methods
	private Node getNodeAt(int index) {
		Node temp = first;
		if (index > 0) {
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
		} else {
			temp = first;
		}
		return temp;
	}

	// Returns element at a given node if index is in range, otherwise throws
	// exception
	@Override
	public E getElementAt(int index) throws IllegalArgumentException {
		if (index >= 0 && index < size) {
			return getNodeAt(index).data;
		} else {
			throw new IllegalArgumentException();
		}
	}

	// Inserts element at given index if in range; otherwise exception
	@Override
	public void insertElementAt(int index, E el)
			throws IllegalArgumentException {
		if (index > 0 && index <= size) {
			Node temp = getNodeAt(index - 1);
			Node temp2 = temp.next;
			temp.next = new Node(el, temp2);
			size++;
		} else if (index == 0) {
			Node tempFirst = first;
			first = new Node(el, tempFirst);
			size++;
		} else
			throw new IllegalArgumentException();
	}

	// Returns true if the list is empty
	@Override
	public boolean isEmpty() {
		if (size == 0 && first == null) {
			return true;
		} else
			return false;
	}

	// Swaps the given element with the one below it (if index is in range)
	@Override
	public void lowerPriorityOf(int index) throws IllegalArgumentException {
		if (index >= 0 && index < size) {
			if (index != size - 1) {
				Node prev = getNodeAt(index);
				E loweredEl = prev.data;
				Node next = prev.next;
				E nextEl = next.data;
				prev.data = nextEl;
				next.data = loweredEl;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	// Takes given element (if in range) and places it at the end of the list
	@Override
	public void moveToLast(int index) throws IllegalArgumentException {
		if (index >= 0 && index < size) {
			if (index != size - 1) {
				E moved = getNodeAt(index).data;
				this.removeElementAt(index);
				this.insertElementAt(size, moved);
			}
		} else
			throw new IllegalArgumentException();
	}

	/*
	 * Takes given element(if in range) and places it at the top of the list
	 * Language becomes a bit messy, but basically handles two cases: index
	 * isn't at the end, or it is
	 */
	@Override
	public void moveToTop(int index) throws IllegalArgumentException {
		if (index >= 0 && index < size) {
			if (index > 0 && index < size - 1) {
				Node preMoved = getNodeAt(index - 1);
				Node moved = preMoved.next;
				Node postMoved = moved.next;
				Node tempFirst = first;
				first = moved;
				first.next = tempFirst;
				preMoved.next = postMoved;
			} else if (index > 0 && index == size - 1) {
				Node secondLast = getNodeAt(size - 2);
				Node last = getNodeAt(size - 1);
				Node tempFirst = first;
				first = last;
				last.next = tempFirst;
				secondLast.next = null;
			}
		} else
			throw new IllegalArgumentException();

	}

	// Swaps element (if index is in range) with the one above it
	@Override
	public void raisePriorityOf(int index) throws IllegalArgumentException {
		if (index >= 0 && index < size) {
			if (index > 0) {
				Node previous = getNodeAt(index - 1);
				E preEl = previous.data;
				Node next = previous.next;
				E nextEl = next.data;
				previous.data = nextEl;
				next.data = preEl;
			}
		} else
			throw new IllegalArgumentException();
	}

	// Removes a given node (if in range) and shifts everything up one
	@Override
	public void removeElementAt(int index) throws IllegalArgumentException {
		if (index > 0 && index < size - 1) {
			Node test = getNodeAt(index - 1);
			test.next = test.next.next;
			size--;
		} else if (index == 0) {
			first = first.next;
			size--;
		} else if (index == size - 1) {
			Node prev = getNodeAt(index - 1);
			prev.next = null;
			size--;
		} else
			throw new IllegalArgumentException();

	}

	// Returns size of list
	@Override
	public int size() {
		return size;
	}

	// Creates an Object array of size [size] filled with each node's .data
	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		for (int i = 0; i < size; i++) {
			array[i] = getElementAt(i);
		}
		return array;
	}

}
