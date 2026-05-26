#return the kth largest element in sorted order 
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap =[]
        for num in nums: 
            heapq.heappush(heap,num)
            #if heap grows larger then 'k' then remove the last element 
            if len(heap) > k: 
                heapq.heappop(heap) 
        #return root 
        return heap[0]