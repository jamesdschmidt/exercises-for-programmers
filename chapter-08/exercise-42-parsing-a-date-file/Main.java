import java.util.List;

/**
 * A program to process records from a file and display the results.
 * Exercise 42 Parsing a Data File, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
 */
class Main {
	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		List<Employee> employees = service.getEmployees("employees.txt");
		service.printEmployees(employees);
	}
}
