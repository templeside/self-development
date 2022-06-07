class Solution {
    /**
    intuition I thought I could use backtracking, iterating through all of each characters and decrementing the k until reaches to 0. 
    In this case, Time complexity: O(2^N)
    
    however, the s is string and we should only know the longest repeating character, we can use. 
    
            ABAB, K=2
windowStart ^
windowEnd     ^
    
    returnVal = 2
    k=1
    
    first we need to count the maximum count and check it is valid with K replacables.
    if the currMax is not valid, move window start position to make it valid.
    
    then update the returnVal comparing with current max.
    
    windowEnd - windowStart +1 = current window
    **/
    public int characterReplacement(String s, int k) {
        int windowStart = 0;
        int currMax =0;
        int returnVal = 0;
        HashMap<Character, Integer> counter = new HashMap<>();
        
        for(int windowEnd =0; windowEnd< s.length(); windowEnd++){
            char endChar = s.charAt(windowEnd);
            counter.put(endChar, counter.getOrDefault(endChar, 0)+1);
            
            currMax = Math.max(currMax, counter.get(endChar));
            
            if(windowEnd-windowStart+1 -currMax>k){
                char startChar = s.charAt(windowStart);
                counter.put(startChar, counter.get(startChar)-1);
                windowStart ++;
            }
            returnVal = Math.max(returnVal, windowEnd-windowStart+1);
        }
        return returnVal;
    }
}