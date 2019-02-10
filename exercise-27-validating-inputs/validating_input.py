import re

def validate_input(first_name, last_name, zip_code, employee_id):
    message = ""
    if not first_name or len(first_name) == 0:
        message += "The first name must be filled in.\n"
    elif len(first_name) < 2:
        message += f'"{first_name}" is not a valid first name. ' \
                    'It is too short.\n'
    if not last_name or len(last_name) == 0:
        message += "The last name must be filled in.\n"
    elif len(last_name) < 2:
        message += f'"{last_name}" is not a valid last name. ' \
                    'It is too short.\n'
    if not zip_code or not zip_code.isdigit():
        message += "The ZIP code must be numeric.\n"
    if not employee_id:
        message += "The employee ID must be filled in.\n"
    elif not re.fullmatch("^[A-Z]{2}-\d{4}$", employee_id):
        message += f"{employee_id} is not a valid ID.\n"
    if len(message) == 0:
        return "There were no errors found."
    else:
        return message[:-1]

first_name = input("Enter the first name: ")
last_name = input("Enter the last name: ")
zip_code = input("Enter the ZIP code: ")
employee_id = input("Enter an employee ID: ")
message = validate_input(first_name, last_name, zip_code, employee_id)
print(message)

