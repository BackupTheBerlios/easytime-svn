package fr.umlv.nslookup;
import horloge.HorlogeImpl;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

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
public class TestNC {

	public static void main(String[] args) throws Exception{
		
		ORB orb = ORB.init(args, null);

	    // Récupération de référence de l'adaptateur d'objets racine
	    POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	    
//	  Récupération de la référence du sevice de nommage
	    NamingContextExt rootContext = 
	      NamingContextExtHelper.narrow(
	          orb.resolve_initial_references("NameService"));
	    
	    
	    NamingContext save = null;
	    
	    for(int i=0;i<5;i++) { 
	        NameComponent[] contextName = rootContext.to_name("Forum"+i);
	        NamingContext newContext = rootContext.new_context();
	        rootContext.rebind_context(contextName,newContext);
	        save = newContext;
	       //rootContext.rebind(contextName,forumRef1);
	      }
	      
	    
	      
	      
	      // Initialisation de l'objet servant
	      HorlogeImpl horloge = new HorlogeImpl();

	      // Enregistrement du servant
	      byte[] servantId = rootPOA.activate_object(horloge);


	      NameComponent[] contextName = rootContext.to_name("Horloge");
	      String reference = orb.object_to_string(rootPOA.id_to_reference(servantId));
	      org.omg.CORBA.Object ref = 
	          rootPOA.id_to_reference(servantId);
	      
	      save.rebind(contextName,ref);
	      rootContext.rebind(contextName,ref);
	      
	      
	      // Ajouter un nouveau contexte 
	      contextName = rootContext.to_name("CTX");
	      NamingContext newContext = rootContext.new_context();
	      rootContext.rebind_context(contextName,newContext);

	}
	
}
