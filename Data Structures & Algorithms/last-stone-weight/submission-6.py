import heapq

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = []
        for stone in stones: 
            heap.append(-stone) 
        
        #heapify in place (original list is modified)
        heapq.heapify(heap) 

        while len(heap)>1: 
            first = -heapq.heappop(heap)
            second = -heapq.heappop(heap)

            if first!= second: 
                newstone = first - second 
                heapq.heappush(heap, -newstone)
        
        if len(heap) ==0: 
            return 0 
        return -heap[0]
        