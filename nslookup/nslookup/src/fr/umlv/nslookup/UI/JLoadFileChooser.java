/* 
 * Project nslookup
 * JLoadFileChooser.java - package fr.umlv.nslookup.UI;
 * Creator: Jo
 * Created on 15 févr. 2005 13:13:32
 *
 * Person in charge: Jo
 */
package fr.umlv.nslookup.UI;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * @author Jo
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class JLoadFileChooser extends JFileChooser {
    
    public JLoadFileChooser(){
        super();
    }
    
    
    public static void main(String[] args) {
        JFrame frame =  new JFrame();
        
        JFileChooser choice = new JFileChooser();
        /*choice.setDialogTitle("Choix du fichier de configuration");
        choice.setFileSelectionMode(JFileChooser.FILES_ONLY);
        choice.setFileFilter(new ORBCfgFileFilter());
        
        int rp = choice.showOpenDialog(frame);
        if (rp == JFileChooser.APPROVE_OPTION) {
            File file = choice.getSelectedFile();
            System.out.println(file);
        }
        */
        
        
        choice.setDialogTitle("Enregistrement de la configuration");
        choice.setFileSelectionMode(JFileChooser.FILES_ONLY);
        choice.setFileFilter(new ORBCfgFileFilter());
        
        int rp = choice.showSaveDialog(frame);
        if (rp == JFileChooser.APPROVE_OPTION) {
            File file = choice.getSelectedFile();
            System.out.println(file);
        }
    }
    
}
