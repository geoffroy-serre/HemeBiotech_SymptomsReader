package com.hemebiotech.analytics.services;


import com.hemebiotech.analytics.models.Symptoms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class SymptomReaderWriterImpl implements ISymptomReaderWriter   {

	private String inputPath;

	@Override
	public Map<String, Symptoms> getSymptoms(String inputPath) {

		this.inputPath = inputPath;
		try (BufferedReader reader = new BufferedReader (new FileReader(inputPath))) {
			String line = reader.readLine();
			Map<String, Symptoms> countedSymptoms = new HashMap<>();
			while (line != null) {
				Symptoms symp = countedSymptoms.get(line);
				if (symp == null) {
					Symptoms s = new Symptoms(line, 1);
					countedSymptoms.put(line, s);	
				}
				else {
					symp.setOccurency(symp.getOccurency()+1);
				}
				line = reader.readLine();
			}
			return countedSymptoms;
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyMap();
		}
	}


	@Override
	public List<Symptoms> sortSymptomsAlpha( Map<String,Symptoms> symptoms){
		return symptoms.values()
						.stream()
						.sorted()
						.collect(Collectors.toList());
	}

	@Override
	public List<Symptoms> sortSymptomsAlphaReversed( Map<String,Symptoms> symptoms){
		return symptoms.values()
						.stream()
						.sorted(Comparator.reverseOrder())
						.collect(Collectors.toList());
	}

	@Override
	public List<Symptoms> sortSymptomsNumerical( Map<String,Symptoms> symptoms){
		Comparator<Symptoms> comparator = (o1, o2) -> o1.getOccurency() - o2.getOccurency();

		return symptoms.values()
						.stream()
						.sorted(comparator)
						.collect(Collectors.toList());
	}

	@Override
	public List<Symptoms> sortSymptomsNumericalReverse( Map<String,Symptoms> symptoms){
		Comparator<Symptoms> comparator = (o1, o2) -> o1.getOccurency() - o2.getOccurency();

		return symptoms.values()
						.stream()
						.sorted(comparator.reversed())
						.collect(Collectors.toList());
	}

	@Override
	public void writeOutputFileSortedSymptoms(String outputPath, List<Symptoms> symptomsOrdered) {
		try (FileWriter writer = new FileWriter(outputPath)) {
			for (Symptoms s : symptomsOrdered) {
				writer.write(s.symptomsToFile());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 

}

