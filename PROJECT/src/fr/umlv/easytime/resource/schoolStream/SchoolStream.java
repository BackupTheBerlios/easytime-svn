/* 
 * Project easytime
 * SchoolStream.java - package fr.umlv.easytime.resource.schoolStream;
 * Creator: rjourdan
 * Created on 6 janv. 2005 10:59:10
 *
 * Person in charge: rjourdan
 */
package fr.umlv.easytime.resource.schoolStream;

/**
 * @author rjourdan
 *
 * This public class describe the school stream Resource dataObject.
 * This class gathers all informations about a stream of the school. 
 * It's JavaBean compliant so that the mapping could be done with
 * Hibernate.
 */
public class SchoolStream {

	private int id;
	private int creationYear;
	private String name;
	private int respTeacherID;
	private String startClassHour;
	private String classDuration;
	private String breakDuration;
	private int halfClassNumber;
	private int classSubsetNumber;
	
	
	public SchoolStream(){
		
	}
	
	
	/**
	 * @return Returns the breakDuration.
	 */
	public String getBreakDuration() {
		return breakDuration;
	}
	/**
	 * @param breakDuration The breakDuration to set.
	 */
	public void setBreakDuration(String breakDuration) {
		this.breakDuration = breakDuration;
	}
	/**
	 * @return Returns the classDuration.
	 */
	public String getClassDuration() {
		return classDuration;
	}
	/**
	 * @param classDuration The classDuration to set.
	 */
	public void setClassDuration(String classDuration) {
		this.classDuration = classDuration;
	}
	/**
	 * @return Returns the classSubsetNumber.
	 */
	public int getClassSubsetNumber() {
		return classSubsetNumber;
	}
	/**
	 * @param classSubsetNumber The classSubsetNumber to set.
	 */
	public void setClassSubsetNumber(int classSubsetNumber) {
		this.classSubsetNumber = classSubsetNumber;
	}
	/**
	 * @return Returns the creationYear.
	 */
	public int getCreationYear() {
		return creationYear;
	}
	/**
	 * @param creationYear The creationYear to set.
	 */
	public void setCreationYear(int creationYear) {
		this.creationYear = creationYear;
	}
	/**
	 * @return Returns the halfClassNumber.
	 */
	public int getHalfClassNumber() {
		return halfClassNumber;
	}
	/**
	 * @param halfClassNumber The halfClassNumber to set.
	 */
	public void setHalfClassNumber(int halfClassNumber) {
		this.halfClassNumber = halfClassNumber;
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
	 * @return Returns the startClassHour.
	 */
	public String getStartClassHour() {
		return startClassHour;
	}
	/**
	 * @param startClassHour The startClassHour to set.
	 */
	public void setStartClassHour(String startClassHour) {
		this.startClassHour = startClassHour;
	}
}
