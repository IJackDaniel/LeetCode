# 4. Median of Two Sorted Arrays
# Date of problem solution: 11.07.2024
#
# def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:

def findMedianSortedArrays(nums1, nums2):
    nums = sorted(nums1 + nums2)
    if len(nums) % 2 == 1:
        return float(nums[len(nums) // 2])
    else:
        a = nums[len(nums) // 2 - 1]
        b = nums[len(nums) // 2]
        return (a + b) / 2
