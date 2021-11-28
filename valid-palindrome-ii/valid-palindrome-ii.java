class Solution {
    public boolean validPalindrome(String s) {
        int left =0, right =s.length()-1,  life =1;
        return valid(s, left, right, life);
    }
    
    public boolean valid(String s, int left, int right, int life){
        if(life <0)return false;
        if(right<=left)return true;
        
        if(s.charAt(left) != s.charAt(right)){
            return valid(s, left+1, right, life-1) || valid(s, left, right-1, life-1);
        }else
            return valid(s, left+1, right-1, life);
    }
}