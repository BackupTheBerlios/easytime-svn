/* 
 * Project easytime
 * User.java - package fr.umlv.easytime.resource.user;
 * Creator: rjourdan
 * Created on 6 janv. 2005 10:41:34
 *
 * Person in charge: rjourdan
 */
package fr.umlv.easytime.server.resource.user;

/**
 * @author rjourdan
 *
 * This public class describe the user Resource dataObject.
 * This class gathers all informations about a user. 
 * It's JavaBean compliant so that the mapping could be done with
 * Hibernate.
 */
public class User {

	private String login;
	private int profile;
	private boolean type;
	private String password;
	
	public User() {
		
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
	 * @return Returns the profile.
	 */
	public int getProfile() {
		return profile;
	}
	/**
	 * @param profile The profile to set.
	 */
	public void setProfile(int profile) {
		this.profile = profile;
	}
	/**
	 * @return Returns the type.
	 */
	public boolean isType() {
		return type;
	}
	/**
	 * @param type The type to set.
	 */
	public void setType(boolean type) {
		this.type = type;
	}
}
