public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;

        int m = board.length;
        int n = board[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == word.charAt(0)) { // Start DFS if the first character matches
                    if (dfs(board, word, r, c, 0)) {
                        return true;
                    }
                }
            }
        }
        return false; // Return false if no matching path is found
    }

    public boolean dfs(char[][] board, String word, int currR, int currC, int currIdx) {
        if (currIdx >= word.length()) { // Base case: all characters matched
            return true;
        }

        int m = board.length;
        int n = board[0].length;

        // Check boundaries and whether the current cell matches the word character
        if (currR < 0 || currR >= m || currC < 0 || currC >= n || board[currR][currC] != word.charAt(currIdx)) {
            return false;
        }

        // Temporarily mark the cell as visited
        char temp = board[currR][currC];
        board[currR][currC] = '#';

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            int newR = currR + dir[0];
            int newC = currC + dir[1];
            if (dfs(board, word, newR, newC, currIdx + 1)) { // Recurse to next cell
                return true;
            }
        }

        // Revert the cell back to its original value after exploring all directions
        board[currR][currC] = temp;
        return false;
    }
}
