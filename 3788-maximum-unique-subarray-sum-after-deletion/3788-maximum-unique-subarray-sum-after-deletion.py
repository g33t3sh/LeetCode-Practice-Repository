class Solution:
    def maxSum(self, nums: List[int]) -> int:
        s = [x for x in set(nums) if x > 0]
        return sum(s) if len(s) else max(nums)
        