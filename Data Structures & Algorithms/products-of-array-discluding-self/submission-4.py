class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        length = len(nums)
        
        #create arrays to hold prefix and suffix products 
        prefixArr= [1]* length 
        suffixArr = [1]* length 
        resultArr = [0] * length #0 as placeholder, doesnt matter since we overwrite 

        #store prefix values (products to the left of current index at each step ) 
        prefix = 1
        for i in range(length): 
            prefixArr[i] = prefix 
            prefix *= nums[i]

        #store suffix values (products of elements to the right of current index i )
        suffix = 1
        for i in range(length -1, -1, -1): #iterate thru array from right to left 
            suffixArr[i] = suffix 
            suffix *= nums[i]

        #multiply prefix and suffix arrays together 
        for i in range(length): 
            resultArr[i] = prefixArr[i] * suffixArr[i]
        
        return resultArr



