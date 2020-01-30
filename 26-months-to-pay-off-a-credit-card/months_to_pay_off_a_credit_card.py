import math

def calculate_months_until_paid_off(b, apr, p):
    i = (apr / 100) / 365
    return (-1 / 30) * \
             ((math.log(1 + (b / p) * (1 - ((1 + i) ** 30)))) \
                 / (math.log(1 + i)))

balance = float(input("What is your balance? "))
apr = float(input("What is the APR on the card (as a percent)? "))
monthly_payment = float(input("What is the monthly payment you can make? "))
months = calculate_months_until_paid_off(balance, apr, monthly_payment)
print(f"It will take you {math.ceil(months)} months to pay off this card.")

