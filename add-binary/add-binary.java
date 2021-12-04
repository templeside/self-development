class Solution {
    public String addBinary(String a, String b) {
        // 1. two indices = aIdx, bIdx
//         counter .
        int aIdx = a.length()-1;
        int bIdx = b.length()-1;
        
        // if(aIdx == 0 || bIdx == 0) return aIdx > bIdx? a: b;
        
        StringBuilder sb = new StringBuilder();
        int carry=0; 
        while(aIdx>=0 || bIdx >=0){
            int aVal = aIdx<0 ? 0: a.charAt(aIdx)-'0';
            int bVal = bIdx<0 ? 0: b.charAt(bIdx)-'0';
            
            
            int sum = carry + aVal + bVal;
            
            System.out.println(sum);
            
            carry = sum/2;
            sb.append((char)(sum%2+'0'));
            
            aIdx --;
            bIdx--;
        }
        if(carry !=0)
            sb.append('1');
        
        return sb.reverse().toString();
        
    }
}