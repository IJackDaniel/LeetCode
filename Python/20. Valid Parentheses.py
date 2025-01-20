# 20. Valid Parentheses
# Date of problem solution: 20.01.2025

class Solution:
    def isValid(self, s: str) -> bool:
        st = ["0"]
        for i in s:
            if i in "([{":
                st.append(i)
            elif i == ")":
                if st.pop() != "(":
                    return False
            elif i == "]":
                if st.pop() != "[":
                    return False
            elif i == "}":
                if st.pop() != "{":
                    return False
        if len(st) > 1:
            return False
        return True


sol = Solution()
print(sol.isValid("()"))
print(sol.isValid("()[]{}"))
print(sol.isValid("(]"))
print(sol.isValid("([])"))
print(sol.isValid("["))
