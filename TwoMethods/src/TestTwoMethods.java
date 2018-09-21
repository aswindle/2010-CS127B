import static org.junit.Assert.*;
import org.junit.Test;

public class TestTwoMethods {
	@Test
	public void testIsEven(){
		TwoMethods myFuns = new TwoMethods();
		assertTrue(myFuns.isEven(2));
		assertTrue(myFuns.isEven(0));
		assertFalse(myFuns.isEven(-1));
		assertFalse(myFuns.isEven(127));
	}
		
	@Test
	public void testReverse(){
		TwoMethods myFuns2 = new TwoMethods();
		assertEquals("blah", myFuns2.reverse("halb"));
		assertEquals("super", myFuns2.reverse("repus"));
	}
}
