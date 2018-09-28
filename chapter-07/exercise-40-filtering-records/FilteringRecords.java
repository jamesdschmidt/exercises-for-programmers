import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class FilteringRecords {
  public static void main(String[] args) {
    var search = System.console().readLine("Enter a search string: ");
    var employees = getEmployees();
    var results = searchEmployees(employees, search);
    results = sortEmployees(results, "lastName");
    printEmployees(results);
  }

  private static Map<String, String> getEmployee(String firstName, String lastName, String position, String separationDate) {
    var employee = new HashMap<String, String>();
    employee.put("firstName", firstName);
    employee.put("lastName", lastName);
    employee.put("position", position);
    employee.put("separationDate", separationDate);
    return employee;
  }

  private static List<Map<String, String>> getEmployees() {
    var employees = new ArrayList<Map<String, String>>();
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
    var results = new ArrayList<Map<String, String>>();
    for (var i = 0; i < employees.size(); i++) {
      var employee = employees.get(i);
      for (var entry : employee.entrySet()) {
        if (entry.getValue().indexOf(search) > -1) {
          results.add(employee);
          break;
        }
      }
    }
    return results;
  }

  private static List<Map<String, String>> sortEmployees(List<Map<String, String>> employees, String field) {
    Comparator<Map<String, String>> comparator = (Map<String, String> m1, Map<String, String> m2) -> m1.get(field).compareTo(m2.get(field));
    employees.sort(comparator);
    return employees;
  }
}
