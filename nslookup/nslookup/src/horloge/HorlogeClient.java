package horloge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.omg.CORBA.ORB;

import td1.Horloge;
import td1.HorlogeHelper;

public class HorlogeClient {

  public static void main(String[] args) throws IOException {
    // Initialisation de l'ORB
    ORB orb = ORB.init(args, null);

    // R�cup�ration de la r�f�rence du servant
    BufferedReader fileReader = new BufferedReader(new FileReader("ObjectRef"));
    String stringIOR = fileReader.readLine();
    fileReader.close();

    // Cr�ation, � partir de la r�f�rence du servant, d'un proxy local
    Horloge proxyHorloge = HorlogeHelper
        .narrow(orb.string_to_object(stringIOR));

    // Invocation d'une m�thode distante
    System.out.println("Il est : " + proxyHorloge.getTime() + " � " + proxyHorloge.localite());
  }
}