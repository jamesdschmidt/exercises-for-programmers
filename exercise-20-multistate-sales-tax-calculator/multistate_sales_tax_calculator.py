amount = float(input("What is the order amount? "))
state = input("What state do you live in? ")
tax = 0
if state.lower().startswith("il"):
    tax = amount * 0.08
elif state.lower().startswith("wi"):
    tax = amount * 0.055
    county = input("What county do you live in? ")
    if county.lower() == "eau claire":
        tax += 0.005
    elif county.lower() == "dunn":
        tax += 0.004

output = ""
total = amount
if tax > 0:
    output = f"The tax is ${tax:.2f}\n"
    total += tax
output += f"The total is ${total:.2f}."
print(output)

