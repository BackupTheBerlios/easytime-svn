/* 
 * Project easytime
 * TeacherOffDay.java - package fr.umlv.easytime.resource.teacheroffday;
 * Creator: rjourdan
 * Created on 5 janv. 2005 17:43:22
 *
 * Person in charge: rjourdan
 */
package fr.umlv.easytime.resource.teacherOffDay;

import java.util.Date;

/**
 * @author rjourdan
 *
 * This public class describe the Teacher OffDay Resource dataObject.
 * This class gathers all informations about the absence of a teacher. 
 * It's JavaBean compliant so that the mapping could be done with
 * Hibernate.
 */
public class TeacherOffDay {

	private int id;
	private Date offStart;
	private Date offEnd;
	private String offKind;
	private String offReason;
	
	
	public TeacherOffDay(){
		
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
	 * @return Returns the offEnd.
	 */
	public Date getOffEnd() {
		return offEnd;
	}
	/**
	 * @param offEnd The offEnd to set.
	 */
	public void setOffEnd(Date offEnd) {
		this.offEnd = offEnd;
	}
	/**
	 * @return Returns the offKind.
	 */
	public String getOffKind() {
		return offKind;
	}
	/**
	 * @param offKind The offKind to set.
	 */
	public void setOffKind(String offKind) {
		this.offKind = offKind;
	}
	/**
	 * @return Returns the offReason.
	 */
	public String getOffReason() {
		return offReason;
	}
	/**
	 * @param offReason The offReason to set.
	 */
	public void setOffReason(String offReason) {
		this.offReason = offReason;
	}
	/**
	 * @return Returns the offStart.
	 */
	public Date getOffStart() {
		return offStart;
	}
	/**
	 * @param offStart The offStart to set.
	 */
	public void setOffStart(Date offStart) {
		this.offStart = offStart;
	}
}
