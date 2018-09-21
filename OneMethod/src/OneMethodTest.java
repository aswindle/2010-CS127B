
// This class has tests for three methods to provide practice for testing
// methods that need selection control patterns using if..else statements.
// Programmer: YOUR NAME
import static org.junit.Assert.*;
import org.junit.Test;

public class OneMethodTest {
	@Test
	public void testSeasonForWinter () {
	// Need a OneMethod object to send messages to
		OneMethod myFuns = new OneMethod();
		assertEquals("Winter", myFuns.season(12));
		assertEquals("Winter", myFuns.season(1));
		assertEquals("Winter", myFuns.season(2));
	}
	
	@Test
	public void testSeasonForSpring () {
		OneMethod myFuns = new OneMethod();
		assertEquals("Spring", myFuns.season(3));
		assertEquals("Spring", myFuns.season(4));
		assertEquals("Spring", myFuns.season(5));
	}

	@Test
	public void testSeasonForSummer () {
		OneMethod myFuns = new OneMethod();
		assertEquals("Summer", myFuns.season(6));
		assertEquals("Summer", myFuns.season(7));
		assertEquals("Summer", myFuns.season(8));
	}
	
	@Test
	public void testSeasonForFall () {
		OneMethod myFuns = new OneMethod();
		assertEquals("Fall", myFuns.season(9));
		assertEquals("Fall", myFuns.season(10));
		assertEquals("Fall", myFuns.season(11));
	}

}
