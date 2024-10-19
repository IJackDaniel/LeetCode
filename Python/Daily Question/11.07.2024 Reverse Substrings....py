# 1190. Reverse Substrings Between Each Pair of Parentheses
# 11.07.2024
#
# def reverseParentheses(self, s: str) -> str:

def reverseParentheses(s):
    while "(" in s:
        right = s.index(")")
        left = right-1
        section = s[left:right + 1]
        while "(" not in section:
            left -= 1
            section = s[left:right + 1]
        rev_section = section[1:-1]
        rev_section = rev_section[::-1]
        s = s.replace(section, rev_section)
    return s






print(reverseParentheses("(abcd)"))
print(reverseParentheses("(u(love)i)"))
print(reverseParentheses("(ed(et(oc))el)"))
