class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        #min and max eating speeds
        left = 1
        right = max(piles) 

        #binary search for the minimum valid speed
        while left<=right: 
            k= (left + right)//2 #kokos eating speed(bananas per hr ) 
            hrs =0 #total hrs needed for koko to finish all banana piles - at current eating speed k 
            #calc hrs needed at speed k 
            for pile in piles: 
                hrs += (pile+k-1)//k
            if hrs <=h: 
                #valid; check slower eating speeds
                right = k-1
            else: 
                #speed to slow; increase the eating speed
                left = k+1
        return left 

        