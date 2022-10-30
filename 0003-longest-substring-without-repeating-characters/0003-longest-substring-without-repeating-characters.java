class Solution {
    /*
    slidingwindow
    to make it sure the problem is containing.
    windowstart, windowEnd to keep track of the size of the substring.
    keep track of the character types and numbers.
    int[] charfrequency = new int[26];
    
    while increasing window end index,
    checking the windows start index.
    then check the longest substring wihtout repeating characters.
    */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int windowStart = 0;
        int[] frequency = new int[256];
        // s= s.toLowerCase();
        int maxLength = 0;
        
        for(int windowEnd=0; windowEnd< n; windowEnd++){
            char endChar = s.charAt(windowEnd);
            frequency[endChar] ++;

            while(frequency[endChar]>1){
                char startChar = s.charAt(windowStart);
                frequency[startChar]--;
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd- windowStart+1);
        }
        
        return maxLength;
    }
}