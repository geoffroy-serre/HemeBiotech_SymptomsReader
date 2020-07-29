package com.hemebiotech.analytics;

import java.io.IOException;

import com.hemebiotech.analytics.services.SymptomsInputOuput;

/**
 * Hemebiotech Symptoms Analytics
 * 
 * The program count and sort alphabetically symptoms from a symptoms.txt file.
 * 
 * @author Heimdall
 *
 */

public class AnalyticsCounter {
	
	
	public static void main(String args[]) throws IOException {
		
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
