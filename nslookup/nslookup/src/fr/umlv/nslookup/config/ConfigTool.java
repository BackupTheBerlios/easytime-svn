
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
 * @author jvaldes
 *
 * Class providing method useful save or load configuration files. 
 *
 */
public class ConfigTool {
	
	/**
	 * 
	 * Read the config file and return all the NS Configuration in an Array.
	 *
	 * @param filePath
	 * @return
	 */
	public final static NSConfig[] loadConfig(String filePath){
	    
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
                     list.add(new NSConfig(tmp, st.nextToken()));
                 }
                 line = br.readLine();
             }
             
             NSConfig[] tab = new NSConfig[list.size()];
             int i=0;
             for (Iterator iter = list.iterator(); iter.hasNext();) {
                 NSConfig element = (NSConfig) iter.next();
                tab[i++] = element;
            }
             
             br.close();
             return tab;
	    } catch (IOException e) {
	        return null;
	    }
	    
	}
	
	
	/**
	 * 
	 * Write all the NS configurations (of the array) in the given file. 
	 *
	 * @param filePath
	 * @param orbTab
	 */
	public final static void saveConfig(String filePath, NSConfig[] orbTab){
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

	
	
	
}
