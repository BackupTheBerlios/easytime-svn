/* 
 * Project NSLookUPUI
 * ActionFactory.java - package UI.actions;
 * Creator: Jo
 * Created on 9 févr. 2005 16:50:53
 *
 * Person in charge: Jo
 */
package fr.umlv.nslookup.UI.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

/**
 * @author Jo
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class DefaultActionFactory {

    static{
        addNC = new DefaultAction(new ImageIcon(ActionContainer.class.getResource("../icons/addnc16.png")), "Ajouter NC", "Ajouter un Context de Nommage");
        remNC = new DefaultAction(new ImageIcon(DefaultActionFactory.class.getResource("../icons/remnc16.png")), "Retirer NC", "Retirer un Context de Nommage");
        addOBJ = new DefaultAction(new ImageIcon(DefaultActionFactory.class.getResource("../icons/addobj16.png")), "Ajouter IOR", "Ajouter un Objet CORBA");
        remOBJ = new DefaultAction(new ImageIcon(DefaultActionFactory.class.getResource("../icons/addobj16.png")), "Retirer IOR", "Retirer un Objet CORBA");
        addORB = new DefaultAction(new ImageIcon(DefaultActionFactory.class.getResource("../icons/addorb16.png")), "Ajouter ORB", "Ajouter un ORB");
        remORB = new DefaultAction(new ImageIcon(DefaultActionFactory.class.getResource("../icons/addorb16.png")), "Retirer ORB", "Retirer un ORB");
        prop = new DefaultAction(new ImageIcon(DefaultActionFactory.class.getResource("../icons/prop16.gif")), "Propriétés", "Propriétés");
        option = new DefaultAction(new ImageIcon(DefaultActionFactory.class.getResource("../icons/option16.gif")), "Options", "Options");
        help = new DefaultAction(new ImageIcon(DefaultActionFactory.class.getResource("../icons/help16.gif")), "Aide", "Aide");
        about = new DefaultAction(new ImageIcon(DefaultActionFactory.class.getResource("../icons/addorb16.png")), "A propos", "A propos");
        quit = new DefaultAction(null, "Quitter", "Quitter");
    }
    
    public final static Action addNC;
    public final static Action remNC;
    public final static Action addOBJ;
    public final static Action remOBJ;
    public final static Action addORB;
    public final static Action remORB;
    public final static Action prop;
    public final static Action option;
    public final static Action help;
    public final static Action about;
    public final static Action quit;
    
    
    private static class DefaultAction extends AbstractAction{

        public DefaultAction(ImageIcon icon, String name, String tooltip){
            if(icon!=null) putValue(Action.SMALL_ICON, icon);
            putValue(Action.NAME, name);
            putValue(Action.SHORT_DESCRIPTION, 	tooltip);
            //setEnabled(false);
        }
        
       public void actionPerformed(ActionEvent arg0) {}        
    }
    
    
}
