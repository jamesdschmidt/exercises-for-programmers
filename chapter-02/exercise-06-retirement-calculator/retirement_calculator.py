from datetime import datetime

current_age = int(input("What is your current age? "))
retire_age = int(input("At what age would you like to retire? "))

years_left = retire_age - current_age
current_year = datetime.now().year
retirement_year = current_year + years_left

if years_left < 1:
  print("You can already retire.")
else:
  print(f'You have {years_left} years left until you can retire.\nIt\'s {current_year}, so you can retire in {retirement_year}.')
