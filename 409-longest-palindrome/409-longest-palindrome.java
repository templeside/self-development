class Solution {
/**
palindrome should be 
find the palindrome index, and compare with the i+1, i-1.

Input: s = "abccccdd"
one odd value, even numbers 
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.


**/
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for(char c: s.toCharArray()){
            counter.put(c, counter.getOrDefault(c, 0)+1);
        }
        
        boolean isOdd = false;
        int count = 0;
        for(char key : counter.keySet()){
            int val = counter.get(key);
            count += (val/2)*2;
            
            if(val%2 ==1 && !isOdd)
                isOdd=true;
        }
        
        return isOdd? count+1: count;
    }
}