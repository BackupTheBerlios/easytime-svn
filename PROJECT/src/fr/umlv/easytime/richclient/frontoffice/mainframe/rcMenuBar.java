/*
 * Created on 6 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.easytime.richclient.frontoffice.mainframe;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Jo
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class rcMenuBar extends JMenuBar {

	public rcMenuBar(){
		
	}
	
	public JMenu createFichierMenu(){
		JMenu fichierMenu = new JMenu("Fichier");
		
		JMenu visuMenu = new JMenu("Visualiser");
		fichierMenu.add(visuMenu);
		JMenuItem promo = new JMenuItem("Promotion");
		JMenuItem teacher = new JMenuItem("Professeur");
		JMenuItem room = new JMenuItem("Salle");
		JMenuItem device = new JMenuItem("Materiel");
		visuMenu.add(promo);
		visuMenu.add(teacher);
		visuMenu.add(room);
		visuMenu.add(device);
		
		
		
		return fichierMenu;
	}
}
