/* 
 * Project easytimeUI
 * Export.java - package fabe;
 * Creator: Administrateur
 * Created on 7 janv. 2005 21:53:44
 *
 * Person in charge: fgarac
 */
package fr.umlv.nslookup.UI;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CORBA.ORBPackage.InvalidName;

import fr.umlv.nslookup.NamingContextTreeNode;
import fr.umlv.nslookup.TreeFactory;




/**
 * @author fgarac
 *
 * Class responsible for displaying the user interface of export option
 *
 */
public class MiscDialog{
    
	public static String showIORInputDialog(Frame frame){
        return JOptionPane.showInputDialog(frame, "Veuillez saisir l'IOR :");
    }
  	
	public static String showNCInputDialog(Frame frame){
        return JOptionPane.showInputDialog(frame, "Veuillez saisir le nom du contexte de nommage à créer :");
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
      
      public static void showAddORB(Frame frame,NamingContextTreeNode root){
      	JPanel panel = new JPanel(new BorderLayout());
        JPanel fieldPanel = new JPanel();
        JPanel valuePanel = new JPanel();
        panel.add(new JLabel("  "), BorderLayout.CENTER);
        panel.add(fieldPanel, BorderLayout.WEST);
        panel.add(valuePanel, BorderLayout.EAST);
        final JLabel host = new JLabel("Host :"); 
        final JLabel port = new JLabel("Port :");
        fieldPanel.setLayout(new GridLayout(2, 1));
	    valuePanel.setLayout(new GridLayout(2, 1));
  	    fieldPanel.add(host);
  	    JTextField hostField = new JTextField("127.0.0.1"); 
  	    valuePanel.add(hostField);
  	    fieldPanel.add(port);
  	    JTextField portField = new JTextField("1234");
  	    valuePanel.add(portField);
  	    int res = JOptionPane.showConfirmDialog(frame, panel, "Ajouter un ORB",JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
  	    if((res == JOptionPane.OK_OPTION)&&(! hostField.getText().equals("")) && (! portField.getText().equals("")))
			try {
				TreeFactory.createORBTree(hostField.getText(),portField.getText(),root);
				
			} catch (InvalidName e) {
				JOptionPane.showMessageDialog(frame,"Connexion impossible à " + hostField.getText() + ":" + portField.getText(),"Erreur!",JOptionPane.ERROR_MESSAGE);
			}
  	    
      
      }
      
      public static void showCORBAProperties(Frame frame,NamingContextTreeNode node){
          JPanel panel = new JPanel(new BorderLayout());
          JPanel fieldPanel = new JPanel();
          JPanel valuePanel = new JPanel();
          panel.add(new JLabel("  "), BorderLayout.CENTER);
          panel.add(fieldPanel, BorderLayout.WEST);
          panel.add(valuePanel, BorderLayout.EAST);
          final JLabel name = new JLabel("Nom :"); 
          final JLabel type = new JLabel("Type :"); 
          final JLabel address = new JLabel("Adresse réseau :"); 
          final JLabel port = new JLabel("Port :"); 
          final JLabel path = new JLabel("Chemin :"); 
          final JLabel IOR = new JLabel("IOR :"); 
          
          
          
          switch(node.getType()){
        	case 1 : {		// ORB/NS case 
          	    fieldPanel.setLayout(new GridLayout(6, 1));
        	    valuePanel.setLayout(new GridLayout(6, 1));
          	    fieldPanel.add(name);
          	    valuePanel.add(new JLabel(node.toString()));
          	    fieldPanel.add(type);
          	    valuePanel.add(new JLabel("ORB/Naming Service"));
          	    fieldPanel.add(path);
          	    valuePanel.add(new JLabel(getPath(node)));
          	    fieldPanel.add(address);
          	    valuePanel.add(new JLabel("localhost"));
          	    fieldPanel.add(port);
          	    valuePanel.add(new JLabel("1234"));
          	    fieldPanel.add(IOR);
          	    valuePanel.add(new JLabel(node.getNodeObject().toString()));
          	    break;
          	}
          	case 2 : {		// NC case
          	    
          	    fieldPanel.setLayout(new GridLayout(4, 1));
          	    valuePanel.setLayout(new GridLayout(4, 1));
        	    fieldPanel.add(name);
        	    valuePanel.add(new JLabel(node.toString()));
        	    fieldPanel.add(type);
        	    valuePanel.add(new JLabel("Naming Context"));
        	    fieldPanel.add(path);
        	    valuePanel.add(new JLabel(getPath(node)));
        	    fieldPanel.add(IOR);
        	    valuePanel.add(new JLabel(node.getNodeObject().toString()));
        	    break;
          	}
          	case 3 : {		// CORBA OBJECT case
          	    fieldPanel.setLayout(new GridLayout(4, 1));
          	    valuePanel.setLayout(new GridLayout(4, 1));
        	    fieldPanel.add(name);
        	    valuePanel.add(new JLabel(node.toString()));
        	    fieldPanel.add(type);
        	    valuePanel.add(new JLabel("CORBA object"));
        	    fieldPanel.add(path);
        	    valuePanel.add(new JLabel(getPath(node)));
        	    fieldPanel.add(IOR);
        	    valuePanel.add(new JLabel(node.getNodeObject().toString()));
          	    break;
          	}
          }
          
          JOptionPane.showMessageDialog(frame, panel, "Propriétés", JOptionPane.INFORMATION_MESSAGE);
          
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
