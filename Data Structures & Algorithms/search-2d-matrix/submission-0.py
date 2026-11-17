class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix) 
        cols = len(matrix[0])

        left = 0
        right = rows*cols -1

        while left<=right: 
            mid = (left + right)//2
            
            #convert the 1d index to row and cols values 
            row = mid//cols
            col = mid%cols

            #get the value at the middle position 
            value = matrix[row][col]

            if value ==target: 
                return True
            elif value < target: 
                #search the right half
                left = mid +1
            else: 
                #search the left half 
                right = mid-1
        
        #target not found
        return False
        