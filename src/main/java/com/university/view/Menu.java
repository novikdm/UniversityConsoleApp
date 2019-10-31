package com.university.view;

import com.university.controller.MainController;
import com.university.entity.Lector;
import com.university.view.interfaces.Printable;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

  private MainController controller = new MainController();

  private Map<String, String> menu;
  private Map<String, Printable> methodsMenu;
  private Scanner inputLine = new Scanner(System.in);

  public Menu() {
    methodsMenu = new LinkedHashMap<String, Printable>();

    menu = new LinkedHashMap<String, String>();
    menu.put("1", "  1 - Find head of department");
    menu.put("2", "  2 - Show department statistic");
    menu.put("3", "  3 - Show average salary for department");
    menu.put("4", "  4 - Show count of employee for department");
    menu.put("5", "  5 - Search by template");

    menu.put("0", "  0 - Exit");

    methodsMenu.put("1", this::task1);
    methodsMenu.put("2", this::task2);
    methodsMenu.put("3", this::task3);
    methodsMenu.put("4", this::task4);
    methodsMenu.put("5", this::task5);
  }

  private void task1() {
    System.out.println("Write department name:");
    String template = inputLine.nextLine();
    Lector headOfDepartment = controller.getHeadOfDepartment(template);
    System.out.println("Head of " + template + " department is:");
    String printString = headOfDepartment == null ? "error" : headOfDepartment.toString();
    System.out.println(printString);
  }

  private void task2() {
    System.out.println("Write department name:");
    String template = inputLine.nextLine();
    List<String> departmentStatistic = controller.getDepartmentStatistic(template);
    System.out.println("Result:");
    if (departmentStatistic.isEmpty())
      System.out.println("Error");
    else departmentStatistic.forEach(System.out::println);
  }

  private void task3() {
    System.out.println("Write department name:");
    String template = inputLine.nextLine();
    double averageDepartmentSalary = controller.getAverageDepartmentSalary(template);
    System.out.println("Result:");
    System.out.println(averageDepartmentSalary);
  }

  private void task4() {
    System.out.println("Write department name:");
    String template = inputLine.nextLine();
    int countEmployeeForDepartment = controller.getCountEmployeeForDepartment(template);
    System.out.println("Result:");
    System.out.println(countEmployeeForDepartment);
  }

  private void task5() {
    System.out.println("Write template for searching:");
    String template = inputLine.nextLine();
    List<Lector> lectors = null;
    try {
      lectors = controller.findLectorsByTemplate(template);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
    System.out.println("Results:");
    lectors.forEach(System.out::println);
  }

  private void outputMenu() {
    System.out.println("--------------------------------------------------------");
    System.out.println("MENU:");
    for (String str : menu.values()) {
      System.out.println(str);
    }
  }

  public void show() {
    String keyMenu;
    do {
      outputMenu();
      System.out.println("Please, select menu point.");
      keyMenu = inputLine.nextLine().toUpperCase();
      try {
        methodsMenu.get(keyMenu).print();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } while (!keyMenu.equals("0"));
  }
}
