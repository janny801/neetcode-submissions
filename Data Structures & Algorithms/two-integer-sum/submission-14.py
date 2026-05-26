class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #solve using hashmap 
        seen = {} # (value, index)
        for i in range(len(nums)): 
            num = nums[i]
            complement = target - num
            if complement in seen: 
                return [seen[complement], i]
            else: 
                seen[num]=i
        