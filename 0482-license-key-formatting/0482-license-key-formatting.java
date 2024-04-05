class Solution {
    /*
    starting from back,count k vals.
    add it to the string.
    */
    public String licenseKeyFormatting(String s, int k) {
        int count=k;
        StringBuilder sb = new StringBuilder();
        
        for(int i=s.length()-1; i>=0;i--){
            char c = Character.toUpperCase(s.charAt(i));
            if(!Character.isLetterOrDigit(c))   //base case
                continue;
            
            sb.insert(0, c);
            count--;
            if(count ==0){
                sb.insert(0,'-');
                count = k;
            }
        }
        
        if(count ==k && sb.length()>0)
            sb.deleteCharAt(0);
        return sb.toString();
    }
}