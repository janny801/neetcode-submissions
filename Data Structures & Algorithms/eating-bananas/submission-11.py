class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        minspeed = 1
        maxspeed = max(piles)
        while left<=right: 
            eatingspeed = (minspeed+maxspeed)//2
            hourstofinish= 0
            for pile in piles: 
                hourstofinish+=(pile + eatingspeed-1) //eatingspeed
            if hourstofinish<=h: 
                #valid; check slower times
                maxspeed= eatingspeed-1
            else: 
                minspeed=eatingspeed+1
        return minspeed
        