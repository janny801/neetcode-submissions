# #return minimum k(banana per hour eating rate) 
# - such that u can eat all the bananas within h hours 
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        #min and max eating speeds
        left = 1
        right = max(piles) 

        #binary search for the minimum valid speed 
        while left<= right: 
            k= (left+right)//2
            total_hours= 0 #total amt of hours needed for koko to finish all the banana piles at the current eating speed k 

            #calculate hours needed at speed k 
            for pile in piles: 
                total_hours += (pile +k-1)//k 
            
            if total_hours<=k: 
                #this speed works so try a lower speed
                right = k-1
            else: 
                #this speed is too slow , increase the eating speed 
                left = k+1
        return left 
            






        