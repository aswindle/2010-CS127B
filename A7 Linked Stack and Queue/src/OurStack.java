import java.util.EmptyStackException;

public interface OurStack<E> {
  /**
   * Check if the stack is empty to help avoid popping an empty stack.
   * 
   * @returns true if there are zero elements in this stack.
   */
  public boolean isEmpty();

  /**
   * Put element on "top" of this Stack object.
   * 
   * @param The
   *          new element to be placed at the top of this stack.
   */
  public void push(E element);

  /**
   * Return reference to the element at the top of this stack.
   * 
   * @returns A reference to the top element.
   * @throws EmptyStackException
   *           if the stack is empty.
   */
  public E peek() throws EmptyStackException;

  /**
   * Remove element at top of stack and return a reference to it.
   * 
   * @returns A reference to the most recently pushed element.
   * @throws EmptyStackException
   *           if the stack is empty.
   */
  public E pop() throws EmptyStackException;
}