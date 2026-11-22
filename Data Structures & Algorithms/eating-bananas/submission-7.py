class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        #min and max eating speeds
        left = 1
        right = max(piles)
        while left<=right: 
            k = (left+right)//2 #kokos eating speed 
            hoursreq=0 #amt to finish all banana piles at eating speed k 
            for pile in piles:
                hoursreq += (pile + k-1)//k 
            if hoursreq <= h: 
                #valid ; check slower eating speeds
                right = k-1
            else: 
                left = k+1
        return left

        