from random import choice

def get_contestants():
    contestants = []
    while True:
        name = input("Enter a name: ")
        if len(name) == 0:
            break;
        contestants.append(name)
    return contestants

contestants = get_contestants()
if len(contestants):
    print(f"The winner is...{choice(contestants)}")

