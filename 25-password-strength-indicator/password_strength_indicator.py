def password_validator(password):
    complexity = 0
    if len(password) > 0:
        if any(c.isdigit() for c in password):
            complexity = 1 # 0001
        if any(c.isalpha() for c in password):
            complexity |= 2 # 0010
        if not password.isalnum():
            complexity |= 4 # 0100
        if len(password) >= 8:
            complexity |= 8 # 1000
    return complexity

def password_strength(complexity):
    strength = "very weak"
    if complexity == 15:
        strength = "very strong"
    elif complexity >= 11:
        strength = "strong"
    elif complexity >= 2:
        strength = "weak"
    return strength

password = input("Enter the password: ")
complexity = password_validator(password)
strength = password_strength(complexity)
print(f"The password '{password}' is a {strength} password.")

