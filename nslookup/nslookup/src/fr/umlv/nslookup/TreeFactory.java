package fr.umlv.nslookup;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import java.io.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;


/*
 * Created on 7 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author mloyen
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TreeFactory {

	public static void createTree(String host,String port, NamingContextTreeNode root) throws org.omg.CORBA.ORBPackage.InvalidName {
	
	    String[] args = {"-ORBInitialPort",port,"-ORBInitialHost",host}; 
		ORB orb = ORB.init(args, null);
		// 	R�cup�ration de la r�f�rence du sevice de nommage
		
	    NamingContextExt namingContext = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
	    
	    try{
	    explore((NamingContext) namingContext,root );
	    }catch(Exception e){e.printStackTrace();};
	    
	    
	}
	
private static void explore(NamingContext context, NamingContextTreeNode node) throws org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed {
    
    BindingListHolder listHolder = new BindingListHolder(); 
    BindingIteratorHolder iteratorHolder = new BindingIteratorHolder();
    context.list(10,listHolder,iteratorHolder);
    
    
    
    System.out.println(iteratorHolder);
    System.out.println(listHolder.value.length);
    
    Binding bindings[];
    
    
    do {
        bindings = listHolder.value;
        System.out.println("Passage while ");
      for (int i=0;i<bindings.length;i++) {
      	Binding binding = bindings[i];
      	System.out.println(i+" binding " + binding);
      	NamingContextTreeNode newSon = new NamingContextTreeNode(binding);
      	
      	node.add(newSon );
                  
        if (newSon.getType()== NamingContextTreeNode.TYPE_CONTEXT ) {
            System.out.println("nouveau contexte");
          NamingContext newContext = 
            NamingContextHelper.narrow(context.resolve(binding.binding_name));
          	explore(newContext, newSon);
         
          }
      }
      } while((iteratorHolder.value != null)&&(iteratorHolder.value.next_n(10,listHolder)));
      
      
      
    } 
         
    
   
    
  
	
}