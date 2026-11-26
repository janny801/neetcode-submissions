class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        minspeed =0
        maxspeed=max(piles)
        while minspeed<=maxspeed: 
            eatingspeed= (minspeed+maxsped)//2
            hoursreq=0
            for pile in piles: 
                hoursreq+= (eatingspeed+pile-1)//eatingspeed
            if hoursreq <= h: 
                #valid ; check slower eating speeds
                maxspeed= eatingspeed-1
            else: 
                #not valid; check faster eating speeds
                minspeed=eatingspeed+1
        return minspeed
        