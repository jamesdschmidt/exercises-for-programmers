import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class EmployeeListRemoval {
  public static void main(String[] args) {
    var employees = new ArrayList<String>(List.of("John Smith", "Jackie Jackson", "Chris Jones", "Amanda Cullen", "Jeremy Goodwin"));
    do {
      printEmployees(employees);
      System.out.println();
      var employee = getEmployee();
      System.out.println();
      removeEmployee(employees, employee);
    } while (employees.size() > 0);
  }

  private static String getEmployee() {
    return System.console().readLine("Enter an employee to remove: ");
  }

  private static void printEmployees(List<String> employees) {
    System.out.printf("There are %d employees:%n", employees.size());
    employees.forEach(System.out::println);
  }

  private static List removeEmployee(List<String> employees, String employee) {
    if (!employees.remove(employee)) {
      System.out.printf("The employee %s does not exist.%n", employee);
    }
    return employees;
  }
}
