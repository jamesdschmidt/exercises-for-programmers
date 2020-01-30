DOLLAR_RATE = 100

euros = int(input("How many euros are you exchanging? "))
exchange_rate = float(input("What is the exchange rate? "))

dollars = round((euros * exchange_rate) / DOLLAR_RATE, 2)

print(f"{euros} euros at an exchange rate of {exchange_rate:,.2f} is\n"
      f"{dollars:,.2f} U.S. dollars.")

