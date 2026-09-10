class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]

        for row in range(9): 
            for col in range(9): 
                #current value 
                currval = board[row][col]
                # find the 3x3 box the current value is in 
                boxindex = (col//3) *3 + (row//3)

                #check if empty -- then continue
                if currval ==".": 
                    continue 

                #check if duplicate -- then return false 
                if currval in rows[row ] or currval in cols[col] or currval in boxes[boxindex]: 
                    return False

                #if not add to the appropriate sets
                rows[row].add(currval)
                cols[col].add(currval)
                boxes[boxindex].add(currval)
        return True

        