import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * A program that lets a user search for records.
 * Exercise 40 Filtering Records, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
 */
class FilteringRecords {
  public static void main(String[] args) {
    String search = System.console().readLine("Enter a search string: ");
    List<Map<String, String>> employees = getEmployees();
    List<Map<String, String>> results = searchEmployees(employees, search);
    results = sortEmployees(results, "lastName");
    printEmployees(results);
  }

  private static Map<String, String> getEmployee(String firstName, String lastName, String position, String separationDate) {
    Map<String, String> employee = new HashMap<>();
    employee.put("firstName", firstName);
    employee.put("lastName", lastName);
    employee.put("position", position);
    employee.put("separationDate", separationDate);
    return employee;
  }

  private static List<Map<String, String>> getEmployees() {
    List<Map<String, String>> employees = new ArrayList<>();
    employees.add(getEmployee("John", "Johnson", "Manager", "2016-12-31"));
    employees.add(getEmployee("Tou", "Xiong", "Software Engineer", "2016-10-05"));
    employees.add(getEmployee("Michaela", "Michaelson", "District Manager", "2015-12-19"));
    employees.add(getEmployee("Jake", "Jacobson", "Programmer", ""));
    employees.add(getEmployee("Jacquelyn", "Jackson", "DBA", ""));
    employees.add(getEmployee("Sally", "Weber", "Web Developer", "2015-12-18"));
    return employees;
  }

  private static void printEmployees(List<Map<String, String>> employees) {
    System.out.println("Name                | Position          | Separation Date");
    System.out.println("--------------------|-------------------|----------------");
    employees.forEach(employee -> {
      System.out.printf("%-20s| %-18s| %s%n",
        employee.get("firstName") + " " + employee.get("lastName"),
        employee.get("position"),
        employee.get("separationDate"));
    });
  }

  private static List<Map<String, String>> searchEmployees(List<Map<String, String>> employees, String search) {
    List<Map<String, String>> results = new ArrayList<>();
    for (int i = 0; i < employees.size(); i++) {
      Map<String, String> employee = employees.get(i);
      for (Map.Entry<String, String> entry : employee.entrySet()) {
        if (entry.getValue().indexOf(search) > -1) {
          results.add(employee);
          break;
        }
      }
    }
    return results;
  }

  private static List<Map<String, String>> sortEmployees(List<Map<String, String>> employees, String field) {
    Comparator<Map<String, String>> mapComparator = new Comparator<Map<String, String>>() {
      @Override
      public int compare(Map<String, String> o1, Map<String, String> o2) {
        return o1.get(field).compareTo(o2.get(field));
      }
    };
    employees.sort(mapComparator);
    return employees;
  }
}
