first_number = int(input("What is the first number? "))
second_number = int(input("What is the second number? "))

summation = first_number + second_number
difference = first_number - second_number
product = first_number * second_number
quotient = first_number / second_number

print("{0} + {1} = {2}\n{0} - {1} = {3}\n{0} * {1} = {4}\n{0} / {1} = {5}"
    .format(first_number, second_number, summation, difference, product, 
            int(quotient)))

