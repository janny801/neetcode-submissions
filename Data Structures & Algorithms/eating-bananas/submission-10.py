class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left =1
        right = max(piles)
        while left<=right: 
            eatingspeed = (left+right)//2
            hourstofinish=0
            for pile in piles: 
                hourstofinish+= (pile +eatingspeed-1)//eatingspeed
            if hourstofinish<=h: 
                #valid check slower eating speeds
                right = eatingspeed-1
            else: 
                left= eatingspeed+1
        return left
        