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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultTreeModel;

import org.omg.CORBA.ORBPackage.InvalidName;


import fr.umlv.nslookup.DNDTree;
import fr.umlv.nslookup.NamingContextTreeNode;
import fr.umlv.nslookup.TreeFactory;
import fr.umlv.nslookup.UI.actions.ActionContainer;
import fr.umlv.nslookup.UI.tree.DnDTreeSelectionListener;
import fr.umlv.nslookup.UI.tree.ORBTreeCellRenderer;


/**
 * @author Jo
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class MainFrame extends JFrame {

    private DNDTree tree;
    private NSLUToolBar toolBar;
    private NSLUMenuBar menuBar;
    private final ActionContainer ac;
    private NamingContextTreeNode root;
    
    public MainFrame(){
        super("NS lookup");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){            
            public void windowClosing(WindowEvent e){                
                ActionContainer.quit.actionPerformed(null);
            }            
        });        
        this.setSize(800, 600);
        ImageIcon icon = new ImageIcon(MainFrame.class.getResource("icons/logo v-.png"));
        this.setIconImage(icon.getImage());
        ac = new ActionContainer(this);
        
        
        initLookAndFeel();
        initRoot();// C'est là que l'arbre est créé
        createMenuBar();
        createToolBar();
        createTreeView();
        this.getContentPane().add(new JScrollPane(tree));
        this.setVisible(true);
        
        
    }
    
    private void createTreeView(){
        //tree = new DnDJTree(new DefaultTreeModel(root));
        tree = new DNDTree(new DefaultTreeModel(root){
            public void reload(){
                NamingContextTreeNode root = (NamingContextTreeNode)getRoot();
                String[] hosts = new String[root.getChildCount()];
                String[] ports = new String[root.getChildCount()];
                
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
                
            }
        });
        tree.setCellRenderer(new ORBTreeCellRenderer());
        tree.addTreeSelectionListener(new DnDTreeSelectionListener());
    }
    
    private void createToolBar(){
        toolBar = new NSLUToolBar();
        add(toolBar, BorderLayout.NORTH);
    }
    
    private void createMenuBar(){
        menuBar = new NSLUMenuBar();
        setJMenuBar(menuBar);
    }
    
    private void initRoot(){
        
        root = new NamingContextTreeNode("Root",NamingContextTreeNode.TYPE_ROOT);

        /*
        // Creation arbre d'un NC	
        try{
		    TreeFactory.createORBTree("localhost","1234", root);
		} catch (InvalidName e)
			{
			System.out.println("No connection :( ");
			e.printStackTrace();
			};
		*/
    }
    
    private void initLookAndFeel(){
    	try {
//			Skin theSkinToUse = SkinLookAndFeel.loadThemePack("bin/UI/themes/aquathemepack.zip");
//			SkinLookAndFeel.setSkin(theSkinToUse);
//			UIManager.setLookAndFeel(new SkinLookAndFeel());
//			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {e.printStackTrace();}
    	
    	//    	try {
//			UIManager.setLookAndFeel(new LiquidLookAndFeel());
//			SwingUtilities.updateComponentTreeUI(this);
//		} catch (UnsupportedLookAndFeelException e) {return;}
    }
    public static void main(String[] args) {
    	new MainFrame();
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
