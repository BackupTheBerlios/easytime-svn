/* 
 * Project nslookup
 * DnDTreeSelectionListener.java - package fr.umlv.nslookup.UI.tree;
 * Creator: Jo
 * Created on 16 févr. 2005 15:34:32
 *
 * Person in charge: Jo
 */
package fr.umlv.nslookup.UI.tree;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import fr.umlv.nslookup.UI.actions.ActionContainer;

/**
 * @author Jo
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class DnDTreeSelectionListener implements TreeSelectionListener {

	/* (non-Javadoc)
     * @see javax.swing.event.TreeSelectionListener#valueChanged(javax.swing.event.TreeSelectionEvent)
     */
    public void valueChanged(TreeSelectionEvent e) {
        NamingContextTreeNode node = getSelectedNode(e);
        if(node==null) return;
        
        switch(node.getType()){
        
	    	case NamingContextTreeNode.TYPE_ROOT : {
	    	    ActionContainer.prop.setEnabled(false);
	    	    ActionContainer.addOBJ.setEnabled(true);
	    	    ActionContainer.remNS.setEnabled(false);
	    	    ActionContainer.addNC.setEnabled(false);
	    	    ActionContainer.remNC.setEnabled(false);
	    	    ActionContainer.addOBJ.setEnabled(false);
	    	    ActionContainer.remOBJ.setEnabled(false);
	    	    break;
	    	}
	    
	    	case NamingContextTreeNode.TYPE_NS : {
	    	    ActionContainer.prop.setEnabled(true);
	    	    ActionContainer.addOBJ.setEnabled(true);
	    	    ActionContainer.remNS.setEnabled(true);
	    	    ActionContainer.addNC.setEnabled(true);
	    	    ActionContainer.remNC.setEnabled(false);
	    	    ActionContainer.addOBJ.setEnabled(false);
	    	    ActionContainer.remOBJ.setEnabled(false);
	    	    
	    	    break;
	    	}
	    
	    	case NamingContextTreeNode.TYPE_CONTEXT : {
	    	    ActionContainer.prop.setEnabled(true);
	    	    ActionContainer.addOBJ.setEnabled(true);
	    	    ActionContainer.remNS.setEnabled(false);
	    	    ActionContainer.addNC.setEnabled(true);
	    	    ActionContainer.remNC.setEnabled(true);
	    	    ActionContainer.addOBJ.setEnabled(true);
	    	    ActionContainer.remOBJ.setEnabled(false);
	    	    
	    	    
	    	    break;
	    	}
	    
	    	case NamingContextTreeNode.TYPE_OBJECT : {
	    	    ActionContainer.prop.setEnabled(true);
	    	    ActionContainer.addOBJ.setEnabled(true);
	    	    ActionContainer.remNS.setEnabled(false);
	    	    ActionContainer.addNC.setEnabled(false);
	    	    ActionContainer.remNC.setEnabled(false);
	    	    ActionContainer.addOBJ.setEnabled(false);
	    	    ActionContainer.remOBJ.setEnabled(true);
	    	    
	    	    break;
	    	}
	    	
	    	default:
	    	{
	    		ActionContainer.prop.setEnabled(false);
	    	    ActionContainer.addOBJ.setEnabled(true);
	    	    ActionContainer.remNS.setEnabled(false);
	    	    ActionContainer.addNC.setEnabled(false);
	    	    ActionContainer.remNC.setEnabled(false);
	    	    ActionContainer.addOBJ.setEnabled(false);
	    	    ActionContainer.remOBJ.setEnabled(false);	    			    		
	    	}
    
        }
        

    }

    private NamingContextTreeNode getSelectedNode(TreeSelectionEvent e){
        TreePath path = e.getPath();
        if(path==null) return null;
        NamingContextTreeNode node = (NamingContextTreeNode) path.getLastPathComponent();
        return node;
        
    }
}
