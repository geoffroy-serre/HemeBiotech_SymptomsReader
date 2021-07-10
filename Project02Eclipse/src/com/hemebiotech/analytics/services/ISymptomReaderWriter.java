package com.hemebiotech.analytics.services;

import com.hemebiotech.analytics.models.Symptoms;
import java.util.List;
import java.util.Map;

public interface ISymptomReaderWriter {


	Map<String, Symptoms> getSymptoms(String inputPath);

	List<Symptoms> sortSymptomsAlpha(Map<String, Symptoms> symptoms);

	List<Symptoms> sortSymptomsAlphaReversed(Map<String, Symptoms> symptoms);

	List<Symptoms> sortSymptomsNumerical(Map<String, Symptoms> symptoms);

	List<Symptoms> sortSymptomsNumericalReverse(Map<String, Symptoms> symptoms);

	void writeOutputFileSortedSymptoms(String outputPath, List<Symptoms> symptomsOrdered);
}
