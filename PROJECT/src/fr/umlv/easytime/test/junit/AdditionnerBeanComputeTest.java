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
public class AdditionnerBeanComputeTest extends TestCase {
		public void testCompute(){
                   			
			AdditionnerBean ab = new AdditionnerBean();
			ab.setArg1(5);
			ab.setArg2(4);
			ab.compute();
			assertEquals("Addition ", 8 , ab.getSum() );
			
			
			
		}
}
