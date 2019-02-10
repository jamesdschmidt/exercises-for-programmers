def int_input(prompt):
    s = input(prompt)
    try:
        return int(s)
    except ValueError:
        print("Enter valid number.")
        return int_input(prompt)

total = 0
for n in range(5):
    total += int_input("Enter a number: ")
print(f"The total is {total}.")

