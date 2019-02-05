FEET_TO_METERS = 0.09290304

length = int(input("What is the length of the room in feet? "))
width = int(input("What is the width of the room in feet? "))

area = length * width
area_in_meters = area * FEET_TO_METERS

print(f"You entered dimensions of {length} feet by {width} feet.\n"
      f"The area is\n{area} square feet\n{area_in_meters} square meters")

