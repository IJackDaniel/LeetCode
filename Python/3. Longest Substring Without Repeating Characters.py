# 3. Longest Substring Without Repeating Characters
# Date of problem solution: 21.06.2024
#
# def lengthOfLongestSubstring(self, s: str) -> int:

def lengthOfLongestSubstring(s):
    mx = 0
    for i in range(len(s)):
        max_str = s[i]
        for j in range(i + 1, len(s)):
            if s[j] in max_str:
                break
            max_str += s[j]
        mx = max(mx, len(max_str))
    return mx
