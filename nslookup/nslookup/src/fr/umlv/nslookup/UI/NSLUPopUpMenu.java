
package fr.umlv.nslookup.UI;

import javax.swing.JPopupMenu;

import fr.umlv.nslookup.UI.actions.ActionContainer;

/**
 * @author jvaldes
 *
 * Popup menu containing the CORBA Object manipulation actions.
 * It's used into the JTree.
 *
 */
public class NSLUPopUpMenu extends JPopupMenu {

    
    private static final long serialVersionUID = 3257283651782849076L;

    public NSLUPopUpMenu(){
        add(ActionContainer.addNS);
        add(ActionContainer.remNS);
        add(ActionContainer.addNC);
        add(ActionContainer.remNC);
        add(ActionContainer.addOBJ);
        add(ActionContainer.remOBJ);
        add(ActionContainer.refresh);
        add(ActionContainer.prop);
        
    }
    
}
