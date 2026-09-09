class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]

        for row in range(9): 
            for col in range(9): 
                currval = board[row][col]

                #check if empty - if so then continue
                if currval ==".": 
                    continue

                #find out the box it is in using math 
                boxindex = (col//3) *3 + (row//3)

                #check if in any of the sets and return false since that means it is a duplicate 
                if (currval in rows[row] or currval in cols[col] or currval in boxes[boxindex]): 
                    return False
                # add to each set if not duplicate 
                rows[row].add(currval)
                cols[col].add(currval)
                boxes[boxindex].add(currval)
        return True

            
        