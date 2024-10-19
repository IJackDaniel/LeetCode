# 1. Two Sum
# Date of problem solution: 21.03.2024
# 
# def twoSum(self, nums: List[int], target: int) -> List[int]:

def twoSum(nums, target):
    for i in range(len(nums)):
        num2 = target-nums[i]
        if num2 in nums and nums.index(num2) != i:
            return [i, nums.index(num2)]