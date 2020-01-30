from random import randrange

def get_level():
    s = input("Pick a difficulty level (1, 2, or 3): ")
    if not s.isdigit() or int(s) < 1 or int(s) > 3:
        return get_level()
    return int(s)

def play(level):
    guesses = 0
    answer = randrange(1, 10 ** level)
    s = input("I have my number. What's your guess? ")
    while True:
        guesses += 1
        if s.isdigit():
            guess = int(s)
            if guess < answer:
                s = input("Too low. Guess again: ")
            elif guess > answer:
                s = input("Too high. Guess again: ")
            else:
                return guesses
        else:
            s = input("Invalid guess. Guess again: ")

while True:
    print("Let's play Guess the Number.")
    level = get_level()
    guesses = play(level)
    print(f"You got it in {guesses} guesses!")
    if input("Play again? ").lower().startswith("n"):
        break;
print("Goodbye!")

