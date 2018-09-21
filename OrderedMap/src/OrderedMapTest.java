/**
 * A unit test for OrderedMap<K, V> and these method
 * 1) V get(K)
 * 2) void put(K, V)
 * 3) boolean remove(K)
 * 4) int size()
 *
 * @author Rick Mercer
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrderedMapTest {

  @Test
  public void testPutAndGetAndSize() {
    OrderedMap<Integer, String> ranking = new OrderedMap<Integer, String>();
    ranking.put(1, "Kim");
    ranking.put(2, "Li");
    ranking.put(3, "Sandeep");
    assertNull(ranking.get(4));
    assertNotNull(ranking.get(1));
    assertNotNull(ranking.get(2));
    assertNotNull(ranking.get(3));
  }

  @Test
  public void testPutAndGetWithDifferentKeyType() {
    OrderedMap<String, Double> ranking = new OrderedMap<String, Double>();
    ranking.put("1", 1.11);
    ranking.put("2", 2.22);
    ranking.put("3", 3.33);
    assertEquals(1.11, ranking.get("1"), 1e-12);
  }

  @Test
  public void testPutWhenKeyExists() {
    OrderedMap<Integer, String> ranking = new OrderedMap<Integer, String>();
    assertTrue(ranking.put(1, "Kim"));
    assertTrue(ranking.put(2, "Li"));
    assertFalse(ranking.put(2, "Any Name"));
    assertEquals("Li", ranking.get(2));
    assertFalse("Any name".equals(ranking.get(2)));

  }

  ////////////////////////// Testing remove
  @Test
  public void testRemoveAndSizeWhenEmpty() {
    OrderedMap<String, String> accounts = new OrderedMap<String, String>();
    assertFalse(accounts.remove("Empty"));
  }

  @Test
  public void testRemoveAndSizeWhenSizeIsOne() {
    OrderedMap<String, String> strings = new OrderedMap<String, String>();
    strings.put("G", "Georgie");
    assertNotNull(strings.get("G"));
    assertEquals(1, strings.size());

    assertTrue(strings.remove("G"));

    assertEquals(0, strings.size());
    assertNull(strings.get("G"));
  }

  @Test
  public void testRemoveAndSizeWhenRootChangesWhenItHadNoLeftChild() {
    OrderedMap<String, String> strings = new OrderedMap<String, String>();
    strings.put("G", "Georgie");
    strings.put("R", "Rusty");
    assertEquals(2, strings.size());
    assertNotNull(strings.get("G"));
    assertTrue(strings.remove("G"));
    assertEquals(1, strings.size());
    assertNull(strings.get("G"));
    assertNotNull(strings.get("R")); // still there
  }
  
  @Test
  public void testNoLeftChildFartherDown() {
	OrderedMap<Integer, Integer> ints = new OrderedMap<Integer, Integer>();
	ints.put(1, 50);
	ints.put(2, 25);
	ints.put(3, 75);
	ints.put(4, 80);
	assertEquals(new Integer(75), ints.get(3));
	assertEquals(4, ints.size());
	assertTrue(ints.remove(3));
	assertEquals(3, ints.size());
  }
  
  @Test
  public void testLeftChildFartherDown(){
	  OrderedMap<String, String> letters = new OrderedMap<String, String>();
	  letters.put("Q", "50");
	  letters.put("A", "25");
	  letters.put("U", "75");
	  letters.put("T", "73");
	  letters.put("V", "80");
	  assertEquals(5, letters.size());
	  assertTrue(letters.remove("U"));
	  assertEquals(4, letters.size());
  }
  
  @Test
  public void testRemoveLeftRoot(){
	  OrderedMap<String, String> str = new OrderedMap<String, String>();
	  str.put("Q", "50");
	  str.put("F", "25");
	  assertTrue(str.remove("Q"));
  }

  @Test
  public void testRemoveLeft(){
	  OrderedMap<String, String> str = new OrderedMap<String, String>();
	  str.put("Q", "50");
	  str.put("F", "25");
	  str.put("A", "1");
	  assertTrue(str.remove("A"));
  }
  
  @Test
  public void testRemoveNotThere(){
	  OrderedMap<String, String> str = new OrderedMap<String, String>();
	  str.put("Q", "50");
	  str.put("F", "25");
	  str.put("A", "1");
	  assertFalse(str.remove("L"));
  }

}