/* 
 * Project NSLookUPUI
 * ActionContainer.java - package UI.actions;
 * Creator: Jo
 * Created on 9 f�vr. 2005 16:22:26
 *
 * Person in charge: Jo
 */
package fr.umlv.nslookup.UI.actions;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;

import org.omg.CORBA.ORBPackage.InvalidName;

import fr.umlv.nslookup.DNDTree;
import fr.umlv.nslookup.NamingContextTreeNode;
import fr.umlv.nslookup.TreeFactory;
import fr.umlv.nslookup.UI.MainFrame;
import fr.umlv.nslookup.UI.MiscDialog;
import fr.umlv.nslookup.UI.NSLUMenuBar;
import fr.umlv.nslookup.UI.ORBCfgFileFilter;
import fr.umlv.nslookup.config.ConfigTool;
import fr.umlv.nslookup.config.ORBConfig;


/**
 * @author Jo
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class ActionContainer {
	
	private MainFrame frame;
	
	public ActionContainer(MainFrame frame){
		this.frame = frame;
		initDefault();
		initStaticActions();
	}
	

	public static Action save;
	public static Action load;
	public static Action addNC;
    public static Action remNC;
    public static Action addOBJ;
    public static Action remOBJ;
    public static Action addORB;
    public static Action remORB;
    public static Action refresh;
    public static Action prop;
    public static Action option;
    public static Action help;
    public static Action about;
    public static Action quit;
    
    public void initDefault(){
        addNC = DefaultActionFactory.addNC;
        remNC= DefaultActionFactory.remNC;
        addOBJ= DefaultActionFactory.addOBJ;
        remOBJ= DefaultActionFactory.remOBJ;
        addORB= DefaultActionFactory.addORB;
        remORB= DefaultActionFactory.remORB;
        
    }
    
    private void initStaticActions(){
        save = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
                /*
                DNDTree tree = frame.getTree();
                NamingContextTreeNode node = (NamingContextTreeNode)tree.getSelectedNode();
                System.out.println(MiscDialog.showIORInputDialog(frame));
                */
                NamingContextTreeNode root = (NamingContextTreeNode)frame.getTree().getModel().getRoot();
                
                if(root.getChildCount() == 0)
                {
                    JOptionPane.showMessageDialog(frame,"Aucun orb en cours de visualisation !","Rien � sauver !",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                JFileChooser choice = new JFileChooser();
                choice.setDialogTitle("Enregistrement de la configuration");
                choice.setFileSelectionMode(JFileChooser.FILES_ONLY);
                choice.setFileFilter(new ORBCfgFileFilter());
                
                int rp = choice.showSaveDialog(frame);
                if (rp == JFileChooser.APPROVE_OPTION) {
                    String path = choice.getSelectedFile().getAbsolutePath();
                    if( ! path.endsWith(".cfg"))
                        path = path + ".cfg";
                                                         
                                        
                    
                    ORBConfig[] tab = new ORBConfig[root.getChildCount()];
                    
                    for(int i =0;i<root.getChildCount();i++)
                    {
                        NamingContextTreeNode node = (NamingContextTreeNode)root.getChildAt(i);
                        String host = node.getHost();
                        String port = node.getPort();                        
                        tab[i] = new ORBConfig(port,host);
                    }
                    
                    ConfigTool.saveConfig(path,tab);
                    
                    
                }
                
                
            }            
        };
        save.putValue(Action.SMALL_ICON, new ImageIcon(ActionContainer.class.getResource("../icons/save16.png")));
        save.putValue(Action.NAME, "Sauvegarder");
        save.putValue(Action.SHORT_DESCRIPTION,"Sauvegarder la configuration");

        load = new AbstractAction(){
            
            public void actionPerformed(ActionEvent arg0) {
                NamingContextTreeNode root = (NamingContextTreeNode)frame.getTree().getModel().getRoot();
                                
                JFileChooser choice = new JFileChooser();
                choice.setDialogTitle("Lecture de la configuration");
                choice.setFileSelectionMode(JFileChooser.FILES_ONLY);
                choice.setFileFilter(new ORBCfgFileFilter());                
                int rp = choice.showOpenDialog(frame);
                
                if (rp == JFileChooser.APPROVE_OPTION) {
                    String path = choice.getSelectedFile().getAbsolutePath();
                    
                    ORBConfig[] tab = ConfigTool.loadConfig(path);
                    root = new NamingContextTreeNode("Root",NamingContextTreeNode.TYPE_ROOT);                    
                    for(int i =0;i<tab.length;i++)
                    {                        
                        String host = tab[i].getAddress();
                        String port = tab[i].getPort();                   
//                      Creation arbre d'un NC	
                        try{
                		    TreeFactory.createORBTree(host,port,root);
                		} catch (InvalidName e)
                			{
                		    JOptionPane.showMessageDialog(frame,"Connexion impossible � " + host + ":" + port,"Erreur!",JOptionPane.ERROR_MESSAGE);
                			//System.out.println("No connection :( " + host + " " + port);
                			//e.printStackTrace();
                			};
                        
                    }
                    ((DefaultTreeModel)frame.getTree().getModel()).setRoot(root);
                    ((DefaultTreeModel)frame.getTree().getModel()).reload();
                    
                    
                    
                }
            }            
        };
        load.putValue(Action.SMALL_ICON, new ImageIcon(ActionContainer.class.getResource("../icons/load16.png")));
        load.putValue(Action.NAME, "Charger");
        load.putValue(Action.SHORT_DESCRIPTION,"Charger une configuration");
        
        refresh = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
                ((DefaultTreeModel)frame.getTree().getModel()).reload();
            }            
        };
        refresh.putValue(Action.SMALL_ICON, new ImageIcon(ActionContainer.class.getResource("../icons/refresh16.png")));
        refresh.putValue(Action.NAME, "Rafra�chir");
        refresh.putValue(Action.SHORT_DESCRIPTION,"Rafra�chir");
        
        prop = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
                DNDTree tree = frame.getTree();
                
                NamingContextTreeNode node = (NamingContextTreeNode)tree.getSelectedNode();
                MiscDialog.showCORBAProperties(frame, node);
            }            
        };
        prop.putValue(Action.SMALL_ICON, new ImageIcon(ActionContainer.class.getResource("../icons/prop16.gif")));
        prop.putValue(Action.NAME, "Propri�t�s");
        prop.putValue(Action.SHORT_DESCRIPTION,"Propri�t�s");
        
        option = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
            }            
        };
        option.putValue(Action.SMALL_ICON, new ImageIcon(ActionContainer.class.getResource("../icons/option16.gif")));
        option.putValue(Action.NAME, "Options");
        option.putValue(Action.SHORT_DESCRIPTION,"Options");
        
        help = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
            	NamingContextTreeNode root = (NamingContextTreeNode)frame.getTree().getModel().getRoot();
                MiscDialog.showAddORB(frame,root);
                ((DefaultTreeModel)(frame.getTree().getModel())).reload();
            }            
        };
        help.putValue(Action.SMALL_ICON, new ImageIcon(ActionContainer.class.getResource("../icons/help16.gif")));
        help.putValue(Action.NAME, "Aide");
        help.putValue(Action.SHORT_DESCRIPTION,"Aide");
        
        about = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
            }            
        };
        about.putValue(Action.SMALL_ICON, new ImageIcon(ActionContainer.class.getResource("../icons/logoc16.png")));
        about.putValue(Action.NAME, "A propos");
        about.putValue(Action.SHORT_DESCRIPTION,"A propos");
        
        quit = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
               if(JOptionPane.showConfirmDialog(frame,"Etes vous sur de vouloir quitter ?","Quitter ?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
               {
                   frame.dispose();
                   System.exit(0);
               }
            }            
        };
        quit.putValue(Action.SMALL_ICON, new ImageIcon(ActionContainer.class.getResource("../icons/quit16.png")));
        quit.putValue(Action.NAME, "Quitter");
        quit.putValue(Action.SHORT_DESCRIPTION,"Quitter NSLookUP");
        
    }
    
    
 
    
    /**
     * 
     * Pickup all the source action values (NAME, LONG_DESCRIPTION, SHORT_DESCRIPTION, SMALL_ICON, ACCELERATOR_KEY)
     * and copy them to the target action.
     *
     * @param source
     * @param target
     */
    private void copyActionSkeleton(Action source, Action target){
        target.putValue(Action.NAME, source.getValue(Action.NAME));
        target.putValue(Action.LONG_DESCRIPTION, source.getValue(Action.LONG_DESCRIPTION));
        target.putValue(Action.SHORT_DESCRIPTION, source.getValue(Action.SHORT_DESCRIPTION));
        if(source.getValue(Action.SMALL_ICON)!=null) target.putValue(Action.SMALL_ICON, source.getValue(Action.SMALL_ICON));
        if(source.getValue(Action.ACCELERATOR_KEY)!=null) target.putValue(Action.ACCELERATOR_KEY, source.getValue(Action.ACCELERATOR_KEY));
        target.setEnabled(true);
    }
    
    public void setActions(Action addNC, Action remNC, Action addOBJ, Action remOBJ, Action addORB, Action remORB){
    	
    	copyActionSkeleton(DefaultActionFactory.addNC, ActionContainer.addNC);
    	ActionContainer.addNC = addNC;
    	
    	copyActionSkeleton(DefaultActionFactory.remNC, ActionContainer.remNC);
    	ActionContainer.remNC = remNC;
    	
    	copyActionSkeleton(DefaultActionFactory.addOBJ, ActionContainer.addOBJ);
    	ActionContainer.addOBJ = addOBJ;
    	
    	copyActionSkeleton(DefaultActionFactory.remOBJ, ActionContainer.remOBJ);
    	ActionContainer.remOBJ = remOBJ;
    	
    	copyActionSkeleton(DefaultActionFactory.addORB, ActionContainer.addORB);
    	ActionContainer.addORB = addORB;
    	
    	copyActionSkeleton(DefaultActionFactory.remORB, ActionContainer.remORB);
    	ActionContainer.remORB = remORB;
    	
    	frame.getToolBar().loadActions();
    	((NSLUMenuBar)frame.getJMenuBar()).loadActions();
    }
}
