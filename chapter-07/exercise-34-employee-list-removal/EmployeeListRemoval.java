import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A program to allow user to remove employees from list.
 * Exercise 34 Employee List Removal, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
*/
class EmployeeListRemoval {
  public static void main(String[] args) {
    List<String> employees = new ArrayList<>(Arrays.asList("John Smith", "Jackie Jackson", "Chris Jones", "Amanda Cullen", "Jeremy Goodwin"));
    do {
      printEmployees(employees);
      System.out.println();
      String employee = getEmployee();
      System.out.println();
      removeEmployee(employees, employee);
    } while (employees.size() > 0);
  }

  private static String getEmployee() {
    return System.console().readLine("Enter an employee to remove: ");
  }

  private static void printEmployees(List<String> employees) {
    System.out.printf("There are %d employees:%n", employees.size());
    employees.forEach(e -> System.out.println(e));
  }

  private static List removeEmployee(List<String> employees, String employee) {
    if (employees.contains(employee)) {
      employees.remove(employee);
    } else {
      System.out.printf("The employee %s does not exist.%n", employee);
    }
    return employees;
  }
}
