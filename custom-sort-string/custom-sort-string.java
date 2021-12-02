class Solution {
    public String customSortString(String order, String s) {
        // 1.  save on to the int[]
        // 2.  append on to the sb.
        int[] count = new int[26];
        
        
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c: order.toCharArray()){
            int idx = c-'a';
            while(count[idx] >0){
                sb.append(c);
                count[idx]--;
            }
        }
        
        for(char c: s.toCharArray()){
            int idx = c-'a';
            if(count[idx]!=0)
                sb.append(c);
        }

        return sb.toString();
        
    }
}