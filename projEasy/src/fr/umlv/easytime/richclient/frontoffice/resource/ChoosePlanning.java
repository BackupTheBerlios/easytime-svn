/* 
 * Project easytime
 * ChoosePlaning.java - package fr.umlv.easytime.richclient;
 * Creator: Administrateur
 * Created on 6 janv. 2005 10:55:01
 *
 * Person in charge: fgarac
 */
package fr.umlv.easytime.richclient.frontoffice.resource;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * @author fgarac
 *
 * This class does the user interface in order to choose a planning for a stream.
 *
 */
public class ChoosePlanning extends JFrame{
    
    public ChoosePlanning(){
        this.setTitle("Easytime");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Sélectionnez la promotion pour laquelle vous souhaitez ouvrir le planning :");
        
        JList listpromo = new JList();
               
        panel.add(label);
        
        this.add(panel);
        //this.setSize(ContextualFrameSize.width, ContextualFrameSize.height);
        this.setSize(ContextualFrameSize.dimension);
		this.setVisible(true);
    }
}
