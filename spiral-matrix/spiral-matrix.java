class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if(matrix.length ==0 ) return ans;
        int nr = matrix.length, nc = matrix[0].length;
        boolean[][] visited = new boolean[nr][nc];
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int r=0, c=0;
        int di=0;
        for(int i=0;i<nr*nc;i++){
            ans.add(matrix[r][c]);
            visited[r][c] = true;
            int newR = r+dr[di];
            int newC = c+dc[di];
            if(0<=newR && newR< nr&& 0<=newC && newC<nc && !visited[newR][newC]){
                r = newR;
                c = newC;
            }else{
                di = (di+1)%4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }
}