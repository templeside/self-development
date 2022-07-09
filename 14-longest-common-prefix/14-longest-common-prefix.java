class Solution {
/**
brute force - index iteration -
Input: strs = [
"flower",
 ^
"flow",
 ^
"flight"
 ^
 ]

for iteration, copmare the strings. after that, substring the values.
time complexity: O(k) where k is the length of the longest prefix.
Output: "fl"

**/
    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==0) return "";
        int minLen = Integer.MAX_VALUE;
        
        for(int i=0; i<strs.length; i++){
            minLen = Math.min(minLen, strs[i].length());
        }
        
        int i=0;
        while(i<minLen){
            char c = strs[0].charAt(i);
            for(String s: strs){
                if(c != s.charAt(i))
                    return strs[0].substring(0,i);
            }
            i++;
        }
        
        return strs[0].substring(0,i);
    }
}