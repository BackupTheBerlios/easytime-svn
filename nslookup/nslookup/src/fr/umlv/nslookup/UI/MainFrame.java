/* 
 * Project NSLookUPUI
 * MainFrame.java - package UI;
 * Creator: Jo
 * Created on 8 févr. 2005 15:14:22
 *
 * Person in charge: Jo
 */
package fr.umlv.nslookup.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.omg.CORBA.ORBPackage.InvalidName;


import fr.umlv.nslookup.UI.actions.ActionContainer;
import fr.umlv.nslookup.UI.tree.DNDTree;
import fr.umlv.nslookup.UI.tree.DnDTreeSelectionListener;
import fr.umlv.nslookup.UI.tree.NamingContextTreeNode;
import fr.umlv.nslookup.UI.tree.ORBTreeCellRenderer;
import fr.umlv.nslookup.UI.tree.TreeFactory;


/**
 * @author Jo
 *
 * Main frame class, which display the client window. It contains a tool bar, a menu bar which allows to access to the
 * major actions (contained in a ActionContainer) and a Tree which gives access to the Naming Services browsing.
 * 
 */
public class MainFrame extends JFrame {

    	// JTree allowing to browse through the  opened Naming Services and to manipulate Naming Contextes and CORBA Objects.
    private DNDTree tree;
    	// Tool bar containing the button linked to the most used actions
    private NSLUToolBar toolBar;
    	// Menu bar containing all the available actions 
    private NSLUMenuBar menuBar;
    	// ActionContainer allowing to access the actions
    private final ActionContainer ac;
    	// Root node of the tree
    private NamingContextTreeNode root;
    
    
    
    /**
     * Creates a new MainFrame object, and instanciate all the internal component.
     */
    public MainFrame(){
        super("NS lookup");
        
        	// Initialisation of the Frame
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){            
            public void windowClosing(WindowEvent e){                
                ActionContainer.quit.actionPerformed(null);
            }            
        });        
        this.setSize(800, 600);
        ImageIcon icon = new ImageIcon(MainFrame.class.getResource("icons/logocarre.png"));
        this.setIconImage(icon.getImage());
        initLookAndFeel();
        
        	// Instanciation of the internal components
        ac = new ActionContainer(this);
        initRoot();
        createMenuBar();
        createToolBar();
        createTreeView();
        this.getContentPane().add(new JScrollPane(tree));
        this.setVisible(true);
    }
    
    /**
     * Create the tree which implements Drag And Drop Manipulations.
     * The tree model is modified because the reload method has been rewritten.
     * A mouse Listener has been added to access to a PopUp menu similar to the Tool Bar.  
     * 
     */
    private void createTreeView(){
        // Creation of the Tree with the modified DefaultTreeModel        
        tree = new DNDTree(new DefaultTreeModel(root){
            public void reload(){
                NamingContextTreeNode root = (NamingContextTreeNode)getRoot();
                String[] hosts = new String[root.getChildCount()];
                String[] ports = new String[root.getChildCount()];
                
                NamingContextTreeNode parent;
                int[] indexes = null;
                TreePath t = tree.getSelectionPath();
                if(t!=null)
                {
                indexes = new int[t.getPathCount()];
                
                indexes[0] = 0;
                parent = root;
                for(int i=1;i<t.getPathCount();i++)
                {
                    NamingContextTreeNode n = (NamingContextTreeNode)(t.getPathComponent(i));
                    int index = parent.findIndex(n); 
                    indexes[i]=index;
                    parent = n;
                }
                
                }
                
                for (int i = 0; i < root.getChildCount(); i++) {
                    NamingContextTreeNode tmp = (NamingContextTreeNode) root.getChildAt(i);
                    hosts[i]=tmp.getHost();
                    ports[i]=tmp.getPort();
                    
                }
                root.removeAllChildren();
                
                for (int i = 0; i < hosts.length; i++) {
                    try {
                        TreeFactory.createORBTree(hosts[i], ports[i], root);
                    } catch (InvalidName e) {
                        JOptionPane.showMessageDialog(MainFrame.this , "Entité CORBA inaccessible", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
                super.reload();
                expandAll(tree, new TreePath(root), true);
                if(t == null)
                    return;
                t = new TreePath(root);
                parent = root;
                for (int i = 1; i < indexes.length; i++) {
                    
                    if(indexes[i] < parent.getChildCount())
                    {
                        parent = (NamingContextTreeNode)(parent.getChildAt(indexes[i]));
                    	t = t.pathByAddingChild(parent);
                    }
                    else 
                    {
                        
                        ActionContainer.reset();
                        return;
                    }
                    
                }
                tree.setSelectionPath(t);
             
         }
         
         
         
         private void expandAll(JTree tree, TreePath parent, boolean expand) {
             // Traverse children
             TreeNode node = (TreeNode)parent.getLastPathComponent();
             if (node.getChildCount() >= 0) {
                 for (Enumeration e=node.children(); e.hasMoreElements(); ) {
                     TreeNode n = (TreeNode)e.nextElement();
                     TreePath path = parent.pathByAddingChild(n);
                     expandAll(tree, path, expand);
                 }
             }
         
             // Expansion or collapse must be done bottom-up
             if (expand) {
                 tree.expandPath(parent);
             } else {
                 tree.collapsePath(parent);
             }
         }
         
         
         
         
     });
        	// Setting Up of a special Cell Renderer 
        tree.setCellRenderer(new ORBTreeCellRenderer());
        	// Implementation of a tree selection listener which disable or enable the action following the type 
        	// of the node selected
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(new DnDTreeSelectionListener());
        
        	// Implementation of a PopUp menu called by a mou right click.
        final JPopupMenu PPmenu = new NSLUPopUpMenu();
        tree.addMouseListener(new MouseListener(){

            public void mouseClicked(MouseEvent e) {}

            public void mousePressed(MouseEvent e) {
                if(e.getButton()!=MouseEvent.BUTTON1){
                    TreePath path = tree.getPathForLocation(e.getX(), e.getY());
                    tree.setSelectionPath(path);
                    if(path==null) ActionContainer.reset();
                }
            }

            public void mouseReleased(MouseEvent e) {
                if(e.getButton()==MouseEvent.BUTTON3) PPmenu.show(tree, e.getX(), e.getY());
            }

            public void mouseEntered(MouseEvent arg0) {}

            public void mouseExited(MouseEvent arg0) {}
            
        });
        	// Start of a refresh thread
        Runnable r = new Runnable(){
        	public void run(){
        		
        		while(true)
        		{
        		try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {}

				((DefaultTreeModel)tree.getModel()).reload();

				
        		}
        	}        	
        };
        new Thread(r).start();

    }
    
    /**
     * 
     * Intanciates the tool bar with all its buttons and put it at the top of the frame.
     *
     */
    private void createToolBar(){
        toolBar = new NSLUToolBar();
        add(toolBar, BorderLayout.NORTH);
    }
    
    /**
     * 
     * Intanciates the menu bar with all its buttons and adds to the frame.
     *
     */
    private void createMenuBar(){
        menuBar = new NSLUMenuBar();
        setJMenuBar(menuBar);
    }
    
    /**
     * 
     * Intanciates the menu bar with all its buttons and adds to the frame.
     *
     */
    private void initRoot(){
        root = new NamingContextTreeNode("Root",NamingContextTreeNode.TYPE_ROOT);
    }
    
    private void initLookAndFeel(){
    	try {
    	    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		    // Nothing is done if the LookAndFeel can't be installed.
		}
    }
    public static void main(String[] args) throws SecurityException, FileNotFoundException, IOException {
            new MainFrame();
            LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
    }
    
    
	/**
	 * @return Returns the toolBar.
	 */
	public NSLUToolBar getToolBar() {
		return toolBar;
	}
	
	
    public DNDTree getTree() {
        return tree;
    }
}
