def split(s):
    numbers = []
    current = ""
    for c in s:
        if c == " ":
            if len(current) > 0 and current.isdigit():
                numbers.append(int(current))
                current = ""
        else:
            current += c
    if len(current) > 0 and current.isdigit():
        numbers.append(int(current))
    return numbers

def numbers_input(prompt):
    try:
        return [int(n) for n in split(input(prompt))]
    except ValueError:
        return ints_input(prompt)

def filter_even_numbers(numbers):
    return [n for n in numbers if n % 2 == 0]

numbers = numbers_input("Enter a list of numbers, separated by spaces: ")
evens = filter_even_numbers(numbers)
print(f"The even numbers are {', '.join(str(n) for n in evens)}.")

