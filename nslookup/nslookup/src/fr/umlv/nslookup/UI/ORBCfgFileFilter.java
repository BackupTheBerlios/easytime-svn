/* 
 * Project nslookup
 * ORBCfgFileFilter.java - package fr.umlv.nslookup.UI;
 * Creator: Jo
 * Created on 15 févr. 2005 13:37:14
 *
 * Person in charge: Jo
 */
package fr.umlv.nslookup.UI;

import java.io.File;

import javax.swing.filechooser.FileFilter;



/**
 * @author Jo
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class ORBCfgFileFilter extends FileFilter {

    /* (non-Javadoc)
     * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
     */
    public boolean accept(File f) {
        return hasGoodExtension(f);
    }

    private boolean hasGoodExtension(File f){
        String name = f.getName();
        if(name.length()<5) return false;
        String tmp = name.substring((name.length()-4), (name.length()));
        System.out.println(name+" - "+tmp);
        return (tmp.equals(".cfg"));
    }
    
    /* (non-Javadoc)
     * @see javax.swing.filechooser.FileFilter#getDescription()
     */
    public String getDescription() {
        return "Fichier de configuration ORB - .cfg";
    }

}
