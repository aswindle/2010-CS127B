
public class LinkedSet<E> {
	
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
	
	private Node first;
	private int size;
	
	public LinkedSet() {
		first = null;
		size = 0;
	}
	
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
	

	
	
	// Return the number of elements in this set.
	public int size(){
		return size;
	}
	
	// Return true if this set is empty.
	public boolean isEmpty(){
		if(size==0) return true;
		else return false;
		
	}
	
	// Add an element to this set if it does not already exist.
	// If this set has an element that equals element, return false.
	public boolean add(E element){
		if(!this.contains(element)){
			this.getNodeAt(size).next = new Node(element, null);
			size++;
			return true;
		}
		else return false;
	}
	
	// Return true if element is in this set
	public boolean contains(E element){
		for(int i = 0; i <size; i++){
			if(this.getNodeAt(i).data.equals(element)){
				return true;
			}
		}
		return false;
	}
	
	// Remove the only occurrence of element that equals element
	// and return true. If element is not in this set, return false.
	public boolean remove(E element){
		Node temp = first;
		if(this.contains(element)){
			while(!temp.next.data.equals(element)){
				temp = temp.next;
			}
			if(temp.next.next!=null){
				temp.next = temp.next.next;
			}
			else temp.next = null;
			return true;
		}
		else return false;
	}
}
