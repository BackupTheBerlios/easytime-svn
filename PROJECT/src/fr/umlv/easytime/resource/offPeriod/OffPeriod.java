/* 
 * Project easytime
 * OffPeriod.java - package fr.umlv.easytime.resource.offPeriod;
 * Creator: rjourdan
 * Created on 6 janv. 2005 11:12:38
 *
 * Person in charge: rjourdan
 */
package fr.umlv.easytime.resource.offPeriod;

import java.util.Date;

/**
 * @author rjourdan
 *
 * This public class describe the off period Resource dataObject.
 * This class gathers all informations about a period when classes are off. 
 * It's JavaBean compliant so that the mapping could be done with
 * Hibernate.
 */
public class OffPeriod {

	private Date startOff;
	private Date enOff;
	private int streamID;
	private int promotionGraduatedYear;
	
	public OffPeriod(){
		
	}
	
	/**
	 * @return Returns the enOff.
	 */
	public Date getEnOff() {
		return enOff;
	}
	/**
	 * @param enOff The enOff to set.
	 */
	public void setEnOff(Date enOff) {
		this.enOff = enOff;
	}
	/**
	 * @return Returns the promotionGraduatedYear.
	 */
	public int getPromotionGraduatedYear() {
		return promotionGraduatedYear;
	}
	/**
	 * @param promotionGraduatedYear The promotionGraduatedYear to set.
	 */
	public void setPromotionGraduatedYear(int promotionGraduatedYear) {
		this.promotionGraduatedYear = promotionGraduatedYear;
	}
	/**
	 * @return Returns the startOff.
	 */
	public Date getStartOff() {
		return startOff;
	}
	/**
	 * @param startOff The startOff to set.
	 */
	public void setStartOff(Date startOff) {
		this.startOff = startOff;
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
