class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #hash map solution 
        seen = {} #(number, index) since need to return index
        for i in range(len(nums)): 
            num = nums[i]
            complement = target-num

            #if we already have seen complement (then that is the answer) 
            if complement in seen: 
                return [seen[complement],i ]


            #store current number with index 
            seen[num ] =i

     
















