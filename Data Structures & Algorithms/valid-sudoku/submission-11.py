class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]

        for row in range(9): 
            for col in range(9): 
                #get current value 
                currval = board[row][col]
                #get current 3x3 box the current one is located in 
                boxindex = (row//3)*3 + (col//3)
                #if empty then continue 
                if currval == ".": 
                    continue
                #check if duplicate 
                if currval in rows[row] or currval in cols[col] or currval in boxes[boxindex]: 
                    return False 
                # add to sets if not duplicate 
                rows[row].add(currval) 
                cols[col].add(currval)
                boxes[boxindex].add(currval)
        return True
        