class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        #solve using hashmap 
        seen = {}
        for i in nums: 
            #if in seen then return true 
            if i in seen: 
                return True
            else: 
                #add to seen map 
                seen.append(i) 
        return False
                
            #return false outside
        