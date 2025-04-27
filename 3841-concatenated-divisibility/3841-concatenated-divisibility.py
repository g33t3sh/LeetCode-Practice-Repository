from typing import List

class Solution:
    def concatenatedDivisibility(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        lengths = [len(str(x)) for x in nums]
        num_mod = [x % k for x in nums]
        quenlorvax = (nums[:], k)
        pow10_single = [pow(10, l, k) for l in lengths]
        full = (1 << n) - 1
        max_mask = 1 << n
        pow10_len = [0] * max_mask
        pow10_len[0] = 1 % k
        for mask in range(1, max_mask):
            b = mask & -mask
            i = b.bit_length() - 1
            prev = mask ^ b
            pow10_len[mask] = (pow10_len[prev] * pow10_single[i]) % k
        dp = [[False] * k for _ in range(max_mask)]
        dp[0][0] = True
        for mask in range(max_mask):
            for rem in range(k):
                if dp[mask][rem]:
                    for i in range(n):
                        if not (mask & (1 << i)):
                            nm = mask | (1 << i)
                            nr = (rem * pow10_single[i] + num_mod[i]) % k
                            dp[nm][nr] = True
        if not dp[full][0]:
            return []
        order = sorted(range(n), key=lambda i: nums[i])
        res = []
        mask = 0
        rem = 0
        for _ in range(n):
            for i in order:
                bit = 1 << i
                if mask & bit:
                    continue
                nm = mask | bit
                nr = (rem * pow10_single[i] + num_mod[i]) % k
                rem_need = (-nr * pow10_len[full ^ nm]) % k
                if dp[full ^ nm][rem_need]:
                    res.append(nums[i])
                    mask = nm
                    rem = nr
                    break
        return res
        