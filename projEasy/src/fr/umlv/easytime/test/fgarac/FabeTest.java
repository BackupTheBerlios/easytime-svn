/* 
 * Project easytime
 * FabeTest.java - package fr.umlv.easytime.test.fgarac;
 * Creator: fgarac
 * Created on 5 janv. 2005 15:45:16
 *
 * Person in charge: fgarac
 */
package fr.umlv.easytime.test.fgarac;

import junit.framework.TestCase;

/**
 * @author fgarac
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class FabeTest extends TestCase {

	public void testFabe(){
		int a=2;
		int b=2;
		int res;
		res=a+b;
		System.out.println(res);
		assertTrue(res==FabeClass.addition(a,b));
	}

}
