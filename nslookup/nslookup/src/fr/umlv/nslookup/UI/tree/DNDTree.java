
package fr.umlv.nslookup.UI.tree;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
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

import javax.naming.Binding;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.AlreadyBound;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

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
	    //System.out.println("drag enter");
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
				    //System.out.println("Rejeté !");
					
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
	    //System.out.println("gesture recognized");
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

	
	private void moveContext(NamingContextTreeNode source, NamingContext destination){
	    
	    if(source.getType() == NamingContextTreeNode.TYPE_OBJECT)
	    {
	        try {
				source.rebind(destination);
			} catch (NotFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CannotProceed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidName e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AlreadyBound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  			        
	    }
	    else
	    {
	        String name = source.toString();
	        NamingContext newParent = destination;
	        NameComponent[] contextName = new NameComponent[1];
        	contextName[0] = new NameComponent(name,"");
	        NamingContext newContext = newParent.new_context();
	        try {
                newParent.rebind_context(contextName,newContext);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Création du naming context "+ name + " impossible","Erreur!",JOptionPane.ERROR_MESSAGE);
            }
            for (int i = 0; i < source.getChildCount(); i++) {
                 moveContext((NamingContextTreeNode)source.getChildAt(i),newContext);               
            }
	        
	        
	    }
	        
	    
	    
	    
	}
	
	
	/** Internally implemented, Do not override!.
	* throws IllegalArgumentException.
	*/
	public void dragDropEnd (DragSourceDropEvent event){
	    
	    
	    
	    
		if ( event.getDropSuccess()){
		    	if((selnode.getType() == NamingContextTreeNode.TYPE_NS)||(dropnode.equals(selnode))||(selnode.isNodeDescendant(dropnode))){
					///System.out.println("drag==drop");
					
				}
				else{
				    	//System.out.println("Père:"+selnode.getParent());
				    	
				    	
				    	if( (dropnode.getType() == NamingContextTreeNode.TYPE_CONTEXT) || (dropnode.getType() == NamingContextTreeNode.TYPE_NS))
				    	{
				    		//System.out.println(selnode.getType() +" "+ NamingContextTreeNode.TYPE_CONTEXT);
				    		//System.out.println(dropnode.getHost()+" "+ selnode.getHost());
				    		
				    		if((selnode.getType() == NamingContextTreeNode.TYPE_CONTEXT)&&
				    		   ((! dropnode.getPort().equals(selnode.getPort()))
				    		  ||(! dropnode.getHost().equals(selnode.getHost()))))
				    		// Dropping a naming context in a différent naming service. Carefull... -> special method
							{				    		    
				    		    moveContext(selnode,(NamingContext)dropnode.getNodeObject());				    		    				    		    
				    		    				    		    				    		  
				            	NamingContext rootContext = (NamingContext)selnode.getParentContext();
				            	try {
				                    rootContext.unbind(selnode.getBinding().binding_name);
				                } catch (Exception e) {
				                    JOptionPane.showMessageDialog(null,"Suppression du naming context "+ selnode.getBinding().binding_name[0].id+ " impossible","Erreur!",JOptionPane.ERROR_MESSAGE);
				                }
				    		    
							}
				    		else
				    		{
				    		try {
								selnode.rebind((NamingContext)dropnode.getNodeObject());
							} catch (NotFound e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (CannotProceed e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InvalidName e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (AlreadyBound e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				    		dropnode.add(selnode);
				    		}
				    	}
						
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
	
	public TreeNode getSelectedNode(){
        TreePath path = getSelectionPath();
        if(path==null) return null;
        else return (TreeNode) path.getLastPathComponent();
    }
}


