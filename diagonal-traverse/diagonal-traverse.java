class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
//         simulation
//         upper diagonal       [1, 7,5,3, 9]
//         down diagonal        [2,4, 6,8]
//         by each movement, going to add mat[r][c].
//         
//         if(upper)
                // if(last column)
//                     r++;
//                 else if( on first row)
//                     c++;
//                 else
//                     r--;
//                      c++;
//         else
//                 if(last row)
//                     c++;
//                 else if( on first col)
//                     r++;
//                 else
//                     r++;
//                     c--;
        
        int row = mat.length;
        int col = mat[0].length;
        int[] ans = new int[row * col];
        int r=0, c=0;
        for(int i=0; i< ans.length; i++){
            ans[i] = mat[r][c];
            if((r+c)%2 ==0){    //upper diagonal
                if(c == col-1)
                    r++;
                else if(r== 0)
                    c++;
                else{
                    r--;
                    c++;
                }
            }else{
                if(r ==row-1)
                    c++;
                else if( c ==0)
                    r++;
                else{
                    r++;
                    c--;
                }
            }
        }
        return ans;
    }
}