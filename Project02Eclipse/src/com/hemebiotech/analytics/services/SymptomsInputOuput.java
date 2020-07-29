package com.hemebiotech.analytics.services;

import com.hemebiotech.analytics.models.Symptoms;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
 * @see {@link Symptoms#Symptoms(String, int)}.
 *
 */


public class SymptomsInputOuput implements ISymptomReaderWriter   {


	/**
	 * getSymptoms() is the method use to read symptoms from symptoms.txt
	 * and returns a List with symptoms counted in it. It stop reading file when there is no more lines.
	 * 
	 * @return countedSymptoms in a List
	 * @exception IOException 
	 * @exception FileNotFoundException
	 * 
	 */
	public static List<Symptoms> getSymptoms() {

		try {
			BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
			String line = reader.readLine();
			ArrayList<Symptoms> countedSymptoms = new ArrayList<Symptoms>();

			while (line != null) {
				String symptomCurrentName="";
				int indexOfSymptoms=0;

				// Searching in countedSymptoms if current symptom line is already in the created List.
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
		} catch (FileNotFoundException e) {
			System.out.println("Can not find the specified input file with symptoms");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.println("Can not access to the specified input file");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Get the symptoms list from getSymptoms(), and sort them alphabetically 
	 * @return sortedSymptomsList a list of all symptoms sorted alphabetically
	 * @see {@link #getSymptoms()}.
	 */
	public static List<Symptoms> sortSymptoms(){

		try {
			List<Symptoms> sortedSymptomsList = getSymptoms();		
			Collections.sort(sortedSymptomsList);
			return sortedSymptomsList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Get the sortedSymptomsList from sortSymptoms() and write the data in results.out
	 * @exception IOException
	 * @see {@link #getSymptoms()}.
	 * @see {@link #sortSymptoms()}
	 * 
	 */
	
	public static void writeOutputFileSortedSymptoms() {
		try {
			FileWriter writer = new FileWriter("results.out");

			for (Symptoms symptoms : sortSymptoms()) {
				writer.write(symptoms.getName()+" = "+symptoms.getOccurency()+"\n");		
			}

			writer.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}







}
