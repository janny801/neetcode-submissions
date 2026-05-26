import heapq

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = []
        for stone in stones: 
            heapq.heappush(heap, -stone)
        
        while len(heap) >1: 
            #keep going while length greater then 1
            #constraint for smashing rocks tg 
            first= -heapq.heappop(heap) 
            second = -heapq.heappop(heap) 
            if first != second: 
                newstone = first - second 
                heapq.heappush(heap, -newstone) 
        if len(heap) ==0: 
            return 0 
        return -heap[0]

