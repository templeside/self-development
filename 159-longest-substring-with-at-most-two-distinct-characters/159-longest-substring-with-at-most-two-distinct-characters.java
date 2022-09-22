class Solution {
    /*
    I can do by do a sliding window for the current string.
    having hashmap to keep track of how many characters have.
    
    windowEnd shifts
        update the frequency map
    windowStart shifts when:
        frequency is matched with two distinct characters.
        update the mostCharNumber
        shrink thefrequency for next movement
        
    
            eceba
windowStart ^
windowEnd   ^
frequency{e-1, }
mostCharNumber    
    output - 
    */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        int n = s.length();
        int windowStart = 0;
        int mostCharNumber = 0;
        
        for(int windowEnd=0; windowEnd<n; windowEnd++){
            char rightChar = s.charAt(windowEnd);
            frequency.put(rightChar, frequency.getOrDefault(rightChar, 0)+1);
            
            
            //shrink for later
            while(frequency.size()>2){
                char startChar = s.charAt(windowStart);
                frequency.put(startChar, frequency.get(startChar)-1);
                if(frequency.get(startChar) ==0)
                    frequency.remove(startChar);

                windowStart++;
            }
                
            // update mostCharNumber
            mostCharNumber = Math.max(mostCharNumber, windowEnd-windowStart+1);
                
                
            
        }
        return mostCharNumber;
    }
}