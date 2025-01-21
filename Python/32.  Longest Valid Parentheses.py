# 32.  Longest Valid Parentheses
# Date of problem solution: 21.01.2025
# Задача решена, но оптимизация прям приветствуется. Этот код по скорости в топ 95%, а по памяти в топ 32%

class Solution:
    def longestValidParentheses(self, s: str) -> int:
        mx = 0
        temp = -1
        if ")" not in s:
            return 0
        for ind, val in enumerate(s):
            if val != "(" or ind < temp - 2:
                continue
            else:
                start = ind
                temp = ind

            sm = 0
            while temp < len(s):
                if s[temp] == "(":
                    sm += 1
                elif s[temp] == ")":
                    sm -= 1

                if sm < 0:
                    break
                if sm == 0:
                    mx = max(mx, temp - start + 1)
                temp += 1
        return mx


sl = Solution()
print(sl.longestValidParentheses("(()"))  # 2
print(sl.longestValidParentheses(")()())"))  # 4
print(sl.longestValidParentheses(""))  # 0
# sl.longestValidParentheses()
# sl.longestValidParentheses()
