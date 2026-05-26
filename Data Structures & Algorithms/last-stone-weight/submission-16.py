import heapq

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = []
        #implement as max heap (add to heap negative value)
        for stone in stones: 
            heapq.heappush(heap, -stone)
        
        while len(heap)>1: 
            first = -heapq.heappop(heap)
            second = -heapq.heappop(heap) 

            if first!=second: 
                #if they are different weights then add new stone back to heap 
                newstone = first - second
                heapq.heappush(heap, -newstone)
        if len(heap)==0: 
            return 0 
        return -heap[0]
