/*
 * Created on 29 nov. 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package fr.uml.mloyen.monpackage;

/**
 * @author Mat
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AdditionnerBean {

	private int arg1=0;
	private int arg2=0;
	private int sum=0;
	
	/**
	 * 
	 */
	public AdditionnerBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	}
	/**
	 * @return Returns the arg1.
	 */
	public int getArg1() {
		return arg1;
	}
	/**
	 * @param arg1 The arg1 to set.
	 */
	public void setArg1(int arg1) {
		this.arg1 = arg1;
	}
	/**
	 * @return Returns the arg2.
	 */
	public int getArg2() {
		return arg2;
	}
	/**
	 * @param arg2 The arg2 to set.
	 */
	public void setArg2(int arg2) {
		this.arg2 = arg2;
	}
	/**
	 * @return Returns the sum.
	 */
	public int getSum() {
		return sum;
	}
	
	public void compute(){
		sum = arg1 + arg2;
	}
}
