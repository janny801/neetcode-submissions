class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #solve using hashmap 
        seen ={} #(index, value)
        for i in range(len(nums)): 
            num = nums[i]
            complement = target- num
            #check if in seen 
            if complement in seen: 
                return [seen[complement],i]
            #if not in seen add to seen 
            seen[num]=i
        