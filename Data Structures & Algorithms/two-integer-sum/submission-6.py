class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #solve using hashmap 
        seen = {}
        for i in range(len(nums)): 
            num = nums[i]
            complement = target- num 

            #if complement in seen array 
                #return the index along with current index(i) 
            if complement in seen: 
                return [seen[complement],i ]
            
            #add to seen hashmap 
            seen[num] = i 