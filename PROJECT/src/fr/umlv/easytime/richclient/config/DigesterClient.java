/* 
 * Project easytime
 * DigesterClient.java - package fr.umlv.easytime.richclient.config;
 * Creator: kjason
 * Created on 6 janv. 2005 13:42:06
 *
 * Person in charge: kjason
 */
package fr.umlv.easytime.richclient.config;

import java.io.File;
import org.apache.commons.digester.Digester;

/**
 * @author kjason
 *
 * Class responsible for parsing XML config client file.
 *
 */
public class DigesterClient {

	public static void main(String args[]) {
		try {
		Digester aDigester = new Digester();
		aDigester.setValidating(false);
		
		aDigester.addObjectCreate( "configClient", ConfigClient.class );
		
		aDigester.addObjectCreate("configClient/server", Server.class);
		aDigester.addBeanPropertySetter("configClient/server/port", "port" );
		aDigester.addBeanPropertySetter("configClient/server/name", "name" );
		aDigester.addSetNext( "configClient/server", "setAServer" );

        File configClientFile = new File("configClient.xml");
        
		ConfigClient aConfigClient = (ConfigClient)aDigester.parse(configClientFile);
		System.out.println(aConfigClient.toString());
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
