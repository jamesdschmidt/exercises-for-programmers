from random import randrange

answers = ["Yes", "No", "Maybe", "Ask again later"]
input("What's your question? ")
print(answers[randrange(0, len(answers))])

