/* 
 * Project NSLookUPUI
 * NSLUMenuBar.java - package UI;
 * Creator: Administrateur
 * Created on 9 févr. 2005 23:05:41
 *
 * Person in charge: Administrateur
 */
package fr.umlv.nslookup.UI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fr.umlv.nslookup.UI.actions.ActionContainer;

/**
 * @author Administrateur
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class NSLUMenuBar extends JMenuBar {

	private JMenuItem addORBButton=new JMenuItem(ActionContainer.addORB);
	private JMenuItem remORBButton=new JMenuItem(ActionContainer.remORB);
	private JMenuItem addNCButton=new JMenuItem(ActionContainer.addNC);
	private JMenuItem remNCButton=new JMenuItem(ActionContainer.remNC);
	private JMenuItem addOBJButton=new JMenuItem(ActionContainer.addOBJ);
	private JMenuItem remOBJButton=new JMenuItem(ActionContainer.addOBJ);
	private JMenuItem propButton=new JMenuItem(ActionContainer.prop);
	private JMenuItem optionButton=new JMenuItem(ActionContainer.option);
	private JMenuItem helpButton=new JMenuItem(ActionContainer.help);
	private JMenuItem aboutButton=new JMenuItem(ActionContainer.about);
	private JMenuItem quitButton=new JMenuItem(ActionContainer.quit);

	public NSLUMenuBar(){
		super();
		this.add(createFileMenu());
		this.add(createCORBAMenu());
		this.add(createMiscMenu());
	}
	
	public JMenu createFileMenu(){
		JMenu menu = new JMenu("Fichier");
		menu.add(optionButton);
		menu.addSeparator();
		menu.add(quitButton);
		return menu;
	}
	
	public JMenu createCORBAMenu(){
		JMenu menu = new JMenu("CORBA");
		menu.add(addORBButton);
		menu.add(remORBButton);
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
	
	public JMenu createMiscMenu(){
		JMenu menu = new JMenu("?");
		menu.add(helpButton);
		menu.add(aboutButton);
		return menu;
	}
	
	
	/**
	 * Load actions for each buttons from the Action Container
	 * 
	 */
	public void loadActions(){
		addORBButton.setAction(ActionContainer.addORB);
		remORBButton.setAction(ActionContainer.remORB);
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
		optionButton.setAction(ActionContainer.option);
		helpButton.setAction(ActionContainer.help);
		aboutButton.setAction(ActionContainer.about);
		quitButton.setAction(ActionContainer.quit);
	}
	
	
	
	
}
