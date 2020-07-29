package com.hemebiotech.analytics.services;

import com.hemebiotech.analytics.models.Symptoms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Contains methods to read symptoms from a file, count them, sort them, and write the sorted list
 * in an ouput file results.out. 
 * 
 * @author Heimdall
 *
 */


public class SymptomsInputOuput implements ISymptomReaderWriter   {


	/**
	 * getSymptoms() is the method use to read symptoms from symptoms.txt
	 * and returns a List with symptoms counted in it. It stop reading file when there is no more lines.
	 * 
	 * @return countedSymptoms in a List
	 * @throws IOException if the file can"t be found
	 */
	public static List<Symptoms> getSymptoms() throws IOException  {

		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();
		ArrayList<Symptoms> countedSymptoms = new ArrayList<Symptoms>();

		while (line != null) {
			String symptomCurrentName="";
			int indexOfSymptoms=0;

			// Searching in countedSymptoms if current symptom line is already in
			for (Symptoms symptoms : countedSymptoms) {
				if (symptoms.getName().equals(line)) {
					indexOfSymptoms = countedSymptoms.indexOf(symptoms);
					symptomCurrentName = symptoms.getName();
				}
			}

			if (symptomCurrentName.equals(line)) {
				countedSymptoms.get(indexOfSymptoms).setOccurency(countedSymptoms.get(indexOfSymptoms).getOccurency()+1);
				line = reader.readLine();
			}
			else {

				Symptoms s = new Symptoms(line, 1);
				countedSymptoms.add(s);
				line = reader.readLine();

			}
		} 
		reader.close();
		return countedSymptoms;
	}

	/**
	 * Get the symptoms list from getSymptoms(), and sort them alphabetically 
	 * 
	 * @return sortedSymptomsList a list of all symptoms sorted alphabetically
	 * @throws IOException if the input file from getSymptoms() is unreachable
	 */
	public static List<Symptoms> sortSymptoms() throws IOException{

		List<Symptoms> sortedSymptomsList = getSymptoms();		
		Collections.sort(sortedSymptomsList);
		return sortedSymptomsList;

	}

	/**
	 * Get the sortedSymptomsList from sortSymptoms() and write the data in results.out
	 * 
	 * @throws IOException if the symptoms source can't be read or the ouput can't be write.
	 */
	public static void writeOutputFileSortedSymptoms() throws IOException {
		FileWriter writer = new FileWriter("results.out");

		for (Symptoms symptoms : sortSymptoms()) {
			writer.write(symptoms.getName()+" = "+symptoms.getOccurency()+"\n");		
		}

		writer.close();
		
	}







}
