package com.hemebiotech.analytics.ui;

import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface{

  Scanner scanner = new Scanner(System.in);

  @Override
  public void userMenu() {
    System.out.println("###############################################################");
    System.out.println("#                                                             #");
    System.out.println("#                    HemeBiotech Analytics                    #");
    System.out.println("#                                                             #");
    System.out.println("###############################################################");
    System.out.println("Choose the wanted sorting method");
    System.out.println("1 - Sort symptoms by name alphabetically");
    System.out.println("2 - Sort symptoms by name alphabetically reversed");
    System.out.println("3 - Sort symptoms by ascending occurencies");
    System.out.println("4 - Sort symptoms by descending occurencies");

  }

  @Override
  public int userChoice() {
    int userChoice;
    do {
      System.out.print("Enter your choice: ");
      userChoice = Integer.parseInt(scanner.nextLine());
    } while (userChoice < 1 || userChoice > 4);
    return userChoice;
  }

  @Override
  public boolean askForRetry() {
    String retryChoice;
    do {
      System.out.println("Do you want to launch sorting again? (y/n)");
      retryChoice = scanner.nextLine();
    } while (!retryChoice.equalsIgnoreCase("y") && !retryChoice.equalsIgnoreCase("n"));
    return retryChoice.equalsIgnoreCase("y");

  }
}
