package com.hemebiotech.analytics.services;

import java.util.List;

import java.io.IOException;

import com.hemebiotech.analytics.models.Symptoms;

/**
 * Interface to implements to read symptoms from file, and write
 * them sorted in an ouput file
 * 
 * @author Heimdall
 *
 */

public interface ISymptomReaderWriter {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	public static List<Symptoms> getSymptoms() throws IOException{
		return null;
	}
	
	/**
	 * Get the processed list of symptoms and write it to an output file
	 */
	public static void  writeOutputFileSortedSymptoms () {}
		
	
	
}
