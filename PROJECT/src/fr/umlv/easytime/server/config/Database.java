/* 
 * Project easytime
 * Database.java - package fr.umlv.easytime.test.kjason;
 * Creator: kjason
 * Created on 6 janv. 2005 11:09:02
 *
 * Person in charge: kjason
 */
package fr.umlv.easytime.server.config;

/**
 * @author kjason
 *
 * Class responsible for saving parameters of the database
 *
 */
public class Database {
	
	private String host;
	private int port;
	private String name;
	private String login;
	private String password;
	
	

	/**
	 * @return Returns the host.
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host The host to set.
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * @return Returns the login.
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login The login to set.
	 */
	public void setLogin(String login) {
		this.login = login;
	}
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
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
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
	      return "Database: host='" + host + "' port='" + port + "'" + "' name='" + name + "'" + "' login='" + login + "'" + "' password='" + password + "'";
	   }
}
