class Solution {
    /*
    abccccdd
    
    a -1
    b -1
    c-4
    d-2
    */
    public int longestPalindrome(String s) {
        int evenCount =0;
        int oddCount = 0;
        boolean containsOdd = false;
        Map<Character, Integer> map=new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() %2==0){
                evenCount = evenCount + entry.getValue();
            }else{
                oddCount+=entry.getValue()-1;
                containsOdd = true;
            }
        }
        return evenCount + oddCount + (containsOdd? 1:0);
    }
}