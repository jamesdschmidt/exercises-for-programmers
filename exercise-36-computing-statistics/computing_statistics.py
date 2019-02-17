import math

def is_integer(s):
    try:
        int(s)
        return True
    except ValueError:
        return False

def get_numbers():
    numbers = []
    while True:
        s = input("Enter a number: ")
        if s.lower() == "done":
            break;
        elif is_integer(s):
            numbers.append(int(s))
    return numbers

def avg(numbers):
    return sum(numbers) / len(numbers)
    
def std_dev(numbers):
    mean = avg(numbers)
    sum = 0
    for n in numbers:
        sum += (n - mean) ** 2
    return math.sqrt(sum / (len(numbers) - 1))

numbers = get_numbers()
print("Numbers:", ", ".join(str(n) for n in numbers))
print(f"The average is {avg(numbers)}.")
print(f"The minimum is {min(numbers)}.")
print(f"The minimum is {max(numbers)}.")
print(f"The standard deviation is {std_dev(numbers):.2f}.")

