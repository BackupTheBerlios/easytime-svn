/* 
 * Project TestJUnit
 * CommentsTest.java - package fr.uml.mloyen.monpackage;
 * Creator: Mat
 * Created on 10 déc. 2004 17:01:33
 *
 * Person in charge: Mat
 */
package fr.uml.mloyen.monpackage;

import java.io.IOException;

/**
 * @author Mat
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class CommentsTest {

    private int atrrib;
    
    /**
     * Creates a new CommentsTest object.
     *
     * @param i
     */
    public CommentsTest(int i) {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
    }
    
    /**
     * @return Returns the atrrib.
     */
    public int getAtrrib() {
        return atrrib;
    }
    /**
     * @param atrrib The atrrib to set.
     */
    public void setAtrrib(int atrrib) {
        this.atrrib = atrrib;
    }
    
    /**
     * Prints something on the console
     * 
     * @param param1 The parameter we want to incluse in the message
     * @throws IOException if  there is a problem
     */
    public void testMethod(int param1) throws IOException{
        System.out.println("test method");
    }
}
