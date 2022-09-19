class Solution {
/*
Input: matrix = 
[[5 ,1 ,9 ,11]
,[2 ,4 ,8 ,10]
,[13,3 ,6 ,7]
,[15,14,12,16]]
                                offsetShift prev -> curr
                                
[(0,0) (0,1) (0,2) (0,3)]       0,3 | 1,2 | 2,1 | 3,3 
[(1,0) (1,1) (1,2) (1,3)]       3,0 | 2,1 | 1,2 | 0,3
[(2,0) (2,1) (2,2) (2,3)]       0,-3|-1,-2|-2,-1|-3,0
[(3,0) (3,1) (3,2) (3,3)]       saving point....

Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

i should think of line by line. 
starting from the outline, moving inward by hitting the lineLength<2.

recursion problem.
length of the line is decreasing in n-2. ex)6-4-2
having two forloop

recursion(lineLegth(n-2), topleft currIdx, matrix):
    int[] topleft, topright, bottomright, bottomleft.
    
    for(int i=0; i< currlength; i++) // with shifts
        1. saving west first 
        2. north -> east    matrix[topright+i][topright+ length-i] = matrix[topleft][topleft]
        3. east -> south    matrix[r+length][c] = matrix[r][c]
        4. south -> west    matrix[r-length][c] = matrix[r][c]
        5. west-> north     matrix[r+i][c+i] = saved[i]

time complexity: O(N/2)

division of 2, get the length from inward to outward, trying to get the 
[[1,2,3]
,[4,5,6]
,[7,8,9]]
recursion(0, n, new int[]{0,0}, matrix);
[[1,2,1]
,[4,5,6]
,[9,8,9]]
currIdx=0, n=3
i=0
int temp = matrix[2][0] -> 7;// temporary west value
matrix[0][2] = matrix[0][0]; //north -> east
matrix[2][0] = matrix[2][2]; //east -> north
matrix[0][0] = matrix[currIdx+n-1][currIdx+i];
matrix[currIdx][currIdx+i] = temp;

*/
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
    public void tostring(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}