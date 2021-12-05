class Solution {
private static int[] d = {0, 1, 0, -1, 0};

public void wallsAndGates(int[][] rooms) {
    for (int i = 0; i < rooms.length; i++)
        for (int j = 0; j < rooms[0].length; j++)
            if (rooms[i][j] == 0) dfs(rooms, i, j);
}

public void dfs(int[][] rooms, int i, int j) {
    for (int k = 0; k < 4; ++k) {
        int p = i + d[k], q = j + d[k + 1];
        if (0<= p && p < rooms.length && 0<= q && q < rooms[0].length && rooms[p][q] > rooms[i][j] + 1) {
            rooms[p][q] = rooms[i][j] + 1;
            dfs(rooms, p, q);
        }
    }
}

}