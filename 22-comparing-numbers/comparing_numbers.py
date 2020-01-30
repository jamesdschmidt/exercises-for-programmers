first = int(input("Enter the first number: "))
second = int(input("Enter the second number: "))
third = int(input("Enter the third number: "))

if first != second != third:
    largest = first
    if second > largest:
        largest = second
    if third > largest:
        largest = third
    print(f"The largest number is {largest}.")

