/* 
 * Project easytime
 * Ldap.java - package fr.umlv.easytime.test.kjason;
 * Creator: kjason
 * Created on 6 janv. 2005 11:11:29
 *
 * Person in charge: kjason
 */
package fr.umlv.easytime.test.kjason;

/**
 * @author kjason
 *
 * Class responsible for saving parameters to join annuary LDAP
 *
 */
public class Ldap {
	
	private String url;
	private String dir;
	
	

	/**
	 * @return Returns the dir.
	 */
	public String getDir() {
		return dir;
	}
	/**
	 * @param dir The dir to set.
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}
	/**
	 * @return Returns the url.
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url The url to set.
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	public String toString() {
	      return "Ldap: url='" + url + "' dir='" + dir + "'";
	   }
}
