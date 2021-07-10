package com.hemebiotech.analytics;


import com.hemebiotech.analytics.services.ISymptomReaderWriter;
import com.hemebiotech.analytics.services.SymptomReaderWriterImpl;
import com.hemebiotech.analytics.ui.UserInterface;
import com.hemebiotech.analytics.ui.UserInterfaceImpl;


public class AnalyticsCounter {


  public static void main(String[] args) {

    double startTime = System.currentTimeMillis();
    final String INPUT_PATH = "symptoms.txt";
    final String OUTPUT_PATH = "results.out";

    ISymptomReaderWriter service = new SymptomReaderWriterImpl();
    UserInterface userInterface = new UserInterfaceImpl();

    boolean retry = true;

    while (retry) {
      userInterface.userMenu();
      int userChoice = userInterface.userChoice();
      service.processingUserSortingChoice(userChoice, INPUT_PATH, OUTPUT_PATH);
      retry = userInterface.askForRetry();
    }
    System.out.println("Program Terminated in: " + (System.currentTimeMillis() - startTime) / 1000 + " seconds");


  }
}
