/*
 * Created on 6 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.easytime.richclient.frontoffice.mainframe;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Jo
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RcMenuBar extends JMenuBar {

	public RcMenuBar(){
		this.add(this.createFichierMenu());
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
		
		JMenuItem layout = new JMenuItem("Mise en page");
		fichierMenu.add(layout);
		
		JMenuItem print = new JMenuItem("Imprimer");
		fichierMenu.add(print);
		
		JMenuItem export = new JMenuItem("Exporter");
		fichierMenu.add(export);
		
		JMenuItem mail = new JMenuItem("Mail");
		fichierMenu.add(mail);
		
		JMenuItem close = new JMenuItem("Fermer");
		fichierMenu.add(layout);
		
		JMenuItem logout = new JMenuItem("Se deconnecter");
		fichierMenu.add(logout);
		
		JMenuItem quit = new JMenuItem("Quitter");
		fichierMenu.add(quit);
		
		return fichierMenu;
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Easytime");
		
		frame.setJMenuBar(new RcMenuBar());
		
		frame.setSize(800, 600);
		frame.setVisible(true);

	}
}
