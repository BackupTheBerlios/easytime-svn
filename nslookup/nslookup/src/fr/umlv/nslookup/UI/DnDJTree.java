/* 
 * Project nslookup
 * DnDJTree.java - package fr.umlv.nslookup.UI;
 * Creator: Jo
 * Created on 13 févr. 2005 22:27:35
 *
 * Person in charge: Jo
 */
package fr.umlv.nslookup.UI;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import fr.umlv.nslookup.NamingContextTreeNode;

/**
 * @author Jo
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class DnDJTree extends JTree 
					  implements DragGestureListener, 
					  			 DragSourceListener,
					  			 DropTargetListener{

    private DragSource dragSource;
    
    public DnDJTree(TreeModel model){
        super(model);
        
        dragSource = DragSource.getDefaultDragSource();
        DragGestureRecognizer dgr = dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE, this);
        DropTarget dropTarget = new DropTarget(this, this); 
    }
    
///////////////////////////// DragGestureListener Methods ////////////////////////////
    
    /* (non-Javadoc)
     * @see java.awt.dnd.DragGestureListener#dragGestureRecognized(java.awt.dnd.DragGestureEvent)
     */
    public void dragGestureRecognized(DragGestureEvent e) {
        TreeNode node = getSelectedNode();
        
        if(node!=null){
            Transferable t = (Transferable) node;
            
            dragSource.startDrag(e, DragSource.DefaultMoveDrop, t, this);
        }
    }

    private TreeNode getSelectedNode(){
        TreePath path = getSelectionPath();
        if(path==null) return null;
        else return (TreeNode) path.getLastPathComponent();
    }

    /////////////////////////////// DragSourceListener Methods ////////////////////////////
    
    /* (non-Javadoc)
     * @see java.awt.dnd.DragSourceListener#dragEnter(java.awt.dnd.DragSourceDragEvent)
     */
    public void dragEnter(DragSourceDragEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see java.awt.dnd.DragSourceListener#dragOver(java.awt.dnd.DragSourceDragEvent)
     */
    public void dragOver(DragSourceDragEvent e) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see java.awt.dnd.DragSourceListener#dropActionChanged(java.awt.dnd.DragSourceDragEvent)
     */
    public void dropActionChanged(DragSourceDragEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see java.awt.dnd.DragSourceListener#dragExit(java.awt.dnd.DragSourceEvent)
     */
    public void dragExit(DragSourceEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see java.awt.dnd.DragSourceListener#dragDropEnd(java.awt.dnd.DragSourceDropEvent)
     */
    public void dragDropEnd(DragSourceDropEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    ///////////////////// DropTargetListener ////////////////////////////
    
    /* (non-Javadoc)
     * @see java.awt.dnd.DropTargetListener#dragEnter(java.awt.dnd.DropTargetDragEvent)
     */
    public void dragEnter(DropTargetDragEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see java.awt.dnd.DropTargetListener#dragOver(java.awt.dnd.DropTargetDragEvent)
     */
    public void dragOver(DropTargetDragEvent e) {
        Point loc = e.getLocation();
        TreePath overPath = getPathForLocation(loc.x, loc.y);
        
        if(overPath==null) e.rejectDrag(); 
        else {
         
	        TreeNode overNode = (TreeNode) overPath.getLastPathComponent();
	        
	        if(overNode.getClass()==NamingContextTreeNode.class){
	            NamingContextTreeNode src = (NamingContextTreeNode) getSelectedNode();
	            NamingContextTreeNode dest = (NamingContextTreeNode) overNode;
	            System.out.println("yoyo - src:"+src.getType()+" - dest:"+dest.getType());
	            System.out.println(isMovable(src, dest));
	            if(isMovable(src, dest)) e.acceptDrag(DnDConstants.ACTION_MOVE);
	            else e.rejectDrag();
	        }
	        else e.rejectDrag();
        }
        
    }
    
    private boolean isMovable(NamingContextTreeNode src, NamingContextTreeNode dest){
        if(dest.getType()==NamingContextTreeNode.TYPE_ROOT) return false;
        if(src.getType()==NamingContextTreeNode.TYPE_NS) return false;
        
        if(src.getType()==NamingContextTreeNode.TYPE_OBJECT || src.getType()==NamingContextTreeNode.TYPE_CONTEXT){
            if(dest.getType()==NamingContextTreeNode.TYPE_OBJECT) return false;
            return true;
        }
        return false;
    }

    /* (non-Javadoc)
     * @see java.awt.dnd.DropTargetListener#dropActionChanged(java.awt.dnd.DropTargetDragEvent)
     */
    public void dropActionChanged(DropTargetDragEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see java.awt.dnd.DropTargetListener#dragExit(java.awt.dnd.DropTargetEvent)
     */
    public void dragExit(DropTargetEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see java.awt.dnd.DropTargetListener#drop(java.awt.dnd.DropTargetDropEvent)
     */
    public void drop(DropTargetDropEvent e) {
        
        Transferable trans = e.getTransferable();
        
        
            try {
                if(!trans.isDataFlavorSupported(NamingContextTreeNode.TREENODE_FLAVOR)) throw new UnsupportedFlavorException(NamingContextTreeNode.TREENODE_FLAVOR);
                NamingContextTreeNode node =  (NamingContextTreeNode) trans.getTransferData(NamingContextTreeNode.TREENODE_FLAVOR);
            
                Point destLoc = e.getLocation();
                TreePath destPath = getPathForLocation(destLoc.x,destLoc.y);
                TreeNode destNode = (TreeNode) destPath.getLastPathComponent();
                
                System.out.println("Drag n Drop de "+getSelectedNode()+" vers "+destNode);
            }
            catch (UnsupportedFlavorException e1) {e1.printStackTrace();} 
            catch (IOException e2) {e2.printStackTrace();}
        
    
    }
    
    
    
}
