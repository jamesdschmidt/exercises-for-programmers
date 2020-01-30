
def readNames(filename):
    names = []
    with open(filename) as f:
        for line in f:
            names.append(line.split(", "))
    return names

def writeNames(names, filename):
    with open(filename, "w") as f:
        for name in names:
            print(f"{name}", file = f)

names = readNames("names.txt")
#Collections.sort(names)
writeNames(names, "sorted_names.txt")

