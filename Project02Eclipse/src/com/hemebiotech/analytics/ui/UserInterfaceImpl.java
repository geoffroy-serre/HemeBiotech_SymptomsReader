package com.hemebiotech.analytics.ui;

import com.hemebiotech.analytics.enums.Colors;
import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface{

  Scanner scanner = new Scanner(System.in);

  @Override
  public void userMenu() {
    System.out.print(Colors.GREEN_BRIGHT);
    System.out.println("###############################################################");
    System.out.println("#                                                             #");
    System.out.println("#                    HemeBiotech Analytics                    #");
    System.out.println("#                                                             #");
    System.out.println("###############################################################");
    System.out.print(Colors.BLUE_BRIGHT);
    System.out.println("Choose the wanted sorting method");
    System.out.println("1 - Sort symptoms by name alphabetically");
    System.out.println("2 - Sort symptoms by name alphabetically reversed");
    System.out.println("3 - Sort symptoms by ascending occurencies");
    System.out.println("4 - Sort symptoms by descending occurencies\n");
    System.out.print(Colors.RESET);

  }

  @Override
  public int userChoice() {
    int userChoice;
    do {
      System.out.print(Colors.MAGENTA_BRIGHT);
      System.out.print("Enter your choice: ");
      System.out.print(Colors.RESET);
      userChoice = Integer.parseInt(scanner.nextLine());
    } while (userChoice < 1 || userChoice > 4);
    return userChoice;
  }

  @Override
  public boolean askForRetry() {
    String retryChoice;
    do {
      System.out.print(Colors.YELLOW);
      System.out.print("Do you want to launch sorting again? (y/n): ");
      System.out.print(Colors.RESET);
      retryChoice = scanner.nextLine();
    } while (!retryChoice.equalsIgnoreCase("y") && !retryChoice.equalsIgnoreCase("n"));
    return retryChoice.equalsIgnoreCase("y");

  }
}
