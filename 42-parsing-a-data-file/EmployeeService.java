import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
  
  record Employee(String firstName, String lastName, String salary) {}

  public List<Employee> getEmployees(String filename) {
    var employees = new ArrayList<Employee>();
    try (var reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
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
    var lastNameLength = 0;
    var firstNameLength = 0;
    var salaryNameLength = 0;
    for(var e : employees) {
      firstNameLength = Math.max(e.firstName().length(), firstNameLength);
      lastNameLength = Math.max(e.lastName().length(), lastNameLength);
      salaryNameLength = Math.max(e.salary().length(), salaryNameLength);
    }
    firstNameLength++;
    lastNameLength++;
    salaryNameLength++;
    var totalLength = firstNameLength + lastNameLength + salaryNameLength;

    final String format = "%-" + lastNameLength + "s%-" + firstNameLength + "s%-" + salaryNameLength + "s";
    System.out.printf(format + "%n", "Last", "First", "Salary");
    System.out.printf("%s%n", "-".repeat(totalLength));
    employees.forEach(e -> System.out.printf(format + "%n", e.lastName(), e.firstName(), e.salary()));
  }
}
