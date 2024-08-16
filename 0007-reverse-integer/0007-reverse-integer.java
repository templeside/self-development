// class Solution {
//     /*
//     123
//     %10
//     3
//     */
//     public int reverse(int x) {
//         boolean isNegative = x<0;
//         x= Math.abs(x);
//         int result=  0;
//         while(x>0){
//             result *=10;
//             result+= x%10;
//             x = x/10;
//         }
//         return isNegative?-result:result;
//     }
// }

class Solution {
    public int reverse(int x) {
        int result =0;
        
        while(x!=0){
            int temp = x%10;
            int newResult = result *10 + temp;
            
            if((newResult-temp)/10 != result)
                return 0;
            result = newResult;
            x=x/10;
        }
        return result;
    }
}