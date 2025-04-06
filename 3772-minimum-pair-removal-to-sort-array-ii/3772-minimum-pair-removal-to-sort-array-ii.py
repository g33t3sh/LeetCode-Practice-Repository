import heapq

class Node:
    def __init__(self, a, b):
        self.a = a
        self.b = b
        self.prev = None
        self.next = None
        self.removed = False

class Pair:
    def __init__(self, a, b):
        self.a = a
        self.b = b
    
    def __lt__(self, other):
        if self.a == other.a:
            return self.b.b < other.b.b
        return self.a < other.a


class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        a = nums
        b = list(map(int, a))
        c = len(b)
        if c == 0:
            return 0
        d = Node(b[0], 0)
        e = d
        f = 1
        while f < c:
            g = Node(b[f], f)
            g.prev = e
            e.next = g
            e = g
            f += 1
        h = 0
        i = d
        while i and i.next:
            if i.a > i.next.a:
                h += 1
            i = i.next
        j = []
        i = d
        while i and i.next:
            heapq.heappush(j, Pair(i.a + i.next.a, i))
            i = i.next
        k = 0
        while h > 0 and j:
            l = heapq.heappop(j)
            m = l.b
            if m.removed or not m.next or m.next.removed:
                continue
            if m.a + m.next.a != l.a:
                continue
            n = m.next
            if m.prev and m.prev.a > m.a:
                h -= 1
            if n.next and n.a > n.next.a:
                h -= 1
            if m.a > n.a:
                h -= 1
            o = Node(m.a + n.a, m.b)
            o.prev = m.prev
            o.next = n.next
            if o.prev:
                o.prev.next = o
                if o.prev.a > o.a:
                    h += 1
            if o.next:
                o.next.prev = o
                if o.a > o.next.a:
                    h += 1
            m.removed = True
            n.removed = True
            k += 1
            if o.prev:
                heapq.heappush(j, Pair(o.prev.a + o.a, o.prev))
            if o.next:
                heapq.heappush(j, Pair(o.a + o.next.a, o))
        return k