/* 
 * Project nslookup
 * NSLUPopUpMenu.java - package fr.umlv.nslookup.UI;
 * Creator: Jo
 * Created on 18 févr. 2005 16:51:33
 *
 * Person in charge: Jo
 */
package fr.umlv.nslookup.UI;

import javax.swing.JPopupMenu;

import fr.umlv.nslookup.UI.actions.ActionContainer;

/**
 * @author Jo
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class NSLUPopUpMenu extends JPopupMenu {

    public NSLUPopUpMenu(){
        add(ActionContainer.addORB);
        add(ActionContainer.remORB);
        add(ActionContainer.addNC);
        add(ActionContainer.remNC);
        add(ActionContainer.addOBJ);
        add(ActionContainer.remOBJ);
        add(ActionContainer.refresh);
        add(ActionContainer.prop);
        
    }
    
}
