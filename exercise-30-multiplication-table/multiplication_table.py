# header row
print(f"{'':>4}", end = " ")
for i in range(13):
    print(f"{i:>4}", end = " ")
print()

# rows
for i in range(13):
    print(f"{i:>4}", end = " ") # row header column
    for j in range(13): # columns
        print(f"{i * j:>4}", end = " ")
    print() # finish row

