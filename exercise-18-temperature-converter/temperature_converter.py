to_celsius = input("Press C to convert from Fahrenheit to Celsius.\n"
                   "Press F to convert from Celsius to Fahrenheit.\n"
                   "Your choice: ").lower() == "c"
temperature = float(input(f"Please enter the temperature in {'Fahrenheit' if to_celsius else 'Celsius'}: "))
if to_celsius:
    converted_temperature = (temperature - 32) * (5 / 9.0)
else:
    converted_temperature = (temperature * (9 / 5.0)) + 32
print(f"The temperature in {'Celsius' if to_celsius else 'Fahrenheit'}",
      f"is {converted_temperature:.1f}.")

