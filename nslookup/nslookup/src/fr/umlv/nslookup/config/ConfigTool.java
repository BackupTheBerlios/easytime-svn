/* 
 * Project NSLookUPUI
 * ConfigTool.java - package config;
 * Creator: Administrateur
 * Created on 8 févr. 2005 00:44:18
 *
 * Person in charge: Administrateur
 */
package fr.umlv.nslookup.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;




/**
 * @author Administrateur
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class ConfigTool {
	
	
	final static ORBConfig[] loadConfig(String filePath){
	    
	    ArrayList list = new ArrayList();
	    BufferedReader br;
	    try {
             br = new BufferedReader(new FileReader(filePath));
        
             String line;
             String tmp;
             StringTokenizer st;

             
             line = br.readLine();
             
             while(line!= null){
                 if(line.charAt(0)!='#'){
                     st = new StringTokenizer(line, " ");
                     st.nextToken();
                     tmp = st.nextToken();
                     list.add(new ORBConfig(tmp, st.nextToken()));
                 }
                 line = br.readLine();
             }
             
             ORBConfig[] tab = new ORBConfig[list.size()];
             int i=0;
             for (Iterator iter = list.iterator(); iter.hasNext();) {
                 ORBConfig element = (ORBConfig) iter.next();
                tab[i++] = element;
            }
             
             br.close();
             return tab;
	    } catch (IOException e) {
	        return null;
	    }
	    
	}
	
	final static void saveConfig(String filePath, ORBConfig[] orbTab){
	    BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));

            bw.write("#orb: <port> <address>\n");

            for (int i = 0; i < orbTab.length; i++) {
                bw.write("orb: "+orbTab[i].getPort()+" "+orbTab[i].getAddress()+"\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	
	public static void main(String[] args) {
	    ORBConfig[] list = ConfigTool.loadConfig("configORB.cfg");
		System.out.println(list.length);
		for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
		
		ORBConfig[] list2 = new ORBConfig[5];
		list2[0] = new ORBConfig("5423", "192.0.0.5");
		list2[1] = new ORBConfig("8675", "192.0.0.76");
		list2[2] = new ORBConfig("5876", "192.0.0.53");
		list2[3] = new ORBConfig("1324", "192.0.0.25");
		list2[4] = new ORBConfig("9148", "192.0.0.54");
		
		ConfigTool.saveConfig("config2.cfg", list2);
	}
	
}
