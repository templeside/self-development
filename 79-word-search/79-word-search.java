class Solution {
    int[] xdir = {1,-1,0,0};
    int[] ydir = {0,0,1,-1};
        
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        
        for(int m= 0; m< board.length;m++){
            for(int n = 0; n<board[0].length; n++){
                if(board[m][n] == word.charAt(0)){
                    for(int i=0;i<4;i++){
                        int newm = m+xdir[i];
                        int newn = n+ydir[i];
                        visited[m][n] = true;
                        if(dfs(1, newm, newn, board, visited, word))
                            return true;
                        visited[m][n] = false;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int index, int m, int n, char[][] board, boolean[][] visited, String word){
        if(index >=word.length())return true;
        
        // base case when found word or found word. && when direction is not right
        if(m<0 || m>=board.length || n<0 || n>=board[0].length || visited[m][n]|| board[m][n] != word.charAt(index))
            return false;
        
        for(int i=0;i<4;i++){
            int newm = m+xdir[i];
            int newn = n+ydir[i];
            
            visited[m][n] = true;
            
            if(dfs(index+1, newm, newn, board, visited, word))
                return true;
            
            visited[m][n] = false;
        }
        return false;
        
    }
    
}