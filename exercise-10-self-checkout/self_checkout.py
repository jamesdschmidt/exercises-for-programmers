TAX_RATE = 0.055

item1_price = float(input("Enter the price of item 1: "))
item1_quantity = int(input("Enter the quantity of item 1: "))

item2_price = float(input("Enter the price of item 2: "))
item2_quantity = int(input("Enter the quantity of item 2: "))

item3_price = float(input("Enter the price of item 3: "))
item3_quantity = int(input("Enter the quantity of item 3: "))

subtotal = item1_price * item1_quantity + \
           item2_price * item2_quantity + \
           item3_price * item3_quantity
tax = subtotal * TAX_RATE
total = subtotal + tax

output = "Subtotal: ${0:,.2f}\nTax: ${1:,.2f}\nTotal: ${2:,.2f}" \
    .format(subtotal, tax, total)
print(output)

