/* 
 * Project NSLookUPUI
 * ORBTreeCellRenderer.java - package UI.tree;
 * Creator: Administrateur
 * Created on 9 f�vr. 2005 09:49:05
 *
 * Person in charge: Administrateur
 */
package fr.umlv.nslookup.UI.tree;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import fr.umlv.nslookup.UI.MainFrame;

/**
 * @author Administrateur
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class ORBTreeCellRenderer extends DefaultTreeCellRenderer {

    private static ImageIcon rootIcon = new ImageIcon(MainFrame.class.getResource("icons/root24.gif"));
    
    private static ImageIcon orbIcon = new ImageIcon(MainFrame.class.getResource("icons/orb16.png"));
    private static ImageIcon orbSelIcon = new ImageIcon(MainFrame.class.getResource("icons/orb16sel.png"));
    private static ImageIcon orbOpenIcon = new ImageIcon(MainFrame.class.getResource("icons/orbopen16.png"));
    private static ImageIcon orbOpenSelIcon = new ImageIcon(MainFrame.class.getResource("icons/orbopen16sel.png"));
	
    private static ImageIcon nsIcon = new ImageIcon(MainFrame.class.getResource("icons/nc16.png"));
    private static ImageIcon nsSelIcon = new ImageIcon(MainFrame.class.getResource("icons/nc16sel.png"));
    private static ImageIcon nsOpenIcon = new ImageIcon(MainFrame.class.getResource("icons/ncopen16.png"));
    private static ImageIcon nsOpenSelIcon = new ImageIcon(MainFrame.class.getResource("icons/ncopen16sel.png"));
	
    private static ImageIcon objIcon = new ImageIcon(MainFrame.class.getResource("icons/obj16.png"));
    private static ImageIcon objSelIcon = new ImageIcon(MainFrame.class.getResource("icons/obj16sel.png"));
    
    
    
	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeCellRenderer#getTreeCellRendererComponent(javax.swing.JTree, java.lang.Object, boolean, boolean, boolean, int, boolean)
	 */    
	public Component getTreeCellRendererComponent(JTree tree, Object obj,
			boolean isSelected, boolean isExpanded, boolean isLeaf, int row, boolean hasFocus) {
	    
	    Component res = super.getTreeCellRendererComponent(tree, obj, isSelected, isExpanded, isLeaf, row, hasFocus);
		
	    NamingContextTreeNode node = (NamingContextTreeNode)obj;
	    setText(node.toString());
			    
		if(node.getType() == NamingContextTreeNode.TYPE_ROOT) {
		    setIcon(rootIcon);
			return res;
		}
		
		if(node.getType() == NamingContextTreeNode.TYPE_NS) {
			
		    if(isExpanded){
		    	if(isSelected) setIcon(orbOpenSelIcon);
		    	else setIcon(orbOpenIcon);
		    }
			else {
		    	if(isSelected) setIcon(orbSelIcon);
		    	else setIcon(orbIcon);
			}
			return res;
		}
		
		if(node.getType() == NamingContextTreeNode.TYPE_CONTEXT) {
			
		    if(isExpanded){
		    	if(isSelected) setIcon(nsOpenSelIcon);
		    	else setIcon(nsOpenIcon);
		    }
			else {
		    	if(isSelected) setIcon(nsSelIcon);
		    	else setIcon(nsIcon);
			}
			return res;
		}
		
		if(node.getType() == NamingContextTreeNode.TYPE_OBJECT) {
			
	    	if(isSelected) setIcon(objSelIcon);
	    	else setIcon(objIcon);
	  
			return res;
		}
		

		


		return null;
	}

}
