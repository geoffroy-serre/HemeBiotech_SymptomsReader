package com.hemebiotech.analytics;


import com.hemebiotech.analytics.services.ISymptomReaderWriter;
import com.hemebiotech.analytics.services.SymptomReaderWriterImpl;

/**
 * Hemebiotech Analytics
 * 
 * The program get, count and sort alphabetically symptoms from a source file.
 * 
 * @author Heimdall
 * @version 0.1.0
 * @see com.hemebiotech.analytics.models.Symptoms
 */

public class AnalyticsCounter {


	public static void main(String[] args) {

		double startTime = System.currentTimeMillis();
		
		String inputPath = "symptoms.txt";
		String outputPath = "results.out";

		/*
		 * Instanciating Symptoms's service to launch the symptoms's file processing.
		 */
		
		ISymptomReaderWriter service = new SymptomReaderWriterImpl();
		service.getSymptoms(inputPath);
		service.writeOutputFileSortedSymptoms(outputPath);

		System.out.println("Program Terminated in: "+(System.currentTimeMillis()-startTime)/1000+" seconds");



	}
}
