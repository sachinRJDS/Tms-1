package practice;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assertion {
	@Test
	public void checkTrue() {
		int a=10;
		assertEquals(a,10,"not ten");
		Reporter.log("It is correct",true);
		
		String b="hey";
		assertEquals(b,"hey","hello");
		Reporter.log("Hey is printing",true);
		
		assertTrue(a>11,"not correct");
		Reporter.log("correct");
	}
}
