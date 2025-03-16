class Solution:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        n = len(nums)
        if all(num == 0 for num in nums):
            return 0
        def is_feasible(num_queries):
            for index in range(n):
                required = nums[index]
                dp = 1
                mask = (1 << (required + 1)) - 1
                for i in range(num_queries):
                    left_bound, right_bound, query_value = queries[i]
                    if left_bound <= index <= right_bound:
                        dp = dp | (dp << query_value)
                        dp &= mask
                if (dp >> required) & 1 == 0:
                    return False
            return True
        low = 0
        high = len(queries)
        answer = -1
        while low <= high:
            mid = (low + high) // 2
            if is_feasible(mid):
                answer = mid
                high = mid - 1
            else:
                low = mid + 1
        return answer
                        