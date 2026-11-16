class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums)-1
        while left<=right: 
            mid = (left+right)//2
            if nums[mid]== target: 
                return mid
            elif nums[mid] < target: 
                #search right side
                left = mid +1
            else:
                #search left side  
                right = mid -1
        #no target found 
        return -1; 