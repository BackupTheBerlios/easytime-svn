/* 
 * Project easytime
 * ConfigClient.java - package fr.umlv.easytime.richclient.config;
 * Creator: kjason
 * Created on 6 janv. 2005 13:39:59
 *
 * Person in charge: kjason
 */
package fr.umlv.easytime.richclient.config;

/**
 * @author kjason
 *
 * Class responsible for saving parameters to find the application server.
 *
 */
public class ConfigClient {
	
	private Server aServer;
	
	/**
	 * @return Returns the aServer.
	 */
	public Server getAServer() {
		return aServer;
	}
	/**
	 * @param server The aServer to set.
	 */
	public void setAServer(Server server) {
		aServer = server;
	}
	
	public String toString() {
	      String newline = System.getProperty( "line.separator" );
	      StringBuffer buf = new StringBuffer();

	      buf.append( "--- Server ---" ).append( newline );
	      buf.append(aServer).append( newline );

	      return buf.toString();
	   }
}
