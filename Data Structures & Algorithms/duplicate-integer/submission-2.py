class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        #solve using hash set (simplest solution i think) 
        seen = set()
        for num in nums: 
            #if in seen then return true
            if num in seen: 
                return True
            #otherwise add to the seen set 
            seen.add(num) 

        return False #no duplicates after going thru whole thing 
        