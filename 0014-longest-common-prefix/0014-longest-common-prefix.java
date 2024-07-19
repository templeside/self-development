class Solution {
    /*
    for loop:
        find prefix.
    */
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs[0];
        for(int i=1; i< strs.length; i++){
            commonPrefix = findPrefix(strs[i], commonPrefix);
        }
        return commonPrefix;
    }
    
    public String findPrefix(String a, String b){
        String shorter = a.length()< b.length()? a:b;
        String longer = shorter.equals(a)? b: a;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i< shorter.length(); i++){
            if(a.charAt(i) != b.charAt(i))
                break;
            
            sb.append(a.charAt(i));
        }
        return sb.toString();
    }
}