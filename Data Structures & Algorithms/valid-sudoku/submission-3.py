class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # return true if board is valid , otherwise return false 
        # board doesnt need to be full or valid to be true 
            #only the current numbers visible on the board 

        #use set (hashing under the hood in python) 
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]

        for row in range(9): 
            for col in range(9): 
                value = board[row][col]

                #only validate using existing nums , ignore empty 
                if value == ".": 
                    continue
                
                #identify which 3x3 box current [r][c] is in 
                box_index = (row//3)*3 + (col//3) #floor div 

                #duplicate check 
                #if value is already in this row, col or box then return false 
                if (value in rows[row] or value in cols[col] or value in boxes[box_index]): 
                    return False 
                
                #if not yet seen , add to set for future checks 
                rows[row].add(value) 
                cols[col].add(value) 
                boxes[box_index].add(value) 
        
        #if duplicate is never found then current board is valid 
        return True




        