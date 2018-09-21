import java.util.NoSuchElementException;

public interface OurQueue<E> {
  /**
   * Find out if the queue is empty.
   * 
   * @returns true if there are zero elements in this queue.
   */
  public boolean isEmpty();

  /**
   * Add element to the "end" of this queue.
   * 
   * @param newEl
   *          element to be placed at the end of this queue.
   */
  public void add(E newEl);

  /**
   * Return a reference to the element at the front of this queue.
   * 
   * @returns A reference to the element at the front.
   * @throws NoSuchElementException
   *           if this queue is empty.
   */
  public E peek() throws NoSuchElementException;

  /**
   * Return a reference to front element and remove it.
   * 
   * @returns A reference to the element at the front.
   * @throws NoSuchElementException
   *           if this queue is empty.
   */
  public E remove() throws NoSuchElementException;
}