package fr.umlv.nslookup.UI.tree;
import org.omg.CORBA.ORB;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CosNaming.Binding;
import org.omg.CosNaming.BindingIteratorHolder;
import org.omg.CosNaming.BindingListHolder;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;


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

    private static ORB orb = null; 
    
	public static NamingContextTreeNode createORBTree(String host,String port, NamingContextTreeNode root) throws org.omg.CORBA.ORBPackage.InvalidName{
	    try{
	    String[] args = {"-ORBInitialPort",port,"-ORBInitialHost",host}; 
		orb = ORB.init(args, null);
		
		// 	Récupération de la référence du sevice de nommage
		ObjectImpl o = (ObjectImpl)orb.resolve_initial_references("NameService");
		
	    NamingContextExt namingContext = NamingContextExtHelper.narrow(o);
		NamingContextTreeNode ORBroot = new NamingContextTreeNode(host,port);
	    explore((NamingContext) namingContext,ORBroot );
	    root.add(ORBroot);
	    }catch(org.omg.CORBA.SystemException se) 
	    { 
	    	//se.printStackTrace();
		    throw new org.omg.CORBA.ORBPackage.InvalidName();
		}
	    catch(Throwable e) 
	    { 
		    throw new org.omg.CORBA.ORBPackage.InvalidName();
		}
	    ;
	    
	    return root;
	}
	
private static void explore(NamingContext context, NamingContextTreeNode node) throws org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed {
    
    BindingListHolder listHolder = new BindingListHolder(); 
    BindingIteratorHolder iteratorHolder = new BindingIteratorHolder();
    context.list(10,listHolder,iteratorHolder);
    
    
    
    //System.out.println(iteratorHolder);
    //System.out.println(listHolder.value.length);
    
    Binding bindings[];
    
    
    do {
        bindings = listHolder.value;
        //System.out.println("Passage while ");
      for (int i=0;i<bindings.length;i++) {
      	Binding binding = bindings[i];
      	//System.out.println(i+" binding " + binding);
      	NamingContextTreeNode newSon = new NamingContextTreeNode(binding);
      	
      	node.add(newSon );
                  
        if (newSon.getType()== NamingContextTreeNode.TYPE_CONTEXT ) {
            //System.out.println("nouveau contexte");
          NamingContext newContext = 
            NamingContextHelper.narrow(context.resolve(binding.binding_name));
          	explore(newContext, newSon);
         
          }
      }
      } while((iteratorHolder.value != null)&&(iteratorHolder.value.next_n(10,listHolder)));
      
      
      
    } 
         
    
   
    
  
	
}
