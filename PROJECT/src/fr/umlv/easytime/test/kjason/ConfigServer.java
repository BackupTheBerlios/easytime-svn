/* 
 * Project easytime
 * ConfigServer.java - package fr.umlv.easytime.test.kjason;
 * Creator: kjason
 * Created on 6 janv. 2005 11:05:45
 *
 * Person in charge: kjason
 */
package fr.umlv.easytime.test.kjason;

/**
 * @author kjason
 *
 * Class responsible for saving parameters of the application server.
 *
 */
public class ConfigServer {

	private Database aDatabase;
	private Ldap aLdap;
	private int port;
	
	/**
	 * @return Returns the aLdap.
	 */
	public Ldap getALdap() {
		return aLdap;
	}
	/**
	 * @param ldap The aLdap to set.
	 */
	public void setALdap(Ldap ldap) {
		aLdap = ldap;
	}
	/**
	 * @return Returns the port.
	 */
	public int getPort() {
		return port;
	}
	/**
	 * @param port The port to set.
	 */
	public void setPort(int port) {
		this.port = port;
	}
	/**
	 * @return Returns the aDatabase.
	 */
	public Database getADatabase() {
		return aDatabase;
	}
	/**
	 * @param database The aDatabase to set.
	 */
	public void setADatabase(Database database) {
		aDatabase = database;
	}
	
	public String toString() {
	      String newline = System.getProperty( "line.separator" );
	      StringBuffer buf = new StringBuffer();

	      buf.append( "--- Database ---" ).append( newline );
	      buf.append(aDatabase).append( newline );

	      buf.append( "--- Ldap ---" ).append( newline );
	      buf.append(aLdap).append( newline );
	      
	      buf.append( "--- Port ---" ).append( newline );
	      buf.append(port).append( newline );

	      return buf.toString();
	   }
}
