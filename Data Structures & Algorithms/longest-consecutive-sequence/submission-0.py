#simple solution 
    # sort first -> then find consecutive numbers from there 

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        #base case ; if the input list is empty 
        if not nums: 
            return 0  #ie streak of 0 
        
        #sort nums in ascending order 
        nums.sort()

        #track global max length and current max length 
        #start at 1 since any non empty array contains at least one number (ie; sequence of 1 already exists )
            #base case would already handle 0 / empty 
        longest = 1 
        curr_streak = 1

        #iterate thru the list starting at the 2nd element 
        for i in range(1, len(nums)): 
            #current number is the same as the prev -> ignore it 
            if nums[i] == nums[i-1]: 
                continue
            #if current number is 1 greater then the previous one - extend the chain and check if need to update globals 
            if nums[i] == nums[i-1]+1: 
                #streak continues - update value 
                curr_streak +=1
            else: 
                #the streak broke - update values based on whichever global is larger 
                longest = max(curr_streak, longest)
                curr_streak = 1 #set back to 1 for further iterations
        return max(longest, curr_streak) 



