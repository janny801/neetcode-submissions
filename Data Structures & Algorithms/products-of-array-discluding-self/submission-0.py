# brute force solution 
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        length = len(nums) 
        result = []

        #outer loop: pick each index i to calculate that index's product 
        for i in range(n): 
            product = 1
            #inner loop: multiply all elements except at index i 
            for j in range(n): 
                if i != j: 
                    product *= nums[j]
            result.append(product)
        return result



