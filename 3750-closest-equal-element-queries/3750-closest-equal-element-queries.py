class Solution:
    def solveQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        n = len(nums)
        pos_map = defaultdict(list)
        for idx, num in enumerate(nums):
            pos_map[num].append(idx)
        
        result = []
        for q in queries:
            val = nums[q]
            indices = pos_map[val]
            if len(indices) == 1:
                result.append(-1)
                continue
            
            pos = bisect.bisect_left(indices, q)
            
            left_neighbor = indices[pos - 1]
            right_neighbor = indices[(pos + 1) % len(indices)]
            
            def circular_distance(i, j):
                diff = abs(i - j)
                return min(diff, n - diff)
            
            d_left = circular_distance(q, left_neighbor)
            d_right = circular_distance(q, right_neighbor)
            answer = min(d_left, d_right)
            
            result.append(answer)
        
        return result