class Solution {
    /*
Input: matrix = 
    [[5,1,9,11],        
     [2,4,8,10],
     [13,3,6,7],
     [15,14,12,16]]
     
    [[15,13,2,5],        
     [14,4,8,1],
     [12,3,6,9],
     [16,7,10,11]]
     
Output: 
    [[15,13,2,5],
     [14,3,4,1],
     [12,6,8,9],
     [16,7,10,11]]
    
    
    1. set starting index
    2. swap the rows
        - save the north rows.
        - west -> north
        - south -> west
        - east -> south
        - north -> east


	int temp = matrix[n - 1 - j][i];                    // west
	matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];// west val -> south
	matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i]; // south val -> east
	matrix[j][n - 1 - i] = matrix[i][j];                // east val -> north
	matrix[i][j] = temp;                                // north val -> west
        
        while swapping, save the prev value
    */
    public void rotate(int[][] matrix) {
        int n = matrix.length, depth = n / 2;
        for (int i = 0; i < depth; i++) {
            int len = n - 2 * i - 1, opp = n - 1 - i;
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][i+j];    
				matrix[i][i+j] = matrix[opp-j][i];        // west value -> north
                matrix[opp-j][i] = matrix[opp][opp-j];    // south value-> west
                matrix[opp][opp-j] = matrix[i+j][opp];    // east value -> south
                matrix[i+j][opp] = temp;             // north value-> east
            }
        }
    }
}