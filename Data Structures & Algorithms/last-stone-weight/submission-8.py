class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = []
        for stone in stones: 
            heap.append(-stone) 
        heapq.heapify(heap)
        while len(heap)>1: 
            #keep going until less than or equal to 2 
            first = -heapq.heappop(heap) 
            second = -heapq.heappop(heap) 
            if first != second: 
                newstone = first - second 
                heapq.heappush(heap, -newstone) 
        if len(heap)==0: 
            return 0 
        return -heap[0]