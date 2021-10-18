class Solution {
    public String addBinary(String a, String b) {
        int a_idx = a.length()-1;
        int b_idx = b.length()-1;
        String ans = "";
        
        int countup=0;
        while(a_idx>=0 || b_idx >=0){
            int a_int = a_idx>=0? a.charAt(a_idx)-'0':0;
            int b_int = b_idx>=0? b.charAt(b_idx)-'0':0;
            ans = (countup + a_int+b_int)%2+ ans;
            
            countup = (countup+a_int+b_int)/2;
            a_idx--;
            b_idx--;
        }
        return countup>0? (countup+ans):ans;
    }
}