# 2501. Longest Square Streak in an Array
# 28.10.2024
# 
# def longestSquareStreak(self, nums: List[int]) -> int:

def longestSquareStreak(arr):
    result = -1
    arr = sorted(set(arr))
    n = len(arr)
    i = 0
    while arr[i] <= int(arr[-1] ** (1 / 3) + arr[0] * 2) and i < n - 1:
        cnt = 1
        num = arr[i] ** 2
        while num in arr:
            cnt += 1
            num **= 2
        result = max(result, cnt)
        i += 1
    return result if result != 1 else -1


# nums = [4, 3, 6, 16, 8, 2]
# nums = [4,17,16,11,7,12,16,18,7,5]
nums = [2, 2]
print(longestSquareStreak(nums))
