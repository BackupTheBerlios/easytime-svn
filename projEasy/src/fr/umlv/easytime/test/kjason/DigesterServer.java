/* 
 * Project easytime
 * DigesterServer.java - package fr.umlv.easytime.test.kjason;
 * Creator: kjason
 * Created on 6 janv. 2005 11:14:11
 *
 * Person in charge: kjason
 */
package fr.umlv.easytime.test.kjason;

import java.io.File;
import org.apache.commons.digester.*;

/**
 * @author kjason
 *
 * Class responsible for parsing XML config server file.
 *
 */
public class DigesterServer {
	
	public static void main(String args[]) {
		try {
		Digester aDigester = new Digester();
		aDigester.setValidating(false);
		
		aDigester.addObjectCreate( "configServer", ConfigServer.class );
		
		aDigester.addObjectCreate("configServer/database", Database.class);
		aDigester.addBeanPropertySetter("configServer/database/host", "host" );
		aDigester.addBeanPropertySetter("configServer/database/port", "port" );
		aDigester.addBeanPropertySetter("configServer/database/name", "name" );
		aDigester.addBeanPropertySetter("configServer/database/login", "login" );
		aDigester.addBeanPropertySetter("configServer/database/password", "password" );
		aDigester.addSetNext( "configServer/database", "setADatabase" );
		
		aDigester.addObjectCreate("configServer/ldap", Ldap.class);
		aDigester.addBeanPropertySetter("configServer/ldap/url", "url" );
		aDigester.addBeanPropertySetter("configServer/ldap/dir", "dir" );
		aDigester.addSetNext( "configServer/ldap", "setALdap" );

        aDigester.addBeanPropertySetter( "configServer/port", "port" );

        File configServerFile = new File("configServer.xml");
        
		ConfigServer aConfigServer = (ConfigServer)aDigester.parse(configServerFile);
		System.out.println(aConfigServer.toString());
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
