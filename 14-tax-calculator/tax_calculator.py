TAX_RATE = 0.055

amount = float(input("What is the order amount? "))
state = input("What is the state? ")

total = amount
output = ""

if "wi" == state.lower():
    tax = amount * TAX_RATE
    output = f"The tax is ${tax:,.2f}.\n"
    total += tax

output += f"The total is ${total:,.2f}"
print(output)

