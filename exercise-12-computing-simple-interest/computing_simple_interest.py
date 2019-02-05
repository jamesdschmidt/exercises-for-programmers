principal = float(input("Enter the principal: "))
rate = float(input("Enter the rate of interest: "))
years = int(input("Enter the number of years: "))

amount = round(principal * (1 + (rate / 100) * years), 2)

print(f"\nAfter {years} years at {rate}%, the investment will\n"
      f"be worth ${amount:.2f}")

