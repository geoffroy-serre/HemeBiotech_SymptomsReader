package com.hemebiotech.analytics.models;

/**
 * Class for Symptoms creation
 * @author Heimdall
 *
 */

public class Symptoms implements Comparable<Symptoms> {

	private String name;
	private int occurency;
	
	/**
	 * Create Symptom object
	 * 
	 * @param name Name of the symptoms.
	 * @param occurency Number of time the symptoms is present.
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
	 * @param occurency
	 */
	public void setOccurency(int occurency) {
		this.occurency = occurency;
	}


	
	@Override
	public int compareTo(Symptoms o) {
	
		return this.name.compareTo(o.name);
	}


	
	
	
	
}
