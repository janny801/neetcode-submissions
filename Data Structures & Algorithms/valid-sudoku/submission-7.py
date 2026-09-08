class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]

        for row in range (9): 
            for col in range(9): 
                currval = board[row][col]
                if currval ==".": 
                    continue #empty so continue 
                #find out what box index it is in 
                box_index = (row//3)*3 + (col//3)
                if (currval in rows[row] or currval in cols[col] or currval in boxes[box_index]): 
                    return False

                #add to sets if not duplicate 
                rows[row].add(currval) 
                cols[col].add(currval) 
                boxes[box_index].add(currval)

        return True