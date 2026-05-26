import heapq

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        heap = []

        #push all points into the heap 
        for point in points: 
            x= point[0]
            y= point[1]

            #compute the squared distance from the origin 
            distance = (x*x) + (y*y)

            #push (distance, point) into the heap 
            heapq.heappush(heap, (distance, point))
        
        result = []
        for i in range(k): 
            distance, point = heapq.heappop(heap) 
            #the pop will return a tuple 
            #storing both variables allows us to use the point variable 

            result.append(point) 

        return result 