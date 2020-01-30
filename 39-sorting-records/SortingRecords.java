import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class SortingRecords {
  public static void main(String[] args) {
    var employees = getEmployees();
    employees = sort(employees, "last");
    print(employees);
  }

  private static Map<String, String> of(String first, String last, String position, String separationDate) {
    return Map.of("first", first,
                  "last", last,
                  "position", position,
                  "separationDate", separationDate);
  }

  private static List<Map<String, String>> getEmployees() {
    return Arrays.asList(
        of("John", "Johnson", "Manager", "2016-12-31"),
        of("Tou", "Xiong", "Software Engineer", "2016-10-05"),
        of("Michaela", "Michaelson", "District Manager", "2015-12-19"),
        of("Jake", "Jacobson", "Programmer", ""),
        of("Jacquelyn", "Jackson", "DBA", ""),
        of("Sally", "Weber", "Web Developer", "2015-12-18"));
  }

  private static void print(List<Map<String, String>> employees) {
    System.out.println("Name                | Position          | Separation Date");
    System.out.println("--------------------|-------------------|----------------");
    employees.forEach(employee -> {
      System.out.printf("%-20s| %-18s| %s%n",
        employee.get("first") + " " + employee.get("last"),
        employee.get("position"),
        employee.get("separationDate"));
    });
  }

  private static List<Map<String, String>> sort(List<Map<String, String>> employees, String field) {
    Comparator<Map<String, String>> comparator = (Map<String, String> m1, Map<String, String> m2) -> m1.get(field).compareTo(m2.get(field));
    employees.sort(comparator);
    return employees;
  }
}

