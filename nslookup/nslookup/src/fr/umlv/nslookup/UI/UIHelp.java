/* 
 * Project easytime
 * UIHelp.java - package fr.umlv.easytime.richclient.frontoffice.resource;
 * Creator: Mat
 * Created on 29 janv. 2005 23:56:53
 *
 * Person in charge: Mat
 */
package fr.umlv.nslookup.UI;

import java.awt.Color;
import java.awt.Container;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * @author Mat
 *
 * This class provides a static method responsible for showing the online help (made of HTML files)
 *
 */
public class UIHelp {
    
    
    /**
     * Opns the help window
     *
     * @param parent the parent frame
     */
    public static void showHelp(JFrame parent){
        
        JFrame f = new JFrame("Aide");
        f.setSize((int)(parent.getSize().getWidth()*0.75),(int)(parent.getSize().getHeight()*0.75));
        int x = (parent.getWidth()-f.getWidth())/2;
        int y = (parent.getHeight()-f.getHeight())/2;
        x += parent.getLocation().getX();
        y += parent.getLocation().getY();
        f.setLocation(x,y);
        
        ImageIcon icon = new ImageIcon(MainFrame.class.getResource("icons/logocarre.png"));
        f.setIconImage(icon.getImage());
        
        Container contentPane = f.getContentPane();

        final JEditorPane jeditorpane = new JEditorPane();
        jeditorpane.setEditable(false);
        
        try {

            jeditorpane.setPage(MainFrame.class.getResource("help/index.html"));
        }
        catch(IOException e) {}

        jeditorpane.addHyperlinkListener(new HyperlinkListener(){
            public void hyperlinkUpdate(HyperlinkEvent e)
            {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
					 
					 
					 try {
                    jeditorpane.setPage(e.getURL());
                }
                catch(IOException e2) {}
            }

        });
	     
        contentPane.add(new JScrollPane(jeditorpane),"Center");
        
        f.setBackground(Color.white);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        
        
        
    }
    
    
    

}
