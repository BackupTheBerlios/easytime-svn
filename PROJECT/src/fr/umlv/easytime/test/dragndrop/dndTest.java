/* 
 * Project easytime
 * dndTest.java - package fr.umlv.easytime.test.dragndrop;
 * Creator: Mat
 * Created on 30 déc. 2004 13:44:52
 *
 * Person in charge: Mat
 */
package fr.umlv.easytime.test.dragndrop;

import javax.swing.JFrame;

/**
 * @author Mat
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class dndTest {
    
    private JFrame frame;
    private dndPanel panel;
    
    public dndTest(){
        panel = new dndPanel();
        frame = new JFrame("Tester Drag'n'drop");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel.getBack());
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        System.out.println("dnd test allright.");
        dndTest test = new dndTest();
    }
}
