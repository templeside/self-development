class Solution {
    public boolean isPalindrome(int x) {
        if (x<0)return false;
        List<Integer> list = new ArrayList<>();
        while(x>0){
            int remainder= x%10;
            x = x/10;
            list.add(0, remainder);
        }
        int left=0, right= list.size()-1;
        while(left<right){
            if((int)list.get(left) != (int)list.get(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}