/* 
 * Project easytime
 * ChoosePlaning.java - package fr.umlv.easytime.richclient;
 * Creator: Administrateur
 * Created on 6 janv. 2005 10:55:01
 *
 * Person in charge: Administrateur
 */
package fr.umlv.easytime.richclient;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import fr.umlv.easytime.resource.listing.ResourceListModels;

/**
 * @author Administrateur
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class ChoosePlanning {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Easytime");
        
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Sélectionnez la promotion pour laquelle vous souhaitez ouvrir le planning :");
        
        ResourceListModels model = new ResourceListModels();
        
        JList listpromo = new JList(model);
       
        
        panel.add(label);
        
        frame.add(panel);
        frame.setSize(800, 600);
		frame.setVisible(true);
    }
}
