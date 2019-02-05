PIECES_PER_PIZZA = 8

people = int(input("How many people? "))
pizzas = int(input("How many pizzas do you have? "))

total_pieces = pizzas * PIECES_PER_PIZZA
pieces_each = total_pieces // people
leftover_pieces = total_pieces % people

print(f"\n{people} people with {pizzas} pizzas\n"
      f"Each person gets {pieces_each} pieces of pizza.\n"
      f"There are {leftover_pieces} leftover pieces.")

