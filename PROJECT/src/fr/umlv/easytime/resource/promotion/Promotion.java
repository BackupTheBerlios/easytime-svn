/* 
 * Project easytime
 * Promotion.java - package fr.umlv.easytime.resource.promotion;
 * Creator: rjourdan
 * Created on 6 janv. 2005 11:29:44
 *
 * Person in charge: rjourdan
 */
package fr.umlv.easytime.resource.promotion;

/**
 * @author rjourdan
 *
 * This public class describe the off period Resource dataObject.
 * This class gathers all informations about a period when classes are off. 
 * It's JavaBean compliant so that the mapping could be done with
 * Hibernate.
 */
public class Promotion {

	private int streamID;
	private int graduatedYear;
	private String LdapID;
	private int year;
	private int respTeacherID;
	
	
	public Promotion(){
		
	}
	
	
	/**
	 * @return Returns the graduatedYear.
	 */
	public int getGraduatedYear() {
		return graduatedYear;
	}
	/**
	 * @param graduatedYear The graduatedYear to set.
	 */
	public void setGraduatedYear(int graduatedYear) {
		this.graduatedYear = graduatedYear;
	}
	/**
	 * @return Returns the ldapID.
	 */
	public String getLdapID() {
		return LdapID;
	}
	/**
	 * @param ldapID The ldapID to set.
	 */
	public void setLdapID(String ldapID) {
		LdapID = ldapID;
	}
	/**
	 * @return Returns the respTeacherID.
	 */
	public int getRespTeacherID() {
		return respTeacherID;
	}
	/**
	 * @param respTeacherID The respTeacherID to set.
	 */
	public void setRespTeacherID(int respTeacherID) {
		this.respTeacherID = respTeacherID;
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
	/**
	 * @return Returns the year.
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year The year to set.
	 */
	public void setYear(int year) {
		this.year = year;
	}
}
