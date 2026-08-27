class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        length = len(nums) 
        #create prefix , suffix and result arrays 
        prefixArr = [1] * length #1 is multiplicative index
        suffixArr = [1] * length #1 is multiplicative index 
        resultArr = [0] * length #0 placeholder ; will be overwritten 

        #fill prefix array (values to the left of the current value at that index) 
        prefix = 1
        for i in range(length): 
            prefixArr[i] = prefix
            prefix*= nums[i]

        #fill suffix array ( values to the right of the current value at that index) 
        suffix = 1
        for i in range(length -1, -1, -1 ): 
            suffixArr[i] = suffix 
            suffix*= nums[i] 

        #multiply arrays together 
        for i in range(length): 
            resultArr[i] = prefixArr[i] * suffixArr[i]
        
        return resultArr

        