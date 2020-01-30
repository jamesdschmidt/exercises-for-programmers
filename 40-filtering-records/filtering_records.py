from operator import itemgetter

def employee(first, last, position, separation_date):
    return {"first": first,
            "last": last,
            "position": position,
            "separation_date": separation_date}

def employees():
    return [employee("John", "Johnson", "Manager", "2016-12-31"),
            employee("Tou", "Xiong", "Software Engineer", "2016-10-05"),
            employee("Michaela", "Michaelson", "District Manager",
                     "2015-12-19"),
            employee("Jake", "Jacobson", "Programmer", ""),
            employee("Jacquelyn", "Jackson", "DBA", ""),
            employee("Sally", "Weber", "Web Developer", "2015-12-18")]            

def print_results(results):
    print("Name                | Position          | Separation Date")
    print("--------------------|-------------------|----------------")
    for r in results:
        print(f"{r['first'] + ' ' + r['last']:<20}| {r['position']:<18}| " \
              f"{r['separation_date']}")

def search(employees, term):
    results = []
    for e in employees:
        for v in e.values():
            if term in v:
                results.append(e)
                break;
    return results

term = input("Enter a search string: ")
employees = employees()
results = search(employees, term)
results.sort(key = itemgetter("last"))
print_results(results)

