/*
 * Created on 29 nov. 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package fr.umlv.easytime.test.junit;

import junit.framework.TestCase;

/**
 * @author Mat
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AdditionnerBeanTest extends TestCase{
	public void testArg1() {
		  AdditionnerBean ab = new AdditionnerBean();
		  Integer i;
		  ab.setArg1(5);
		  assertEquals("Egal. getter", 5, ab.getArg1());
		  assertTrue(5 == ab.getArg1());
		  
		 }
}
