def print_employees(employees):
    print(f"There are {len(employees)} employees:")
    print("\n".join(employees))

def remove_employee(employees):
    employee = input("\nEnter an employee name to remove: ")
    if employees.count(employee) > 0:
        employees.remove(employee)
        return True
    return False

employees = ["John Smith", "Jackie Jackson", "Chris Jones", \
             "Amanda Cullen", "Jeremy Goodwin"]
print_employees(employees)
if remove_employee(employees):
    print()
    print_employees(employees)
else:
    print("\nThe name does not exist.")

