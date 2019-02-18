from random import choice
from random import randrange

ALPHAS = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"]
SPECIALS = ["!", "'", "#", "$", "%", "&", "\"", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "@", "[", "\\", "]", "^", "_", "`", "{", "|", "}", "~"]
NUMBERS = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]

def int_input(prompt):
    try:
        return int(input(prompt))
    except ValueError:
        return int_input(prompt)
    
def generate_password(length, specials, numbers):
    password = ""
    specials_count = specials
    numbers_count = numbers
    for i in range(length):
        while True:
            random_list = randrange(3)
            if random_list == 0:
                password += choice(ALPHAS)
                break;
            elif random_list == 1 and specials_count > 0:
                password += choice(SPECIALS)
                specials_count -= 1
                break;
            elif random_list == 2 and numbers_count > 0:
                password += choice(NUMBERS)
                numbers_count -= 1
                break;
    return password

length = int_input("What's the minimum length? ")
specials = int_input("How many special characters? ")
numbers = int_input("How many numbers? ")
password = generate_password(length, specials, numbers)
print(f"Your password is\n{password}")

