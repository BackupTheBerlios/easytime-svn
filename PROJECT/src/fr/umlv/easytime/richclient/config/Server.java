/* 
 * Project easytime
 * Server.java - package fr.umlv.easytime.richclient.config;
 * Creator: kjason
 * Created on 6 janv. 2005 13:38:42
 *
 * Person in charge: kjason
 */
package fr.umlv.easytime.richclient.config;

/**
 * @author kjason
 *
 * Class responsible for saving Server's attributes.
 *
 */
public class Server {
	
	private String name;
	private int port;
	

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
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
	
	public String toString() {
	      return "Server: name='" + name + "' port='" + port + "'";
	   }
}
