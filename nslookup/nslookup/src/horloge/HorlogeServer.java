package horloge;

import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.*;
import java.io.*;

public class HorlogeServer {
  public static void main(String args[]) throws ServantAlreadyActive,
      InvalidName, ObjectNotActive, WrongPolicy, FileNotFoundException,
      AdapterInactive {

    //  Initialisation de l'ORB
    ORB orb = ORB.init(args, null);

    // Récupération de référence de l'adaptateur d'objets racine
    POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

    // Initialisation de l'objet servant
    HorlogeImpl horloge = new HorlogeImpl();

    // Enregistrement du servant
    byte[] servantId = rootPOA.activate_object(horloge);

    // Récupération de la référence du servant et écriture dans un fichier
    String reference = orb.object_to_string(rootPOA.id_to_reference(servantId));
    System.out.println(reference);
    PrintWriter file = new PrintWriter("ObjectRef");
    file.println(reference);
    file.close();

    // Activation des servants
    rootPOA.the_POAManager().activate();

    System.out.println("Server is ready");

    // Mise en attente des requètes
    orb.run();
  }
}