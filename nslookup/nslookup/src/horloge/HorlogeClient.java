package horloge;

import java.io.*;
import org.omg.CORBA.*;

import td1.*;

public class HorlogeClient {

  public static void main(String[] args) throws IOException {
    // Initialisation de l'ORB
    ORB orb = ORB.init(args, null);

    // Récupération de la référence du servant
    BufferedReader fileReader = new BufferedReader(new FileReader("ObjectRef"));
    String stringIOR = fileReader.readLine();
    fileReader.close();

    // Création, à partir de la référence du servant, d'un proxy local
    Horloge proxyHorloge = HorlogeHelper
        .narrow(orb.string_to_object(stringIOR));

    // Invocation d'une méthode distante
    System.out.println("Il est : " + proxyHorloge.getTime() + " à " + proxyHorloge.localite());
  }
}