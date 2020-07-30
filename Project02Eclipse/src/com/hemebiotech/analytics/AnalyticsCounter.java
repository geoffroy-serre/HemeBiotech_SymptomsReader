package com.hemebiotech.analytics;



import com.hemebiotech.analytics.services.SymptomsInputOuput;

/**
 * Hemebiotech Analytics
 * 
 * The program count and sort alphabetically symptoms from a symptoms.txt file.
 * 
 * @author Heimdall
 * @version 0.1.0
 * @see {@link com.hemebiotech.analytics.models.Symptoms}
 */

public class AnalyticsCounter {
	
	
	public static void main(String[] args) {
		
		double startTime = System.currentTimeMillis();

		try {
			SymptomsInputOuput.writeOutputFileSortedSymptoms();
		} catch (Exception e) {
			System.out.println("Can not process the program successfully, try to look if input file name is correct");
			e.printStackTrace();
		}
		
		System.out.println("Program Terminated in: "+(System.currentTimeMillis()-startTime)/1000+" seconds");
		
	
		
	}
}
