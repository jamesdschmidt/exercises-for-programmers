public class Employee {
  private String firstName;
  private String lastName;
  private String salary;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  public Employee(String firstName, String lastName, String salary) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.salary = salary;
  }
}
