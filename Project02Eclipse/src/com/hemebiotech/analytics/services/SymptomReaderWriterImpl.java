package com.hemebiotech.analytics.services;

import com.hemebiotech.analytics.models.Symptoms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Contains methods to read symptoms from a file, sort them, and write the sorted list
 * in an ouput file results.out. 
 * 
 * @author Heimdall
 * @see com.hemebiotech.analytics.models.Symptoms#Symptoms(String name, int occurency)
 *
 */


public class SymptomReaderWriterImpl implements ISymptomReaderWriter   {

	private String inputPath;


	/**
	 * Method use to read symptoms from an input file
	 * and returns a HashMap<String symptomsName, Symptoms symptoms> with symptoms counted in it. 
	 * It stop reading file when there is no more lines.
	 * 
	 * @param inputPath is the source file  containing symptoms
	 * @return countedSymptoms in a HashMap
	 * 
	 */
	public Map<String, Symptoms> getSymptoms(String inputPath) {

		this.inputPath = inputPath;
		try (BufferedReader reader = new BufferedReader (new FileReader(inputPath))) {
			String line = reader.readLine();
			Map<String, Symptoms> countedSymptoms = new HashMap<>();

			while (line != null) {
				if (countedSymptoms.get(line) == null) {
					Symptoms s = new Symptoms(line, 1);
					countedSymptoms.put(line, s);
					line = reader.readLine();
				}
				else {

					countedSymptoms.get(line).setOccurency(countedSymptoms.get(line).getOccurency()+1);
					line = reader.readLine();
				}
			} 

			return countedSymptoms;
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyMap();
		}


	}

	/**
	 * Get the symptoms hashMap from getSymptoms(), and sort them depending the implemented compareTo() method in Symptoms class 
	 * @return sortedSymptomsList a list of sorted symptoms
	 * @see #getSymptoms()
	 */
	public List<Symptoms> sortSymptoms(){
		List<Symptoms> sortedSymptomsList = new ArrayList<>();
		for (Entry<String, Symptoms> symptoms : getSymptoms(inputPath).entrySet()) {
			sortedSymptomsList.add(symptoms.getValue());

		}
		Collections.sort(sortedSymptomsList);


		return sortedSymptomsList;
	}

	/**
	 * Get the sortedSymptomsList from sortSymptoms() and write the data in an output file
	 * It calls the sort method of this class before writing.
	 * @param outputPath file where processed symptoms are written.
	 * @see #getSymptoms()
	 * @see #sortSymptoms()
	 * 
	 */

	public void writeOutputFileSortedSymptoms(String outputPath) {

		try (FileWriter writer = new FileWriter(outputPath)) {
			for (Symptoms s : sortSymptoms()) {
				writer.write(s.toString());

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 

}

