
package fr.umlv.nslookup.UI.actions;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ObjectHelper;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.AlreadyBound;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import td1.HorlogeHelper;

import fr.umlv.nslookup.UI.AboutDialog;
import fr.umlv.nslookup.UI.MainFrame;
import fr.umlv.nslookup.UI.MiscDialog;
import fr.umlv.nslookup.UI.NSLUMenuBar;
import fr.umlv.nslookup.UI.NSCfgFileFilter;
import fr.umlv.nslookup.UI.UIHelp;
import fr.umlv.nslookup.UI.tree.DNDTree;
import fr.umlv.nslookup.UI.tree.NamingContextTreeNode;
import fr.umlv.nslookup.UI.tree.TreeFactory;
import fr.umlv.nslookup.config.ConfigTool;
import fr.umlv.nslookup.config.NSConfig;


/**
 * @author jvaldes
 *
 * Class containing all the action and allowing to let them available.
 *
 */
public class ActionContainer {
		// Main client frame
	private MainFrame frame;
		// all the actions
	public static Action save;
	public static Action load;
	public static Action addNC;
    public static Action remNC;
    public static Action addOBJ;
    public static Action remOBJ;
    public static Action addNS;
    public static Action remNS;
    public static Action refresh;
    public static Action prop;
    public static Action option;
    public static Action help;
    public static Action about;
    public static Action quit;
    
	
	/**
	 * 
	 * Creates a new ActionContainer object.
	 *
	 * @param frame
	 */
	public ActionContainer(MainFrame frame){
		this.frame = frame;
		initActions();
		initStaticActions();
	}
	

	/**
	 * 
	 * Set all the action to disabled state.
	 *
	 *
	 */
    public static void reset(){
    	addNC.setEnabled(false);
    	remNC.setEnabled(false);
    	addOBJ.setEnabled(false);
    	remOBJ.setEnabled(false);
    	addNS.setEnabled(true);
    	remNS.setEnabled(false);
    	prop.setEnabled(false);
    }
    
    /**
     * 
     * Contructs all the static actions.
     *
     *
     */
    private void initStaticActions(){
        save = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
                
            	NamingContextTreeNode root = (NamingContextTreeNode)frame.getTree().getModel().getRoot();
                
                if(root.getChildCount() == 0)
                {
                    JOptionPane.showMessageDialog(frame,"Aucun orb en cours de visualisation !","Rien à sauver !",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                JFileChooser choice = new JFileChooser();
                choice.setDialogTitle("Enregistrement de la configuration");
                choice.setFileSelectionMode(JFileChooser.FILES_ONLY);
                choice.setFileFilter(new NSCfgFileFilter());
                
                int rp = choice.showSaveDialog(frame);
                if (rp == JFileChooser.APPROVE_OPTION) {
                    String path = choice.getSelectedFile().getAbsolutePath();
                    if( ! path.endsWith(".cfg"))
                        path = path + ".cfg";
                                                         
                                        
                    
                    NSConfig[] tab = new NSConfig[root.getChildCount()];
                    
                    for(int i =0;i<root.getChildCount();i++)
                    {
                        NamingContextTreeNode node = (NamingContextTreeNode)root.getChildAt(i);
                        String host = node.getHost();
                        String port = node.getPort();                        
                        tab[i] = new NSConfig(port,host);
                    }
                    
                    ConfigTool.saveConfig(path,tab);
                    
                    
                }
                
                
            }            
        };
        save.putValue(Action.SMALL_ICON, new ImageIcon(MainFrame.class.getResource("icons/save16.png")));
        save.putValue(Action.NAME, "Sauvegarder");
        save.putValue(Action.SHORT_DESCRIPTION,"Sauvegarder la configuration");

        load = new AbstractAction(){
            
            public void actionPerformed(ActionEvent arg0) {
                NamingContextTreeNode root = (NamingContextTreeNode)frame.getTree().getModel().getRoot();
                                
                JFileChooser choice = new JFileChooser();
                choice.setDialogTitle("Lecture de la configuration");
                choice.setFileSelectionMode(JFileChooser.FILES_ONLY);
                choice.setFileFilter(new NSCfgFileFilter());                
                int rp = choice.showOpenDialog(frame);
                
                if (rp == JFileChooser.APPROVE_OPTION) {
                    String path = choice.getSelectedFile().getAbsolutePath();
                    
                    NSConfig[] tab = ConfigTool.loadConfig(path);
                    root = new NamingContextTreeNode("Root",NamingContextTreeNode.TYPE_ROOT);                    
                    for(int i =0;i<tab.length;i++)
                    {                        
                        String host = tab[i].getAddress();
                        String port = tab[i].getPort();                   
//                      Creation arbre d'un NC	
                        try{
                		    TreeFactory.createORBTree(host,port,root);
                		} catch (Throwable e)
                			{
                		    JOptionPane.showMessageDialog(frame,"Connexion impossible à " + host + ":" + port,"Erreur!",JOptionPane.ERROR_MESSAGE);
                			//System.out.println("No connection :( " + host + " " + port);
                			//e.printStackTrace();
                			};
                        
                    }
                    ((DefaultTreeModel)frame.getTree().getModel()).setRoot(root);
                    ((DefaultTreeModel)frame.getTree().getModel()).reload();
                    
                    
                    
                }
            }            
        };
        load.putValue(Action.SMALL_ICON, new ImageIcon(MainFrame.class.getResource("icons/load16.png")));
        load.putValue(Action.NAME, "Charger");
        load.putValue(Action.SHORT_DESCRIPTION,"Charger une configuration");
        
        refresh = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
                ((DefaultTreeModel)frame.getTree().getModel()).reload();
            }            
        };
        refresh.putValue(Action.SMALL_ICON, new ImageIcon(MainFrame.class.getResource("icons/refresh16.png")));
        refresh.putValue(Action.NAME, "Rafraîchir");
        refresh.putValue(Action.SHORT_DESCRIPTION,"Rafraîchir");
        
        prop = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
                DNDTree tree = frame.getTree();
                
                NamingContextTreeNode node = (NamingContextTreeNode)tree.getSelectedNode();
                MiscDialog.showCORBAProperties(frame, node);
            }            
        };
        prop.putValue(Action.SMALL_ICON, new ImageIcon(MainFrame.class.getResource("icons/prop16.gif")));
        prop.putValue(Action.NAME, "Propriétés");
        prop.putValue(Action.SHORT_DESCRIPTION,"Propriétés");
    	prop.setEnabled(false);

        option = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
            }            
        };
        option.putValue(Action.SMALL_ICON, new ImageIcon(MainFrame.class.getResource("icons/option16.gif")));
        option.putValue(Action.NAME, "Options");
        option.putValue(Action.SHORT_DESCRIPTION,"Options");
        
        help = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
                UIHelp.showHelp(frame);
            }            
        };
        help.putValue(Action.SMALL_ICON, new ImageIcon(MainFrame.class.getResource("icons/help16.gif")));
        help.putValue(Action.NAME, "Aide");
        help.putValue(Action.SHORT_DESCRIPTION,"Aide");
        
        about = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
                AboutDialog d = new AboutDialog(frame);
                d.setModal(true);
                Dimension dlgSize = d.getPreferredSize();
                Dimension frmSize = frame.getSize();
                Point loc = frame.getLocation();
                d.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
                
                d.setVisible(true);                
            }            
        };
        about.putValue(Action.SMALL_ICON, new ImageIcon(MainFrame.class.getResource("icons/logoc16.png")));
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
        quit.putValue(Action.SMALL_ICON, new ImageIcon(MainFrame.class.getResource("icons/quit16.png")));
        quit.putValue(Action.NAME, "Quitter");
        quit.putValue(Action.SHORT_DESCRIPTION,"Quitter NSLookUP");
        
    }

    /**
     * 
     * Contructs all the contextual actions.
     *
     *
     */
    private void initActions(){
        addNC = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
            	String nom = MiscDialog.showNCInputDialog(frame);
            	if(nom == null)
                    return;
            	NamingContextTreeNode n = (NamingContextTreeNode)(frame.getTree().getSelectedNode());
            	NamingContext rootContext = (NamingContext)n.getNodeObject();
            	
            	
            	NameComponent[] contextName = new NameComponent[1];
            	contextName[0] = new NameComponent(nom,"");
    	        NamingContext newContext = rootContext.new_context();
    	        try {
                    rootContext.rebind_context(contextName,newContext);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame,"Création du naming context "+ nom + " impossible","Erreur!",JOptionPane.ERROR_MESSAGE);
                }
            	((DefaultTreeModel)(frame.getTree().getModel())).reload();
            }            
        };
        addNC.putValue(Action.SMALL_ICON, new ImageIcon(MainFrame.class.getResource("icons/addnc16.png")));
        addNC.putValue(Action.NAME, "Ajouter un NC");
        addNC.putValue(Action.SHORT_DESCRIPTION,"Ajouter un Contexte de Nommage");
        addNC.setEnabled(false);

            
        remNC = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
                NamingContextTreeNode n = (NamingContextTreeNode)(frame.getTree().getSelectedNode());
            	NamingContext rootContext = (NamingContext)n.getParentContext();
            	try {
                    rootContext.unbind(n.getBinding().binding_name);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame,"Suppression du naming context "+ n.getBinding().binding_name[0].id+ " impossible","Erreur!",JOptionPane.ERROR_MESSAGE);
                }   	   
                ((DefaultTreeModel)(frame.getTree().getModel())).reload();
            }            
        };
        remNC.putValue(Action.SMALL_ICON, new ImageIcon(MainFrame.class.getResource("icons/remnc16.png")));
        remNC.putValue(Action.NAME, "Retirer un NC");
        remNC.putValue(Action.SHORT_DESCRIPTION,"Retirer un Contexte de Nommage");
        remNC.setEnabled(false);
    
        addOBJ = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
                NamingContextTreeNode n = (NamingContextTreeNode)(frame.getTree().getSelectedNode());
                NamingContext rootContext = (NamingContext)n.getNodeObject();
                String IOR=JOptionPane.showInputDialog("Veuillez entrer une IOR:");
                
                if(IOR == null)
                    return;
                
                String nom=JOptionPane.showInputDialog("Veuillez entrer un nom:");
                
                if(nom == null)
                    return;
                
                try {
                String[] args = {"-ORBInitialPort",n.getPort(),"-ORBInitialHost",n.getHost()}; 
        		ORB orb = ORB.init(args, null);
                Object o = orb.string_to_object(IOR);
                NameComponent[] contextName = new NameComponent[1];
            	contextName[0] = new NameComponent(nom,"");
                
                    rootContext.bind(contextName,(org.omg.CORBA.Object)o);
                } catch (Throwable e) {
                    JOptionPane.showMessageDialog(frame,"Insertion de l'objet "+nom+ " impossible","Erreur!",JOptionPane.ERROR_MESSAGE);
                }  
                ((DefaultTreeModel)(frame.getTree().getModel())).reload();
                
            }            
        };
        addOBJ.putValue(Action.SMALL_ICON, new ImageIcon(MainFrame.class.getResource("icons/addobj16.png")));
        addOBJ.putValue(Action.NAME, "Ajouter un Obj.");
        addOBJ.putValue(Action.SHORT_DESCRIPTION,"Ajouter un Objet CORBA");
        addOBJ.setEnabled(false);
        
        remOBJ = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
                NamingContextTreeNode n = (NamingContextTreeNode)(frame.getTree().getSelectedNode());
            	NamingContext rootContext = (NamingContext)n.getParentContext();
            	try {
                    rootContext.unbind(n.getBinding().binding_name);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame,"Suppression de l'objet "+ n.getBinding().binding_name[0].id+ " impossible","Erreur!",JOptionPane.ERROR_MESSAGE);
                }   	   
                ((DefaultTreeModel)(frame.getTree().getModel())).reload();                                
            }            
        };
        remOBJ.putValue(Action.SMALL_ICON, new ImageIcon(MainFrame.class.getResource("icons/remobj16.png")));
        remOBJ.putValue(Action.NAME, "Retirer un Obj.");
        remOBJ.putValue(Action.SHORT_DESCRIPTION,"Retirer un Objet CORBA");
        remOBJ.setEnabled(false);
            
        addNS = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
            	NamingContextTreeNode root = (NamingContextTreeNode)frame.getTree().getModel().getRoot();
                MiscDialog.showAddNS(frame,root);
                ((DefaultTreeModel)(frame.getTree().getModel())).reload();
            }            
        };
        addNS.putValue(Action.SMALL_ICON, new ImageIcon(MainFrame.class.getResource("icons/addorb16.png")));
        addNS.putValue(Action.NAME, "Ajouter un NS");
        addNS.putValue(Action.SHORT_DESCRIPTION,"Ajouter un Name Service");
        addNS.setEnabled(true);
        
        remNS = new AbstractAction(){
            public void actionPerformed(ActionEvent arg0) {
                NamingContextTreeNode n = (NamingContextTreeNode)(frame.getTree().getSelectedNode());
                n.removeFromParent();
                ((DefaultTreeModel)(frame.getTree().getModel())).reload();
            }            
        };
        remNS.putValue(Action.SMALL_ICON, new ImageIcon(MainFrame.class.getResource("icons/remorb16.png")));
        remNS.putValue(Action.NAME, "Retirer un NS");
        remNS.putValue(Action.SHORT_DESCRIPTION,"Retirer un Name Service");
        remNS.setEnabled(false);
            
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
    
    
}
