class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #solve with hash map 
        seen = {}

        for i in range(len(nums)): 
            num = nums[i]
            complement = target-num 

            #if we find complement in seen then 
            #return [index of complement, i (current ind) ]
            if complement in seen: 
                return [seen[complement],i ]

            
            #otherwise add it to the seen hashmap 
            seen[num] =i