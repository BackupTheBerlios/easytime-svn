/* 
 * Project easytime
 * testAdd.java - package fr.umlv.easytime.test.kjason;
 * Creator: kjason
 * Created on 5 janv. 2005 15:45:24
 *
 * Person in charge: kjason
 */
package fr.umlv.easytime.test.kjason;

import junit.framework.TestCase;

/**
 * @author kjason
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class testAdd extends TestCase
{
	public void testadd()
	{
		int a = 2;
		int b = 3;
		int result;
		
		result = kjason.add(a,b);
		
		assertTrue(result == 5);
	}
}
