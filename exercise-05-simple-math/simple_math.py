first_number = int(input("What is the first number? "))
second_number = int(input("What is the second number? "))

summation = first_number + second_number
difference = first_number - second_number
product = first_number * second_number
quotient = first_number / second_number

print(f"{first_number} + {second_number} = {summation}\n" \
      f"{first_number} - {second_number} = {difference}\n" \
      f"{first_number} * {second_number} = {product}\n" \
      f"{first_number} / {second_number} = {int(quotient)}")
