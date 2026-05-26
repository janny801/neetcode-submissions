import heapq

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        #max heap 
            #implemented using minheap but inserting negative values
        heap=[]

        for stone in stones: 
            heap.append(-stone) 
        
        #turn the list into a heap 
        heapq.heapify(heap) 
        
        #keep smashing while we have at least two stones 
        while len(heap)>1: 
            #remove the stones (flip signs back) 
            first = -heapq.heappop(heap) 
            second = -heapq.heappop(heap) 

            #if they are not equal push the difference
            if first != second: 
                newstone = first - second
                heapq.heappush(heap, -newstone)
        
        if len(heap) ==0: 
            return 0 
        return -heap[0]