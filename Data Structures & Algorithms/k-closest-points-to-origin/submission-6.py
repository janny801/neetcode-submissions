import heapq
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        heap = []
        for point in points: 
            x= point[0]
            y= point [1]
            distance = (x*x) + (y*y) 

            heapq.heappush(heap, (distance, point))
        result = []
        for i in range(k): 
            distance, point = heapq.heappop(heap)
            result.append(point) 
        return result