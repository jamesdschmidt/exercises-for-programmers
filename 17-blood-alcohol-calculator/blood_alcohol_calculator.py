ALCOHOL_DISTRIBUTION_RATIO_MEN = 0.73
ALCOHOL_DISTRIBUTION_RATIO_WOMEN = 0.66
HOURS_MULTIPLIER = 0.015
MAX_BLOOD_ALCOHOL_CONTENT = 0.08
VOLUME_MULTIPLIER = 5.14

def int_input(prompt):
    try:
        return int(input(prompt))
    except ValueError:
        print("Enter valid number.")
        return int_input(prompt)

weight = int_input("What is your weight? ")
is_male = input("What is your gender? ").lower().startswith("m")
alcohol_distribution_ratio = ALCOHOL_DISTRIBUTION_RATIO_MEN if is_male \
                                else ALCOHOL_DISTRIBUTION_RATIO_WOMEN
ounces = int_input("How many ounces of alcohol did you drink? ")
hours = int_input("What is the number of hours since last drink? ")

left_operand = (ounces * VOLUME_MULTIPLIER) / \
               (weight * alcohol_distribution_ratio)
blood_alcohol_content = left_operand - (hours * HOURS_MULTIPLIER)

print("Your BAC is", round(blood_alcohol_content, 3))
print("It", "is" if blood_alcohol_content < MAX_BLOOD_ALCOHOL_CONTENT \
                 else "is not",
      "legal for you to drive.")

