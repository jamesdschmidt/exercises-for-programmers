import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class EmployeeListRemoval {
  public static void main(String[] args) {
    var employees = new ArrayList<String>(List.of("John Smith", "Jackie Jackson", "Chris Jones", "Amanda Cullen", "Jeremy Goodwin"));
    printEmployees(employees);
    if (removeEmployee(employees)) {
      System.out.println();
      printEmployees(employees);
    } else {
      System.out.println("\nThe name doesn't exist.");
    }
  }

  private static void printEmployees(List<String> employees) {
    System.out.printf("There are %d employees:%n", employees.size());
    employees.forEach(System.out::println);
  }

  private static boolean removeEmployee(List<String> employees) {
    var employee = System.console().readLine("%nEnter an employee to remove: ");
    return employees.remove(employee);
  }
}

