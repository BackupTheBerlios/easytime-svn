/* 
 * Project NSLookUPUI
 * NSLUToolBar.java - package UI;
 * Creator: Jo
 * Created on 9 févr. 2005 16:19:30
 *
 * Person in charge: Jo
 */
package fr.umlv.nslookup.UI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import fr.umlv.nslookup.UI.actions.ActionContainer;


/**
 * @author Jo
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class NSLUToolBar extends JToolBar {

	private JButton addORBButton=new JButton(ActionContainer.addORB);
	private JButton remORBButton=new JButton(ActionContainer.remORB);
	private JButton addNCButton=new JButton(ActionContainer.addNC);
	private JButton remNCButton=new JButton(ActionContainer.remNC);
	private JButton addOBJButton=new JButton(ActionContainer.addOBJ);
	private JButton remOBJButton=new JButton(ActionContainer.addOBJ);
	private JButton propButton=new JButton(ActionContainer.prop);
	private JButton optionButton=new JButton(ActionContainer.option);
	private JButton helpButton=new JButton(ActionContainer.help);
	private JButton aboutButton=new JButton(ActionContainer.about);
	private JButton quitButton=new JButton(ActionContainer.quit);
   
    public NSLUToolBar(){
    	super();
    	
    	add(addORBButton);
    	add(remORBButton);
    	add(addNCButton);
    	add(remNCButton);
    	add(addOBJButton);
    	add(remOBJButton);
    	add(propButton);
    	add(optionButton);
    	add(helpButton);
    	add(aboutButton);
    	add(quitButton);
    	formatButtons();

		formatStaticButtons();
		
		setFloatable(false);
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
		formatButtons();
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
		
		formatStaticButtons();
	}
	
	
	private void formatButtons(){
		addORBButton.setText("");
		remORBButton.setText("");
		addNCButton.setText("");
		remNCButton.setText("");
		addOBJButton.setText("");
		remOBJButton.setText("");
		propButton.setText("");
		
		addORBButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/addorb24.png")));
		remORBButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/remorb24.png")));
		addNCButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/addnc24.png")));
		remNCButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/remnc24.png")));
		addOBJButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/addobj24.png")));
		remOBJButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/remobj24.png")));
		propButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/prop24.gif")));
	}

	private void formatStaticButtons(){
		optionButton.setText("");
		helpButton.setText("");
		aboutButton.setText("");
		quitButton.setText("");
		
		optionButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/option24.gif")));
		helpButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/help24.gif")));
		//aboutButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/about24.gif")));
		//quitButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/24.gif")));
		
	}
		
	
	
	
}
