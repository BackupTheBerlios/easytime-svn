/* 
 * Project easytime
 * DeviceKind.java - package fr.umlv.easytime.server.resource.device;
 * Creator: rjourdan
 * Created on 6 janv. 2005 13:51:33
 *
 * Person in charge: rjourdan
 */
package fr.umlv.easytime.server.resource.device;


/**
 * @author rjourdan
 *
 * This public class describe the device kinds Resource dataObject.
 * This class gathers all kinds for a device. 
 * It's JavaBean compliant so that the mapping could be done with
 * Hibernate.
 */
public class DeviceKind {

	private int id;
	private String name;
	
	public DeviceKind(){
		
	}
	
	/**
	 * @return Returns the id.
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(int id) {
		this.id = id;
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
}
