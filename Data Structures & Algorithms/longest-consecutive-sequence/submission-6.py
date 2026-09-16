class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        #convert to set 
        numset = set(nums) 
        longest = 0
        for num in numset: 
            if (num-1) not in numset: 
                length =1 
                while (num+length) + 1 in numset: 
                    length +=1
                    
                    longest= max(length,longest)

        return longest