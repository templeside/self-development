class Solution {
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int nr, nc;
    boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        if(board.length ==0) return false;
        if(word.length() ==0)return true;

        nr = board.length;
        nc = board[0].length;
        
        visited = new boolean[nr][nc];
        for(int r = 0; r< nr; r++){
            for(int c =0; c< nc; c++){
                if(board[r][c] == word.charAt(0)){
                    if(dfs(board, r,c,word,0))
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int r, int c, String word,int index){
        if(index>=word.length())            //edge case
            return true;
        
        if(r<0||c<0 || r>=nr || c>= nc || visited[r][c] || board[r][c] != word.charAt(index))     //edge case 
            return false;
        
        char asdf = board[r][c] ;
        
        boolean ret = false;
        for(int[] direction : directions){
            visited[r][c] = true;
            if(dfs(board, r+direction[0], c+ direction[1], word,index+1))
                return true;
            visited[r][c] = false;
        }
        return false;
    }
}