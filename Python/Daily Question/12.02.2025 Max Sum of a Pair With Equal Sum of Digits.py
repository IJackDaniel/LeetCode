# 2342. Max Sum of a Pair With Equal Sum of Digits
# 12.02.2025
# 
# Time limit exceed

class Solution:
    def maximumSum(self, nums) -> int:
        sum_nums = [sum([int(j) for j in list(str(i))]) for i in nums]
        mx = -1
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if sum_nums[i] == sum_nums[j]:
                    mx = max(mx, nums[i] + nums[j])
        return mx


sl = Solution()
print(sl.maximumSum([18,43,36,13,7]))
print(sl.maximumSum([10,12,19,14]))
print(sl.maximumSum([4,6,10,6]))
