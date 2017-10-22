import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

  public List<Employee> getEmployees(String filename) {
    List<Employee> employees = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String input;
      while ((input = reader.readLine()) != null) {
        String[] parts = input.split(",");
        if (parts != null && parts.length > 1) {
          employees.add(new Employee(parts[1], parts[0], parts[2]));
        }
      }
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return employees;
  }

  public void printEmployees(List<Employee> employees) {
    int lastNameLength = 0;
    int firstNameLength = 0;
    int salaryNameLength = 0;
    for (Employee e : employees) {
      firstNameLength = Math.max(e.getFirstName().length(), firstNameLength);
      lastNameLength = Math.max(e.getLastName().length(), lastNameLength);
      salaryNameLength = Math.max(e.getSalary().length(), salaryNameLength);
    }
    firstNameLength++;
    lastNameLength++;
    salaryNameLength++;
    int totalLength = firstNameLength + lastNameLength + salaryNameLength;

    String format = "%-" + lastNameLength + "s%-" + firstNameLength + "s%-" + salaryNameLength + "s";
    System.out.printf(format + "%n", "Last", "First", "Salary");
    System.out.printf("%s%n", Strings.repeat("-", totalLength));
    for (Employee e : employees) {
      System.out.printf(format + "%n", e.getLastName(), e.getFirstName(), e.getSalary());
    }
  }
}
