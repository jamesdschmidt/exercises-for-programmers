ONE_GALLON = 350

length = int(input("What is the length of the ceiling? "))
width = int(input("What is the width of the ceiling? "))

area = length * width
gallons = area // ONE_GALLON
if area % ONE_GALLON > 0:
    gallons += 1

print(f"You will need to purchase {gallons} gallons of\n"
      f"paint to cover {area} square feet.")

