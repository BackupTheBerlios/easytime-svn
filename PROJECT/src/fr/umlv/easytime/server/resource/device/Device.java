/* 
 * Project easytime
 * Device.java - package fr.umlv.easytime.resource.device;
 * Creator: rjourdan
 * Created on 6 janv. 2005 10:51:20
 *
 * Person in charge: rjourdan
 */
package fr.umlv.easytime.server.resource.device;

/**
 * @author rjourdan
 *
 * This public class describe the device Resource dataObject.
 * This class gathers all informations about a device. 
 * It's JavaBean compliant so that the mapping could be done with
 * Hibernate.
 */

public class Device {

	private int id;
	private int typeID;
	
	
	
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
	 * @return Returns the typeID.
	 */
	public int getTypeID() {
		return typeID;
	}
	/**
	 * @param typeID The typeID to set.
	 */
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
}
