/* 
 * Project easytimeUI
 * Export.java - package fabe;
 * Creator: Administrateur
 * Created on 7 janv. 2005 21:53:44
 *
 * Person in charge: fgarac
 */
package fr.umlv.nslookup.UI;

import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.umlv.nslookup.NamingContextTreeNode;




/**
 * @author fgarac
 *
 * Class responsible for displaying the user interface of export option
 *
 */
public class MiscDialog{
    
      public static String showIORInputDialog(Frame frame){
          return JOptionPane.showInputDialog(frame, "Veuillez L'IOR :");
      }
    	
      private static String getPath(NamingContextTreeNode node){
          String path = "";
          NamingContextTreeNode tmp = node;
          while(tmp.getType() != NamingContextTreeNode.TYPE_NS){
              switch(tmp.getType()){
            	case 0 : path = "$>"+path;break;
              	case 1 : path = "("+tmp+")>"+path;break;
              	case 2 : path = "["+tmp+"]>"+path;break;
              	case 3 : path = tmp+path;break;
              }
              tmp = (NamingContextTreeNode)tmp.getParent();
          }
          return path;
      }
      
      public static void showCORBAProperties(Frame frame,NamingContextTreeNode node){
          JPanel panel = new JPanel();
          final JLabel name = new JLabel("Nom :"); 
          final JLabel type = new JLabel("Type :"); 
          final JLabel address = new JLabel("adresse réseau :"); 
          final JLabel port = new JLabel("Port :"); 
          final JLabel path = new JLabel("Chemin :"); 
          final JLabel IOR = new JLabel("IOR :"); 
          
          
          
          switch(node.getType()){
        	case 1 : {		// ORB/NS case 
          	    panel.setLayout(new GridLayout(6, 2));
          	    panel.add(name);
          	    panel.add(new JLabel(node.toString()));
          	    panel.add(type);
          	    panel.add(new JLabel("ORB/Naming Service"));
          	    panel.add(path);
          	    panel.add(new JLabel(getPath(node)));
        	    panel.add(address);
          	    panel.add(new JLabel("localhost"));
          	    panel.add(port);
          	    panel.add(new JLabel("1234"));
          	    panel.add(IOR);
          	    panel.add(new JLabel("qsdfqsdf563fsdgfgsdf425gf4gSDFG"));
          	    break;
          	}
          	case 2 : {		// NC case
          	    panel.setLayout(new GridLayout(4, 2));
          	    panel.add(name);
          	    panel.add(new JLabel(node.toString()));
          	    panel.add(type);
          	    panel.add(new JLabel("Naming Context"));
          	    panel.add(path);
          	    panel.add(new JLabel(getPath(node)));
        	    panel.add(IOR);
          	    panel.add(new JLabel("qsdfqsdfqsdfqsdf563fsdgfgsdf425gf4gSDFG"));
          	    break;
          	}
          	case 3 : {		// CORBA OBJECT case
          	    panel.setLayout(new GridLayout(4, 2));
          	    panel.add(name);
          	    panel.add(new JLabel(node.toString()));
          	    panel.add(type);
          	    panel.add(new JLabel("CORBA object"));
          	    panel.add(path);
          	    panel.add(new JLabel(getPath(node)));
        	    panel.add(IOR);
          	    panel.add(new JLabel("qsdfqsdfqsdf2345245qsdf563fsdgfgsdf425gf4gSDFG"));
          	    break;
          	}
          }
          
          JOptionPane.showMessageDialog(frame, panel, "Propriétés", JOptionPane.OK_OPTION);
      }
      
    	public static void main(String[] args) {
            JFrame frame = new JFrame();
            frame.setSize(1000, 600);
            //PropertyDialog.
            
            
            JTextField text = new JTextField();
            Object[] tab= {"Ajouter IOR", text};
            JOptionPane optionPane = new JOptionPane(tab,
                    JOptionPane.QUESTION_MESSAGE,
                    JOptionPane.YES_NO_OPTION
                   );
            //System.out.println(inputValue);
            JOptionPane.showMessageDialog(frame, tab);
        }
}
