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
        addNC = new DefaultAction(new ImageIcon(ActionContainer.class.getResource("../icons/addnc16.png")), "Ajouter NC", "Ajouter un Context de Nommage", false);
        remNC = new DefaultAction(new ImageIcon(DefaultActionFactory.class.getResource("../icons/remnc16.png")), "Retirer NC", "Retirer un Context de Nommage", false);
        addOBJ = new DefaultAction(new ImageIcon(DefaultActionFactory.class.getResource("../icons/addobj16.png")), "Ajouter IOR", "Ajouter un Objet CORBA", false);
        remOBJ = new DefaultAction(new ImageIcon(DefaultActionFactory.class.getResource("../icons/addobj16.png")), "Retirer IOR", "Retirer un Objet CORBA", false);
        addORB = new DefaultAction(new ImageIcon(DefaultActionFactory.class.getResource("../icons/addorb16.png")), "Ajouter ORB", "Ajouter un ORB", false);
        remORB = new DefaultAction(new ImageIcon(DefaultActionFactory.class.getResource("../icons/addorb16.png")), "Retirer ORB", "Retirer un ORB", false);
        
    }
    
    public final static Action addNC;
    public final static Action remNC;
    public final static Action addOBJ;
    public final static Action remOBJ;
    public final static Action addORB;
    public final static Action remORB;
    
    
    private static class DefaultAction extends AbstractAction{

        public DefaultAction(ImageIcon icon, String name, String tooltip, boolean enabled){
            if(icon!=null) putValue(Action.SMALL_ICON, icon);
            putValue(Action.NAME, name);
            putValue(Action.SHORT_DESCRIPTION, 	tooltip);
            setEnabled(enabled);
        }
        
       public void actionPerformed(ActionEvent arg0) {}        
    }
    
    
}
