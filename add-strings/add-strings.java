class Solution {
    public String addStrings(String num1, String num2) {       
        String ans= "";
        
        int num1Size = num1.length();
        int num2Size = num2.length();
        
        int idx = 0;
        boolean overTen = false;
        while(idx< num1.length() || idx<num2.length()){
            int num = 0;
            if(overTen) 
                num++;
            if(idx<num1Size)
                num += num1.charAt(num1Size-idx-1)-'0' ;
            if(idx<num2Size)
                num += num2.charAt(num2Size-idx-1)-'0';
            // System.out.println(num);
            overTen = num>=10;
            
            ans = num%10 +ans;
            idx++;
        }
        
        
        if(overTen)
            return "1"+ans;
        else
            return ans;
    }
}