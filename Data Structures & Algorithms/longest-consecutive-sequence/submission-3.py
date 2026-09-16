#hash set solution 

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        #convert list to set (remove duplicates automatically, and o(1) lookup time) 
        num_set = set(nums) 
        longest = 0 
        #iterate thru every unique number in the list 
        for i in num_set: 
            #check if n is the start of a consecutive sequence 
            #if n-1 is in the set then 'n' is in the middle of a streak so then we skip 
            if (i-1) not in num_set: 
                length =1
                #this finds the start of a consecutive streak 
                
                #while loop checking values that are 1 greater then then the previous ones based on where we started 
                while(i+length) in num_set: 
                    length+=1
                #record the max length seen between the past sequences 
                longest = max(length, longest) 
        return longest
        