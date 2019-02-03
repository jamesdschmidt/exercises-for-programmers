import java.util.List;

class Main {
  public static void main(String[] args) {
    var service = new EmployeeService();
    var employees = service.getEmployees("employees.txt");
    service.printEmployees(employees);
  }
}
