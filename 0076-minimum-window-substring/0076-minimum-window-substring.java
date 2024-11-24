class Solution {
    /*
    data structure:
        int matched
        Map<Char, Integer> frequency
    algo:
    matched chars
    first, keep t frequency

    while incrementing:
        if(contains key)
            count
        update matched
        
    decrement
        update window
        decrement 
        update matched
    */
    public String minWindow(String s, String t) {
        String min = s+" ";
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();
        for(char c: t.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }
        int matched = 0;
        int endIdx= 0;
        for(int startIdx=0; startIdx< n; startIdx++){
            char currChar = s.charAt(startIdx);
            if(!freq.containsKey(currChar)){
                continue;
            }
            freq.put(currChar, freq.get(currChar)-1);
            if(freq.get(currChar) ==0)
                matched++;
            
            while(matched == freq.size()){
                if(min.length()> startIdx-endIdx+1){
                    min = s.substring(endIdx, startIdx+1);
                }
                char endChar = s.charAt(endIdx);
                endIdx++;
                if(freq.containsKey(endChar)){
                    if(freq.get(endChar)==0)
                        matched--;
                    freq.put(endChar, freq.get(endChar)+1);
                }
            }
        }
        return min.equals(s+" ")? "": min;
    }
}