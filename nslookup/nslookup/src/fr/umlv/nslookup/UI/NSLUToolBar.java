/* 
 * Project NSLookUPUI
 * NSLUToolBar.java - package UI;
 * Creator: Jo
 * Created on 9 f�vr. 2005 16:19:30
 *
 * Person in charge: Jo
 */
package fr.umlv.nslookup.UI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import fr.umlv.nslookup.UI.actions.ActionContainer;


/**
 * @author Jo
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class NSLUToolBar extends JToolBar {

    private JButton saveButton=new JButton(ActionContainer.save);
    private JButton loadButton=new JButton(ActionContainer.load);
    private JButton addORBButton=new JButton(ActionContainer.addORB);
	private JButton remORBButton=new JButton(ActionContainer.remORB);
	private JButton addNCButton=new JButton(ActionContainer.addNC);
	private JButton remNCButton=new JButton(ActionContainer.remNC);
	private JButton addOBJButton=new JButton(ActionContainer.addOBJ);
	private JButton remOBJButton=new JButton(ActionContainer.remOBJ);
	private JButton refreshButton=new JButton(ActionContainer.refresh);
	private JButton propButton=new JButton(ActionContainer.prop);
	private JButton optionButton=new JButton(ActionContainer.option);
	private JButton helpButton=new JButton(ActionContainer.help);
	
    public NSLUToolBar(){
    	super();
    	
    	add(saveButton);
    	add(loadButton);
    	add(addORBButton);
    	add(remORBButton);
    	add(addNCButton);
    	add(remNCButton);
    	add(addOBJButton);
    	add(remOBJButton);
    	add(refreshButton);
    	add(propButton);
    	//add(optionButton);
    	add(helpButton);
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
	    saveButton.setText("");
	    loadButton.setText("");
	    optionButton.setText("");
	    refreshButton.setText("");
	    helpButton.setText("");
		
		saveButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/save24.png")));
		loadButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/load24.png")));
		optionButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/option24.gif")));
		refreshButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/refresh24.png")));
		helpButton.setIcon(new ImageIcon(NSLUToolBar.class.getResource("icons/help24.gif")));
		
	}
		
	
	
	
}
