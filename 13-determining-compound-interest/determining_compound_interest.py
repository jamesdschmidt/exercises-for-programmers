principal = float(input("What is the principal amount? "))
rate = float(input("What is the rate? "))
years = int(input("What is the number of years? "))
compound = int(input("What is the number of times the interest\n"
                     "is compounded per year?"))

amount = round(principal * ((1 + (rate / 100) / compound) ** 
               (compound * years)), 2)

print(f"${principal:.2f} invested at {rate}% for {years} years\n"
      f"compounded {compound} times per year is ${amount:.2f}.")

