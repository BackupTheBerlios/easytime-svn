
package fr.umlv.nslookup.UI;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CORBA.portable.ObjectImpl;

import fr.umlv.nslookup.UI.tree.NamingContextTreeNode;
import fr.umlv.nslookup.UI.tree.TreeFactory;




/**
 * @author jvaldes
 *
 * Class providing static methods to display information et input dialog boxes. 
 *
 */
public class MiscDialog{
    
	/**
	 * 
	 * Show dialog Box asking to type the IOR of the new object to Bind.
	 *
	 * @param frame parent frame
	 * @return
	 */
	public static String showIORInputDialog(Frame frame){
        return JOptionPane.showInputDialog(frame, "Veuillez saisir l'IOR :");
    }
  	
	/**
	 * 
	 * Show dialog Box asking to type the binding name of the new NamingContext to Bind.
	 *
	 * @param frame parent frame
	 * @return
	 */
	public static String showNCInputDialog(Frame frame){
        return JOptionPane.showInputDialog(frame, "Veuillez saisir le nom du contexte de nommage à créer :");
    }
  	
	/**
	 * 
	 * Private method return a string describing the path to join a NameService, a CORBA Object or a NamingContext.
	 * the NameServices are represented by : "(<address> <port>)"
	 * the Naming Contextes are represented by : "[<binding name>]"
	 * the CORBA Objects are represented by : "<binding name>"
	 *
	 * @param node 
	 * @return
	 */
    private static String getPath(NamingContextTreeNode node){
          String path = "";
          NamingContextTreeNode tmp = node;
          while(tmp != null){
              switch(tmp.getType()){
            	case NamingContextTreeNode.TYPE_NS : path = "("+tmp+")>"+path;break;
              	case NamingContextTreeNode.TYPE_CONTEXT : path = "["+tmp+"]>"+path;break;
              	case NamingContextTreeNode.TYPE_OBJECT : path = tmp+path;break;
              }
              tmp = (NamingContextTreeNode)tmp.getParent();
          }
          return path;
      }
      
    /**
     * 
     * Show dialog Box asking the address (ip or name) and the port of the Name Service to connect.
     *
     * @param frame parent frame
     * @param root root TreeNode
     */
      public static void showAddNS(Frame frame,NamingContextTreeNode root){
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
  	    int res = JOptionPane.showConfirmDialog(frame, panel, "Ajouter un NS",JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
  	    if((res == JOptionPane.OK_OPTION)&&(! hostField.getText().equals("")) && (! portField.getText().equals("")))
			try {
				TreeFactory.createORBTree(hostField.getText(),portField.getText(),root);
				
			} catch (InvalidName e) {
				JOptionPane.showMessageDialog(frame,"Connexion impossible à " + hostField.getText() + ":" + portField.getText(),"Erreur!",JOptionPane.ERROR_MESSAGE);
			}
  	    
      
      }
      
      /**
       * 
       * return the IDL type of the Object binded on this node
       *
       * @param node
       * @return
       */
      private static String getIDLType(NamingContextTreeNode node){
          String type = ((ObjectImpl)node.getNodeObject())._ids()[0];
          type = type.substring(4, (type.length()-4));
          return type;
      }
      
      /**
       * 
       * Show dialog Box displaying all the available information of a Node (NS/NC/CORBA/Object)
       *
       * @param frame
       * @param node
       */
      public static void showCORBAProperties(Frame frame,NamingContextTreeNode node){
          JPanel panel = new JPanel(new BorderLayout());
          JPanel fieldPanel = new JPanel();
          JPanel valuePanel = new JPanel();
          panel.add(new JLabel("  "), BorderLayout.CENTER);
          panel.add(fieldPanel, BorderLayout.WEST);
          panel.add(valuePanel, BorderLayout.EAST);
          final JLabel name = new JLabel("Nom :"); 
          final JLabel type = new JLabel("Type :"); 
          final JLabel IDLtype = new JLabel("Type IDL :"); 
          final JLabel address = new JLabel("Adresse réseau :"); 
          final JLabel port = new JLabel("Port :"); 
          final JLabel path = new JLabel("Chemin :"); 
          final JLabel IOR = new JLabel("IOR :"); 
          
          final JTextField namet = new JTextField(30); 
          namet.setEditable(false);
          namet.setText(node.toString());
          
          final JTextField IDLtypet = new JTextField(30); 
          IDLtypet.setEditable(false);
          IDLtypet.setText(getIDLType(node));
          
          
          final JTextField orbTypet = new JTextField("Name Service"); 
          orbTypet.setEditable(false);
          final JTextField ncTypet = new JTextField("Naming Context"); 
          ncTypet.setEditable(false);
          final JTextField objtypet = new JTextField("CORBA object"); 
          objtypet.setEditable(false);
          
          final JTextField addresst = new JTextField(30); 
          addresst.setEditable(false);
          final JTextField portt = new JTextField(30); 
          portt.setEditable(false);
          final JTextField patht = new JTextField(30); 
          patht.setEditable(false);
          patht.setText(getPath(node));
          final JTextField iort = new JTextField(30); 
          iort.setEditable(false);
          
          
          
          switch(node.getType()){
        	case NamingContextTreeNode.TYPE_NS : {		// NS case 
          	    fieldPanel.setLayout(new GridLayout(7, 1));
        	    valuePanel.setLayout(new GridLayout(7, 1));
          	    fieldPanel.add(name);
          	    valuePanel.add(namet);
          	    fieldPanel.add(type);
          	    valuePanel.add(orbTypet);
          	    fieldPanel.add(IDLtype);
          	    valuePanel.add(IDLtypet);
          	    fieldPanel.add(path);
          	    valuePanel.add(patht);
          	    fieldPanel.add(address);
          	    addresst.setText(node.getHost());
          	    valuePanel.add(addresst);
          	    portt.setText(node.getPort());
          	    fieldPanel.add(port);
          	    valuePanel.add(portt);
          	    fieldPanel.add(IOR);
          	    iort.setText(node.getNodeObject().toString());
          	    valuePanel.add(iort);
          	    break;
          	}
          	case NamingContextTreeNode.TYPE_CONTEXT : {		// NC case
          	    
          	    fieldPanel.setLayout(new GridLayout(5, 1));
          	    valuePanel.setLayout(new GridLayout(5, 1));
        	    fieldPanel.add(name);
        	    valuePanel.add(namet);
          	    fieldPanel.add(type);
        	    valuePanel.add(ncTypet);
        	    fieldPanel.add(IDLtype);
          	    valuePanel.add(IDLtypet);
          	    fieldPanel.add(path);
        	    valuePanel.add(patht);
        	    fieldPanel.add(IOR);
        	    iort.setText(node.getNodeObject().toString());
          	    valuePanel.add(iort);
        	    break;
          	}
          	case NamingContextTreeNode.TYPE_OBJECT : {		// CORBA OBJECT case
          	    fieldPanel.setLayout(new GridLayout(5, 1));
          	    valuePanel.setLayout(new GridLayout(5, 1));
        	    fieldPanel.add(name);
        	    valuePanel.add(namet);
        	    fieldPanel.add(type);
        	    valuePanel.add(objtypet);
        	    fieldPanel.add(IDLtype);
          	    valuePanel.add(IDLtypet);
          	    fieldPanel.add(path);
        	    valuePanel.add(patht);
        	    fieldPanel.add(IOR);
        	    iort.setText(node.getNodeObject().toString());
          	    valuePanel.add(iort);
          	    break;
          	}
          }
          
          JOptionPane.showMessageDialog(frame, panel, "Propriétés", JOptionPane.INFORMATION_MESSAGE);
          
      }
      
    	
}
