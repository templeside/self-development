class Solution {
    /**
    brute force??? how?
    
    iterating, finding the way to do, subproblem.
    :)
    
    option 1: just one digit integer
    option 2: just two digit integer
    
    recursion(currIdx, currString, s, dp)
    return recursion - total numbers of ways.
    **/
    public int numDecodings(String s) {
        int currIdx=0;
        String currString ="";
        Map<String, Integer> dp = new HashMap<>();
        
        return recursion(currIdx, currString, s, dp);
    }
    
    public int recursion(int currIdx, String currString, String s, Map<String, Integer> dp){
        if(currIdx>= s.length())return 1;
        
        if(dp.containsKey(currIdx + "|" + s))
            return dp.get(currIdx + "|" + s);
        
        char currChar = s.charAt(currIdx);
        
        int c1= 0;
        if(currIdx< s.length()-1){
            char nextChar = s.charAt(currIdx+1);
            if(currChar == '1' && nextChar>='0' &&nextChar<='9'){   // 10~19
                int shift = 10*(int)(currChar-'0') + (int)(nextChar-'0');
                c1 = recursion(currIdx+2, currString+ (char)('A'+shift), s, dp);
            }
            else if(currChar == '2' && nextChar>='0' &&nextChar<='6'){  //20~16
                int shift = 10*(int)(currChar-'0') + (int)(nextChar-'0');
                c1 = recursion(currIdx+2, currString+ (char)('A'+shift), s, dp);
            }
        }
        int c2=0;
        if(currChar !='0')
            c2 = recursion(currIdx+1, currString+(char)('A'+(int)(currChar-'0')), s, dp);
        
        dp.put(currIdx + "|" + s, c1+c2);
        return dp.get(currIdx + "|" + s);
    }
}