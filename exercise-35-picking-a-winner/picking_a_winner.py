from random import randrange

def get_contestants():
    contestants = []
    while True:
        name = input("Enter a name: ")
        if len(name) == 0:
            break;
        contestants.append(name)
    return contestants

def pick_winner(contestants):
    return contestants[randrange(0, len(contestants))]

contestants = get_contestants()
if len(contestants):
    print(f"The winner is...{pick_winner(contestants)}")

