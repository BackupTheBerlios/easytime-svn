/* 
 * Project easytime
 * Add.java - package fr.umlv.easytime.test.rjourdan;
 * Creator: rjourdan
 * Created on 5 janv. 2005 15:42:16
 *
 * Person in charge: rjourdan
 */
package fr.umlv.easytime.test.rjourdan;

/**
 * @author rjourdan
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class Facto {

	public static int process(int a){
		int result = 1;
		while(a> 0){
			result = a*result;
			a--;
		}
		return result;
	}
}
