/* 
 * Project easytime
 * Teacher.java - package fr.umlv.easytime.resource.teacher;
 * Creator: rjourdan
 * Created on 5 janv. 2005 17:29:37
 *
 * Person in charge: rjourdan
 */
package fr.umlv.easytime.resource.teacher;

/**
 * @author rjourdan
 *
 * This public class describe the Teacher Resource dataObject. 
 * This class gathers all informations about a Teacher.
 * It's JavaBean compliant so that the mapping could be done with
 * Hibernate.  
 *
 */
public class Teacher {

	 private int id;
	 private String firstName;
	 private String lastName;
	 private String email;
	 private int quota;
	 private int priority;
	 private int streamID;
	 
	 
	 
	 public Teacher(){
	 	
	 }
	 
	 
	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return Returns the firstName.
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName The firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	 * @return Returns the lastName.
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName The lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return Returns the priority.
	 */
	public int getPriority() {
		return priority;
	}
	/**
	 * @param priority The priority to set.
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * @return Returns the quota.
	 */
	public int getQuota() {
		return quota;
	}
	/**
	 * @param quota The quota to set.
	 */
	public void setQuota(int quota) {
		this.quota = quota;
	}
	/**
	 * @return Returns the streamID.
	 */
	public int getStreamID() {
		return streamID;
	}
	/**
	 * @param streamID The streamID to set.
	 */
	public void setStreamID(int streamID) {
		this.streamID = streamID;
	}
}
