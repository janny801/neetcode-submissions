class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums: 
            return 0 
        
        nums.sort() 
        longest= 1
        curr_streak = 1
        for i in range(1, len(nums)): 
            #check if duplicate -> continue 
            if nums[i] == nums[i-1]: 
                continue
            #check if value is 1 more greater 
            if nums[i]==nums[i-1]+1: 
                curr_streak +=1
            else: 
                #streak broke 
                longest = max(longest, curr_streak) 
                curr_streak =1
        return max(curr_streak, longest)