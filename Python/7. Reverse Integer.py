# 7. Reverse Integer
# Date of problem solution: 22.01.2025

class Solution:
    def reverse(self, x: int) -> int:
        flag = x > 0
        x = abs(x)

        res = 0
        i = 10**(len(str(x)) - 1)
        while x != 0:
            res += (x % 10) * i
            x //= 10
            i //= 10

        if res <= -2**31 or res >= 2**31 - 1:
            return 0

        return res if flag else -res


sl = Solution()
print(sl.reverse(123))
print(sl.reverse(-123))
print(sl.reverse(120))
print(sl.reverse(1534236469))

