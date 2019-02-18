from operator import itemgetter

def employee(first, last, position, separation_date):
    return {"first": first,
            "last": last,
            "position": position,
            "separation_date": separation_date}

def employees():
    employees = [employee("John", "Johnson", "Manager", "2016-12-31"),
                 employee("Tou", "Xiong", "Software Engineer", "2016-10-05"),
                 employee("Michaela", "Michaelson", "District Manager",
                          "2015-12-19"),
                 employee("Jake", "Jacobson", "Programmer", ""),
                 employee("Jacquelyn", "Jackson", "DBA", ""),
                 employee("Sally", "Weber", "Web Developer", "2015-12-18")]
    return employees

def print_employees(employees):
    print("Name                | Position          | Separation Date")
    print("--------------------|-------------------|----------------")
    for e in employees:
        print(f"{e['first'] + ' ' + e['last']:<20}| {e['position']:<18}| " \
              f"{e['separation_date']}")

employees = employees()
employees.sort(key = itemgetter("last"))
print_employees(employees)

