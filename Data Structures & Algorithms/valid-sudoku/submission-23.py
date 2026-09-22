class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes= [set() for _ in range(9)]

        for row in range(9): 
            for col in range(9): 
                currval = board[row][col]
                if currval == ".": 
                    continue
                boxidx= (row//3)*3 + (col//3)
                if currval in rows[row] or curval in cols[col] or currval in boxes[boxidx]: 
                    return False

                rows[row].add(currval)
                cols[col].add(currval)
                boxes[boxidx].add(currval)
        return True
        