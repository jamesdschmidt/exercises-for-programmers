def numbers_input(prompt):
    try:
        return [int(n) for n in input(prompt).split()]
    except ValueError:
        return ints_input(prompt)

def filter_even_numbers(numbers):
    return [n for n in numbers if n % 2 == 0]

numbers = numbers_input("Enter a list of numbers, separated by spaces: ")
evens = filter_even_numbers(numbers)
print(f"The even numbers are {', '.join(str(n) for n in evens)}.")

