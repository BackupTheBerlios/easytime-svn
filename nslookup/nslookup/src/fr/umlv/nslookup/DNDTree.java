
package fr.umlv.nslookup;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.awt.Point;
import java.io.IOException;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.dnd.*;

/** Creates a JTree with Drag and Drop facilities.
* <p>
* Create and use an object of DNDTree instead of a JTree to include Drag and Drop features for your tree.
* @version 1.01 03/01/2001
* @author Prathap G
*/
public class DNDTree extends JTree implements DropTargetListener,DragSourceListener, DragGestureListener{
	/** The Drop position. */
	private DropTarget dropTarget = null;
	/** The Drag node.*/
	private DragSource dragSource = null;
	
	/** The dragged node.*/
	private NamingContextTreeNode selnode=null;
	/** The droppped node.*/
	private NamingContextTreeNode dropnode=null;
	/** The TreeModel for the tree.*/
	private DefaultTreeModel treemodel=null;

	/** Returns a new instance of the DNDTree for the specified TreeModel.*/
	public DNDTree(TreeModel model){
		super(model);
		treemodel=(DefaultTreeModel)model;
		dropTarget = new DropTarget (this, this);
		dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer( this, DnDConstants.ACTION_MOVE, this);
	}

	/** Internally implemented, Do not override!*/
	public void dragEnter(DropTargetDragEvent event){
	    System.out.println("drag enter");
		event.acceptDrag (DnDConstants.ACTION_MOVE);
	}

	/** Internally implemented, Do not override!*/
	public void dragExit(DropTargetEvent event){
	}

	/** Internally implemented, Do not override!*/
	public void dragOver(DropTargetDragEvent event){
	}

	/** Internally implemented, Do not override!*/
	public void drop(DropTargetDropEvent event){
		try {
			Transferable transferable = event.getTransferable();

			if (transferable.isDataFlavorSupported (DataFlavor.stringFlavor)){
				event.acceptDrop(DnDConstants.ACTION_MOVE);
				String s = (String)transferable.getTransferData ( DataFlavor.stringFlavor);
				Object occur=event.getSource();
				Point droppoint=event.getLocation();
				TreePath droppath=getClosestPathForLocation(droppoint.x,droppoint.y);
				dropnode=(NamingContextTreeNode)droppath.getLastPathComponent();
				if((dropnode.getType() != NamingContextTreeNode.TYPE_OBJECT) && (dropnode.getType() != NamingContextTreeNode.TYPE_ROOT)) 
				    event.getDropTargetContext().dropComplete(true);
				else
				{
				    System.out.println("Rejet� !");
					
				}
			}
			else{
				event.rejectDrop();
			}
		}
		catch (IOException exception) {
			event.rejectDrop();
		}
		catch (UnsupportedFlavorException ufException ) {
			event.rejectDrop();
		}
	}

	/** Internally implemented, Do not override!*/
	public void dropActionChanged ( DropTargetDragEvent event ){
	}

	/** Internally implemented, Do not override!*/
	public void dragGestureRecognized( DragGestureEvent event){
	    System.out.println("gesture recognized");
		selnode=null;
		dropnode=null;
		
		Object selected =getSelectionPath();
		TreePath treepath=(TreePath)selected;
		
		selnode=(NamingContextTreeNode)treepath.getLastPathComponent();
				
		if ( selected != null ){
			StringSelection text = new StringSelection( selected.toString());
			dragSource.startDrag (event, DragSource.DefaultMoveDrop, text, this);
		}
		else{
		}
	}

	/** Internally implemented, Do not override!.
	* throws IllegalArgumentException.
	*/
	public void dragDropEnd (DragSourceDropEvent event){
		if ( event.getDropSuccess()){
			try{
				if(dropnode.equals(selnode)){
					System.out.println("drag==drop");
					throw new IllegalArgumentException("the source is the same as the destination");
				}
				else{
				    	System.out.println("P�re:"+selnode.getParent());
				    	dropnode.add(selnode);
						//TODO Faire le nouveau mapping
				}
			} catch(IllegalArgumentException iae){
				throw new IllegalArgumentException(iae.toString());
			}
			treemodel.reload();
        }
	}

	/** Internally implemented, Do not override!*/
	public void dragEnter (DragSourceDragEvent event){
	}

	/** Internally implemented, Do not override!*/
	public void dragExit (DragSourceEvent event){
	}

	/** Internally implemented, Do not override!*/
	public void dragOver (DragSourceDragEvent event){
	}

	/** Internally implemented, Do not override!*/
	public void dropActionChanged ( DragSourceDragEvent event){
	}
}

