
package fr.umlv.nslookup.UI;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fr.umlv.nslookup.UI.actions.ActionContainer;

/**
 * @author jvaldes
 *
 * Menu bar filled with all the buttons needed by the application.
 *
 */
public class NSLUMenuBar extends JMenuBar {

	// Menu items
    private JMenuItem saveButton=new JMenuItem(ActionContainer.save);
    private JMenuItem loadButton=new JMenuItem(ActionContainer.load);
    private JMenuItem addNSButton=new JMenuItem(ActionContainer.addNS);
	private JMenuItem remNSButton=new JMenuItem(ActionContainer.remNS);
	private JMenuItem addNCButton=new JMenuItem(ActionContainer.addNC);
	private JMenuItem remNCButton=new JMenuItem(ActionContainer.remNC);
	private JMenuItem addOBJButton=new JMenuItem(ActionContainer.addOBJ);
	private JMenuItem remOBJButton=new JMenuItem(ActionContainer.remOBJ);
	private JMenuItem refreshButton=new JMenuItem(ActionContainer.refresh);
	private JMenuItem propButton=new JMenuItem(ActionContainer.prop);
	private JMenuItem helpButton=new JMenuItem(ActionContainer.help);
	private JMenuItem aboutButton=new JMenuItem(ActionContainer.about);
	private JMenuItem quitButton=new JMenuItem(ActionContainer.quit);

	/**
	 * 
	 * Creates a new NSLUMenuBar object.
	 *
	 */
	public NSLUMenuBar(){
		super();
		this.add(createFileMenu());
		this.add(createCORBAMenu());
		this.add(createMiscMenu());
	}
	
	/**
	 * 
	 * returns the file menu containg load and save actions and allowing to refresh the tree or to quit.
	 *
	 * @return
	 */
	private JMenu createFileMenu(){
		JMenu menu = new JMenu("Fichier");
		menu.add(saveButton);
		menu.add(loadButton);
		menu.add(refreshButton);
		menu.addSeparator();
		menu.add(quitButton);
		return menu;
	}
	
	/**
	 * 
	 * returns the CORBA menu containing all CORBA Object manipulation buttons
	 *
	 * @return
	 */
	private JMenu createCORBAMenu(){
		JMenu menu = new JMenu("CORBA");
		menu.add(addNSButton);
		menu.add(remNSButton);
		menu.addSeparator();
		menu.add(addNCButton);
		menu.add(remNCButton);
		menu.addSeparator();
		menu.add(addOBJButton);
		menu.add(remOBJButton);
		menu.addSeparator();
		menu.add(propButton);
		return menu;
	}
	
	/**
	 * 
	 * returns the miscalleous menu (help and about)
	 *
	 * @return
	 */
	private JMenu createMiscMenu(){
		JMenu menu = new JMenu("?");
		menu.add(helpButton);
		menu.add(aboutButton);
		return menu;
	}
	
	
	/**
	 * Load actions for each buttons from the Action Container.
	 * Method to call if the Action in the ActionContainer have changed.
	 * 
	 */
	public void loadActions(){
		addNSButton.setAction(ActionContainer.addOBJ);
		remNSButton.setAction(ActionContainer.remNS);
		addNCButton.setAction(ActionContainer.addNC);
		remNCButton.setAction(ActionContainer.remNC);
		addOBJButton.setAction(ActionContainer.addOBJ);
		remOBJButton.setAction(ActionContainer.remOBJ);
		propButton.setAction(ActionContainer.prop);
	}
	
	/**
	 * 
	 * Load static actions for each static buttons from the Action Container
	 * 
	 */
	private void loadStaticActions(){
		helpButton.setAction(ActionContainer.help);
		aboutButton.setAction(ActionContainer.about);
		quitButton.setAction(ActionContainer.quit);
	}
	
	
	
	
}
