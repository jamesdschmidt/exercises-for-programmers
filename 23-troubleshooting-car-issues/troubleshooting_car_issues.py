answer = input("Is the car silent when you turn the key? ")
if answer.lower().startswith("y"):
    answer = input("Are the battery terminals corroded? ")
    if answer.lower().startswith("y"):
        print("Clean terminals and try starting again.")
    else:
        print("Replace cables and try again.")
else:
    answer = input("Does the car make a clicking noise? ")
    if answer.lower().startswith("y"):
        print("Replace the battery.")
    else:
        answer = input("Does the car crank up but fail to start? ")
        if answer.lower().startswith("y"):
            print("Check spark plug connections.")
        else:
            answer = input("Does the engine start and then die? ")
            if answer.lower().startswith("y"):
                answer = input("Does your car have fuel injection? ")
                if answer.lower().startswith("y"):
                    print("Get it in for service.")
                else:
                    print("Check to ensure the choke is opening and closing.")

