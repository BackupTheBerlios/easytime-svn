package test;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import org.omg.CORBA.ORBPackage.InvalidName;

import fr.umlv.nslookup.UI.tree.DNDTree;
import fr.umlv.nslookup.UI.tree.NamingContextTreeNode;
import fr.umlv.nslookup.UI.tree.TreeFactory;

/*
 * Created on 7 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author mloyen
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TreeFrame {

	
	JFrame frame=null;
	JTree tree=null;
	NamingContextTreeNode root=null;
	
	public TreeFrame(){
		
		frame = new JFrame("NSLookup");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 
		try{
		    root =TreeFactory.createORBTree("localhost","1234",root);
		} catch (InvalidName e)
			{
			System.out.println("No connection :( ");
			e.printStackTrace();
			};
		
		DefaultTreeModel model = new DefaultTreeModel(root);
		//tree = new JTree(model);
		tree = new DNDTree(model);
		/*
		tree.addTreeSelectionListener(new TreeSelectionListener(){

            public void valueChanged(TreeSelectionEvent e) {
               
                
                NamingContextTreeNode node = (NamingContextTreeNode)tree.getSelectionPath().getLastPathComponent();
                System.out.println(node.getType());
                
                
                
            }
		    
		    
		    
		    
		});
		*/
		
		
		frame.getContentPane().add(tree);
		frame.setSize(400,400);
		frame.show();
		
		
	}
	
	
	public static void main(String[] args) {
		
		new TreeFrame();
		
	}
}
