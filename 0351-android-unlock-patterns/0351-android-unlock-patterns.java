class Solution {
    /*
    sequence - k dots are true
        all dots are distinct
        must jump through previously appeared dots
        
    m - at least keys
    n - at most keys
    m<= keys <= n
    
    count the valid patterns.
    
    patterns - backtracking.
        when reaching to adjacencies: check sequence.
        checking the numbers of valid path:
            if it is same col:
                check cols are visited 
            if it is in same row: 
                check rows visited
            if it is in different row and column:
                check rows and cols 
    starting and target
    
    1 2 3 
    4 5 6
    7 8 9 
    1-[0,0]
    2-[0,1]
    3-[0,2]
    4-[1,0]
    5-[1,1]
    6-[1,2]
    7-[2,0]
    8-[2,1]
    9-[2,2]
    starting - 1[0,0]
    target -6[1,2]
    2[0,1],5[1,1]
    
    [0,0][0,1][0,2]
    [1,0][1,1][1,2]
    [2,0][2,1][2,2]
    
    */
    private int[][] jumps;
    private boolean[] visited;

    public int numberOfPatterns(int m, int n) {
        jumps = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
        visited = new boolean[10];
        int count = 0;
        count += DFS(1, 1, 0, m, n) * 4; // 1, 3, 7, 9 are symmetrical
        count += DFS(2, 1, 0, m, n) * 4; // 2, 4, 6, 8 are symmetrical
        count += DFS(5, 1, 0, m, n);
        return count;
    }

    private int DFS(int num, int len, int count, int m, int n) {
        if (len >= m) count++; // only count if moves are larger than m
        len++;
        if (len > n) return count;
        visited[num] = true;
        for (int next = 1; next <= 9; next++) {
            int jump = jumps[num][next];
            if (!visited[next] && (jump == 0 || visited[jump])) {
                count = DFS(next, len, count, m, n);
            }
        }
        visited[num] = false; // backtracking
        return count;
    }
}