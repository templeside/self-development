class Solution {
    /*
    to find duplicates or not.
    duplicates can be palindrome.
    additionally, can have one odd character.
    
    by iterating, frequency check
    
    frequency<character, frequency> map
    for(entry: map.entrySet()){
        if even, add.
        if odd, update isOdd.
    }
    return even+isOdd.
    */
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int palindrome = 0;
        boolean isOdd = false;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() %2 ==0)
                palindrome += entry.getValue();
            else{
                palindrome += entry.getValue()-1;
                isOdd = true;
            }
        }
        return isOdd? palindrome+1: palindrome;
    }
}