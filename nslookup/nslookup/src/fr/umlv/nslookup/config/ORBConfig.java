/* 
 * Project NSLookUPUI
 * ORBConfig.java - package config;
 * Creator: Administrateur
 * Created on 8 févr. 2005 00:39:04
 *
 * Person in charge: Administrateur
 */
package fr.umlv.nslookup.config;

/**
 * @author Administrateur
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class ORBConfig {
	private String port;
	private String address;
	
	
	
    /**
     * Creates a new ORBConfig object.
     *
     * @param port
     * @param address
     */
    public ORBConfig(String port, String address) {
        super();
        this.port = port;
        this.address = address;
    }
	/**
	 * @return Returns the address.
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address The address to set.
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return Returns the port.
	 */
	public String getPort() {
		return port;
	}
	/**
	 * @param port The port to set.
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	public String toString(){
	    return "orb : port="+port+" address="+address;
	}
}
