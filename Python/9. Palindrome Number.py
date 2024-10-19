# 9. Palindrome Number
# Date of problem solution: 03.05.2024
#
# def isPalindrome(self, x: int) -> bool:

def isPalindrome(x):
    return str(x) == str(x)[::-1]
