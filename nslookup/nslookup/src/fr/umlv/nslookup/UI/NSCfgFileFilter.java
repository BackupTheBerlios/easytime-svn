
package fr.umlv.nslookup.UI;

import java.io.File;

import javax.swing.filechooser.FileFilter;



/**
 * @author jvaldes
 *
 * Filter used by FileChooser to see only .cfg files.
 *
 */
public class NSCfgFileFilter extends FileFilter {

    /* (non-Javadoc)
     * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
     */
    public boolean accept(File f) {
        return hasGoodExtension(f) || f.isDirectory();
    }

    private boolean hasGoodExtension(File f){
        String name = f.getName();
        if(name.length()<5) return false;
        String tmp = name.substring((name.length()-4), (name.length()));
        return (tmp.equals(".cfg"));
    }
    
    /* (non-Javadoc)
     * @see javax.swing.filechooser.FileFilter#getDescription()
     */
    public String getDescription() {
        return "Fichier de configuration NS - .cfg";
    }

}
