class Solution {
    public static boolean exist(char[][] grid, String word) {
        // Replace this placeholder return statement with your code
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int r=0; r< grid.length; r++){
            for(int c=0; c< grid[0].length; c++){
                visited[r][c] = true;
                if(backtrack(r, c, ""+ grid[r][c], grid, word, visited))
                    return true;
                visited[r][c] = false;
            }
        }
        return  false;
    }
    public static int[] xdir = new int[]{1,-1,0,0};
    public static int[] ydir = new int[]{0,0,1,-1};
    public static boolean backtrack(int r, int c, String currStr, char[][] grid, String word, boolean[][] visited){
        if(!word.startsWith(currStr))
            return false;
        
        if(currStr.length() == word.length()){
            return true;
        }

        for(int i=0; i< 4; i++){
            int newR = r+ xdir[i];
            int newC = c+ ydir[i];

            if(newR>=0 && newR<grid.length && newC>=0 && newC<grid[0].length && grid[newR][newC] == word.charAt(currStr.length()) && !visited[newR][newC]){
                visited[newR][newC] = true;
                boolean ans = backtrack(newR, newC , currStr + grid[newR][newC], grid, word, visited);
                visited[newR][newC] = false;
                if(ans)
                    return true;
            }
        }
        return false;
    }

}