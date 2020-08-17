package com.hemebiotech.analytics.models;

/**
 * Class for Symptoms creation.
 * Use constructor Symptoms (String name, int occurency)
 * @author Heimdall
 * @see #Symptoms(String name, int occurency)
 */

public class Symptoms implements Comparable<Symptoms> {

	private String name;
	private int occurency;

	/**
	 * Create Symptom object
	 * 
	 * @param name Name of the symptom.
	 * @param occurency Number of time the symptom is present.
	 */

	public  Symptoms (String name, int occurency) {
		this.name = name;
		this.occurency = occurency;
	}

	/**
	 * Get the symptom's name
	 * 
	 * @return The name of the symptom
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the symptom name
	 * 
	 * @param name The Name of the symptom
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The symptom occurency
	 */
	public int getOccurency() {
		return occurency;
	}

	/**
	 * Set the symptom's occurency
	 * 
	 * @param occurency Number of time the symptom is present.
	 */
	public void setOccurency(int occurency) {
		this.occurency = occurency;
	}

	/**
	 * Overriding hashCode method as it is a pre-requisite for correct use of hashMap
	 * Set hashCode with the Symptoms name's.
	 */
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	/**
	 * Overriding equals method as it is a pre-requisite for correct use of hashMap
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		else  {
			return false;
		}
	}

	/**
	 * toString() method override to describe Symptoms with simplicity.
	 * @return name + " = "+occurency+"\n"
	 */
	@Override
	public String toString() {
		return this.name + " = "+this.occurency+"\n";
	}
	
	/**
	 * symptomsToFile() method describe Symptoms with simplicity for output.
	 * @return name + " = "+occurency+"\n"
	 */
	
	public String symptomsToFile() {
		return this.name + " = "+this.occurency+"\n";
	}
	
	/*
	 * Implementation for alphabetical order sorting.
	 * @return Result of alphabetical comparison.
	 */
	@Override
	public int compareTo(Symptoms o) {
		return this.name.compareTo(o.name);
	}



	/*
	 *  If you need to sort the objects numerically, and then if some occurencies are the same, sort alphabetically, 
	 *	just comment the above method, and uncomment the under one.
	 *
	 */

	  /*
	   @Override public int compareTo(Symptoms o) { 
	   
		  if(this.occurency ==	  o.occurency) {
			  return this.name.compareTo(o.name); 
		  } 
		  else { 
			  return	  this.occurency - o.occurency;
		  } 
		  }
		  */
	 



}
