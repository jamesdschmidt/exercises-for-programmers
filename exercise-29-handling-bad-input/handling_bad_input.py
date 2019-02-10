import math

def get_rate():
    try:
        rate = int(input("What is the rate of return? "))
        if rate == 0:
            raise ValueError
        return rate
    except ValueError:
        print("Sorry. That's not a valid input.")
        return get_rate()

rate = get_rate()
years = math.ceil(72 / rate)
print(f"It will take {years} years to double your initial investment.")

