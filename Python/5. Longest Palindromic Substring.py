# 5. Longest Palindromic Substring
# Date of problem solution: 11.07.2024
# 
# def longestPalindrome(self, s: str) -> str:

def longestPalindrome(s):
    flag = True
    ln = len(s)
    result = ""
    while flag:
        for i in range(len(s) - ln + 1):
            st = s[i:(i + ln)]
            if st == st[::-1]:
                result = st
                flag = False
                break
        ln -= 1
    return result
