package com.hemebiotech.analytics;


import com.hemebiotech.analytics.enums.Colors;
import com.hemebiotech.analytics.services.ISymptomReaderWriter;
import com.hemebiotech.analytics.services.SymptomReaderWriterImpl;
import com.hemebiotech.analytics.ui.UserInterface;
import com.hemebiotech.analytics.ui.UserInterfaceImpl;


public class AnalyticsCounter {

  public static void main(String[] args) {

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
    System.out.print(Colors.RED);
    System.out.println("Good Bye and thanks for using HemeBiotech Analytics");


  }
}
