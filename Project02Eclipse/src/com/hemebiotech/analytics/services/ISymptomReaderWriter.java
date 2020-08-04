package com.hemebiotech.analytics.services;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.models.Symptoms;

/**
 * Interface to implements, to read symptoms from file, and write
 * them sorted in an ouput file
 * 
 * @author Heimdall
 *
 */

public interface ISymptomReaderWriter {
	/**
	 * If no data is available, return an empty hashMap
	 * @param inputPath is the input file
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 * 
	 * @see com.hemebiotech.analytics.models.Symptoms
	 */
	public Map<String, Symptoms> getSymptoms(String inputPath);
	
	
	/**
	 * Sort the retrieved Symptoms accordingly to the implemented compareTo() method in Symptoms class.
	 * @return a sorted list
	 */
	
	public List<Symptoms> sortSymptoms();

	/**
	 * Get the processed list of symptoms (get, and sorted) and write it to an output file
	 * Call the result of sortSymptoms()
	 * @param outputPath is the output file.
	 */
	public void  writeOutputFileSortedSymptoms (String outputPath);



}
