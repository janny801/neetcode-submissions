class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #solve using hash map 
        seen = {}
        for i in range(len(nums)): 
            num = nums[i]
            complement = target- num

            if complement in seen: 
                return [seen[complement],i ]

            #if not in seen hash map then add it 
            seen[num] = i