/*
 * Created on 5 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.easytime.test.mloyen;

import fr.umlv.easytime.test.junit.AdditionnerBean;
import junit.framework.TestCase;

/**
 * @author mloyen
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class testSoustraction extends TestCase {
	
	public void testSous() {
		  
		  int i=5;
		  int j=3;
		  assertEquals("Egal. op", 2, Soustraction.soutrait(i,j));
		  assertTrue(2 ==  Soustraction.soutrait(i,j));
		  
		 }

}
