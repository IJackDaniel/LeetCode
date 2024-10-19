# 1717. Maximum Score From Removing Substrings
# 12.07.2024
# НЕВЫПОЛНЕНА
# def maximumGain(self, s: str, x: int, y: int) -> int:

def maximumGain(s, x, y):
    score = 0
    if x > y:
        a = "ab"
        b = "ba"
        add_a = x
        add_b = y
    else:
        a = "ba"
        b = "ab"
        add_a = y
        add_b = x

    cnt = None
    while "ab" in s or "ba" in s:
        if a in s:
            cnt = s.count(a)
            s = s.replace(a, "")
            score += add_a * cnt
        else:
            cnt = s.count(b)
            s = s.replace(b, "")
            score += add_b * cnt
    return score


print(maximumGain("cdbcbbaaabab", 4, 5))
