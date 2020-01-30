def float_input(prompt):
    try:
        return float(input(prompt))
    except ValueError:
        print("Enter valid number.")
        return float_input(prompt)
        
height = float_input("What is your height (inches)? ")
weight = float_input("What is your weight (pounds)? ")

bmi = (weight / (height * height)) * 703

print(f"Your BMI is {bmi:.1f}")
if 18.5 <= bmi <= 25:
    print("You are within the ideal weight range.")
else:
    print(f"You are {'under' if bmi < 18.5 else 'over'}weight.",
           "You should see your doctor.")

    