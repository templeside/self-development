class Solution {
    /*
    just check all the variations that are available.
    for each coordinate, which has vlue, find below:
        1. isValidRows
        2. isValidCols
        3. isValidgrids
        // if found invalid, return false
        
    //if not found invalid, that means it is valid sudoku
    */
    public boolean isValidSudoku(char[][] board) {
        // just check all the variations that are available.
        
        // 1. isValidRows
        for(int r=0; r< 9; r++){
            boolean[] visitedRows = new boolean[9];
            for(int c=0; c<9; c++){
                if(board[r][c] !='.'){
                    int val = board[r][c] -'0';
                    if(visitedRows[val-1])
                        return false;
                    visitedRows[val-1] = true;
                }
            }
        }
        
        // 2. isValidCols
        for(int c =0; c< 9; c++){
            boolean[] visitedCols = new boolean[9];
            for(int r = 0; r< 9; r++){
                if(board[r][c] !='.'){
                    int val = board[r][c] -'0';
                    if(visitedCols[val-1])
                        return false;
                    visitedCols[val-1] = true;
                }
            }
        }
        
        // 3. isValidgrids
        for(int r=0; r< 3; r++){
            for(int c= 0; c<3; c++){
                boolean[] visitedGrid = new boolean[9];
                
                for(int gridR = r*3; gridR< r*3+3; gridR++){
                    for(int gridC = c*3; gridC< c*3+3; gridC++){
                        if(board[gridR][gridC] !='.'){
                            int val = board[gridR][gridC] -'0';
                            if(visitedGrid[val-1])
                                return false;
                            visitedGrid[val-1] = true;
                        }
                    }
                }

            }
        }
        // if found invalid, return false
        return true;        
    //if not found invalid, that means it is valid sudoku
    }
}












