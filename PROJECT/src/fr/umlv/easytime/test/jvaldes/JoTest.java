/* 
 * Project easytime
 * JoTest.java - package src.fr.umlv.easytime.test.jvaldes;
 * Creator: jvaldes
 * Created on 5 janv. 2005 15:45:12
 *
 * Person in charge: jvaldes
 */
package src.fr.umlv.easytime.test.jvaldes;

import junit.framework.TestCase;

/**
 * @author jvaldes
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class JoTest extends TestCase {
	public void testOperation(){
		double a, b, res;
		a=6.6;
		b=2;
		res=a/b;
		assertTrue(res==JoClass.division(a,b));
	}
}
