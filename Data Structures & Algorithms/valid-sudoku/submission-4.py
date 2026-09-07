class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes= [set() for _ in range(9) ]

        for row in range(9): 
            for col in range(9): 
                value = board[row][col]

                #find out which 3x3 box the current value is in 
                box_index = (row//3) *3 + (col//3)

                #if value is empty (".") continue 
                if value == ".": 
                    continue

                

                #if value already in one of the sets return false 
                if (value in rows[row] or value in cols[col] or value in boxes[box_index]): 
                    return False
                    
                #if not yet seen then add to the sets 
                rows[row].add(value) 
                cols[col].add(value)
                boxes[box_index].add(value) 
        #return true if makes it thru all board input 
        return True
