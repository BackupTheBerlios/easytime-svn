/* 
 * Project easytime
 * ExpoTest.java - package fr.umlv.easytime.test.rjourdan;
 * Creator: rjourdan
 * Created on 5 janv. 2005 15:46:32
 *
 * Person in charge: rjourdan
 */
package fr.umlv.easytime.test.rjourdan;

import junit.framework.TestCase;

/**
 * @author rjourdan
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class FactoTest extends TestCase {
	
	public void testProcess(){
		int a = 6;
		int result = 720;
		assertTrue(result == Facto.process(a));
	}

}
