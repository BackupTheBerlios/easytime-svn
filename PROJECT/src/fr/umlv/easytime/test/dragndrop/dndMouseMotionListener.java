/* 
 * Project easytime
 * dndMouseMotionListener.java - package fr.umlv.easytime.test.dragndrop;
 * Creator: Mat
 * Created on 30 déc. 2004 15:01:34
 *
 * Person in charge: Mat
 */
package fr.umlv.easytime.test.dragndrop;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;

/**
 * @author Mat
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class dndMouseMotionListener extends MouseAdapter implements MouseMotionListener {

    private Component comp;
    private GridBagLayout grid;
    private int MOVE = 1;
    private int RESIZE = 2;
    
    public dndMouseMotionListener(Component comp, GridBagLayout grid){
        
        this.comp = comp;
        this.grid = grid;
        
    }
    
    public void mousePressed(MouseEvent e){
        
        //System.out.println("pressé");
        comp.setCursor(new Cursor(Cursor.MOVE_CURSOR));
    }
    
    public void mouseReleased(MouseEvent e){
        //System.out.println("relaché");
        comp.setCursor(Cursor.getDefaultCursor());
        
    }
    
    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("dragged");
        Point es = e.getPoint();
        es.translate(comp.getX(), comp.getY());
       	//System.out.println(es);
       	//System.out.println(comp.getBounds());
       	//System.out.println(comp.getBounds().contains(es));
       	if(!comp.getBounds().contains(es))
       	{
       	    //System.out.println("CHANGE !");
       	    GridBagConstraints c = grid.getConstraints(comp);
       	    
       	    if(es.getX() < comp.getX())
       	       c.gridx --;
       	    if(es.getX() > comp.getX()+comp.getWidth())
	     	   c.gridx ++;
       	    
       	    if(es.getY() < comp.getY())
     	       c.gridy --;
     	    if(es.getY() > comp.getY()+comp.getHeight())
	     	   c.gridy ++;
     	    
       	    
       	    grid.setConstraints(comp,c);
       	    comp.getParent().doLayout();       	    
       	}
       
    }
    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("moved");

    }
}
