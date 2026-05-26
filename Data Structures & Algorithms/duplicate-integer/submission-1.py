class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        #now solve using a hash set 
        #detects duplicates while iterating (not after) 
        seen = set()

        for num in nums: 
            if num in seen: 
                return True
            #if not found in seen add to seen set 
            seen.add(num) 
        return False #no duplicates found 

        