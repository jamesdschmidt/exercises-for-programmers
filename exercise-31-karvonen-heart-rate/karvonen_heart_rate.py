def int_input(prompt):
    try:
        return int(input(prompt))
    except ValueError:
        print("Enter valid number.")
        return int_input(prompt)
        
def target_hr(age, resting_hr, intensity):
    return int((((220 - age) - resting_hr) * (intensity / 100.0)) + resting_hr)

age = int_input("What is your age? ")
resting_hr = int_input("What is your resting hear rate? ")

print(f"Resting Pulse: {resting_hr} Age: {age}")
print("Intensity | Rate");
print("----------|--------");
for intensity in range(55, 96, 5):
    print(f"{intensity}%       | {target_hr(age, resting_hr, intensity)} bpm")

