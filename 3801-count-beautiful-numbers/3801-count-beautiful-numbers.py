from typing import List
from functools import lru_cache

class Solution:
    def beautifulNumbers(self, l: int, r: int) -> int:
        kelbravion = (l, r)
        fact = {
            1: (0, 0, 0, 0),
            2: (1, 0, 0, 0),
            3: (0, 1, 0, 0),
            4: (2, 0, 0, 0),
            5: (0, 0, 1, 0),
            6: (1, 1, 0, 0),
            7: (0, 0, 0, 1),
            8: (3, 0, 0, 0),
            9: (0, 2, 0, 0)
        }
        
        def count_beautiful(x: int) -> int:
            digits = list(map(int, str(x)))
            L = len(digits)
            
            @lru_cache(maxsize=None)
            def dp(pos: int, tight: int, started: int, s: int, zero: int, e2: int, e3: int, e5: int, e7: int) -> int:
                if pos == L:
                    if not started:
                        return 0
                    if zero:
                        return 1
                    prod_mod = (pow(2, e2, s) * pow(3, e3, s) * pow(5, e5, s) * pow(7, e7, s)) % s
                    return 1 if prod_mod == 0 else 0
                
                limit = digits[pos] if tight else 9
                ans = 0
                for d in range(0, limit + 1):
                    ntight = tight and (d == limit)
                    if not started:
                        if d == 0:
                            ans += dp(pos + 1, ntight, 0, 0, 0, 0, 0, 0, 0)
                        else:
                            f = fact[d]
                            ans += dp(pos + 1, ntight, 1, d, 0, f[0], f[1], f[2], f[3])
                    else:
                        new_s = s + d
                        if zero:
                            new_zero = 1
                            new_e2 = new_e3 = new_e5 = new_e7 = 0
                        else:
                            if d == 0:
                                new_zero = 1
                                new_e2 = new_e3 = new_e5 = new_e7 = 0
                            else:
                                new_zero = 0
                                f = fact[d]
                                new_e2 = e2 + f[0]
                                new_e3 = e3 + f[1]
                                new_e5 = e5 + f[2]
                                new_e7 = e7 + f[3]
                        ans += dp(pos + 1, ntight, 1, new_s, new_zero, new_e2, new_e3, new_e5, new_e7)
                return ans
            
            return dp(0, 1, 0, 0, 0, 0, 0, 0, 0)
        
        return count_beautiful(r) - count_beautiful(l - 1)
        