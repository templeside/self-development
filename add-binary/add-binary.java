class Solution {
    public String addBinary(String a, String b) {
        // 1. starting from the right side.
        // 2. add values
        // 3. get the move forward for coutn up
        //     0
        //     1
        //     2
        //     3
        // 4. store values
        // 5. return value.
        int a_idx = a.length()-1;
        int b_idx = b.length()-1;
        
        int countup = 0;
        String ans= "";
        while(a_idx>=0 || b_idx >=0){
            int int_a = a_idx>=0 ? a.charAt(a_idx)-'0': 0;
            int int_b = b_idx>=0 ? b.charAt(b_idx)-'0': 0;
            
            
            
            ans = (countup+ int_a+int_b)%2+ ans;
            countup = (countup+int_a+int_b)/2;
            a_idx--;
            b_idx--;
        }
        if( countup>0)
            ans = countup+ans;
        return ans;
    }
}