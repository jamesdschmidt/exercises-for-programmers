def is_anagram(first, second):
    if first and second and len(first) > 0 and len(first) == len(second):
        if sorted(first.lower()) == sorted(second.lower()):
            return True
    return False

print("Enter two strings and I'll tell you if they are anagrams:")
first = input("Enter the first string: ")
second = input("Enter the second string: ")
is_anagram = is_anagram(first, second)
print(f'"{first}" and "{second}" are ' \
      f'{"anargrams" if is_anagram else "not anagrams"}.')

