/*
 * Created on 29 nov. 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package fr.umlv.easytime.test.junit;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Mat
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for fr.uml.mloyen.monpackage");
		//$JUnit-BEGIN$
		suite.addTestSuite(AdditionnerBeanTest.class);
		suite.addTestSuite(AdditionnerBeanComputeTest.class);
		//$JUnit-END$
		return suite;
	}
}
