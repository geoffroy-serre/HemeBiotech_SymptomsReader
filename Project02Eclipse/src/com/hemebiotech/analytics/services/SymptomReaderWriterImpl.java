package com.hemebiotech.analytics.services;


import com.hemebiotech.analytics.enums.Colors;
import com.hemebiotech.analytics.models.Symptoms;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class SymptomReaderWriterImpl implements ISymptomReaderWriter {

  @Override
  public Map<String, Symptoms> getSymptoms(String inputPath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
      String line = reader.readLine();
      Map<String, Symptoms> countedSymptoms = new HashMap<>();
      while (line != null) {
        Symptoms symp = countedSymptoms.get(line);
        if (symp == null) {
          Symptoms s = new Symptoms(line, 1);
          countedSymptoms.put(line, s);
        } else {
          symp.setOccurency(symp.getOccurency() + 1);
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
  public List<Symptoms> sortSymptomsAlpha(Map<String, Symptoms> symptoms) {
    return symptoms.values()
            .stream()
            .sorted()
            .collect(Collectors.toList());
  }

  @Override
  public List<Symptoms> sortSymptomsAlphaReversed(Map<String, Symptoms> symptoms) {
    return symptoms.values()
            .stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
  }

  @Override
  public List<Symptoms> sortSymptomsNumerical(Map<String, Symptoms> symptoms) {
    Comparator<Symptoms> comparator = Comparator.comparingInt(Symptoms::getOccurency);
    return symptoms.values()
            .stream()
            .sorted(comparator)
            .collect(Collectors.toList());
  }

  @Override
  public List<Symptoms> sortSymptomsNumericalReverse(Map<String, Symptoms> symptoms) {
    Comparator<Symptoms> comparator = Comparator.comparingInt(Symptoms::getOccurency);
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

  @Override
  public void processingUserSortingChoice(int userChoice, String inputFile, String outputFile) {
    switch (userChoice) {
      case 1:
        writeOutputFileSortedSymptoms(outputFile, sortSymptomsAlpha(getSymptoms(inputFile)));
        break;
      case 2:
        writeOutputFileSortedSymptoms(outputFile,
                sortSymptomsAlphaReversed(getSymptoms(inputFile)));
        break;
      case 3:
        writeOutputFileSortedSymptoms(outputFile, sortSymptomsNumerical(getSymptoms(inputFile)));
        break;
      case 4:
        writeOutputFileSortedSymptoms(outputFile,
                sortSymptomsNumericalReverse(getSymptoms(inputFile)));
        break;
      default:
        break;
    }
    System.out.print(Colors.GREEN);
    System.out.printf("Symptoms from %s are sorted and written to %s \n", inputFile, outputFile);
    System.out.println();
  }

}

