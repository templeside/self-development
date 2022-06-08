class Solution {
    /**
    for my intuition, I think I am goind to use sliding window because I need to move forward and shrink as much I have the amount of t's characters. so that I can get the O(N).
           
having the hashmap to count the characters are matched with t.
I would shrink it out when having the full match with the t's characters to avoid matching.

    ex) s= "ADOBECODEB A  N  C", t = "ABC"
            012345678910,11,12
windowStart  ^
windowEnd        ^
p_counter = [A:0, B:0,C:0]
matched = 3;
the output = ADOBEC;

what is the criteria to shrink the window size????? 
    **/
    public String minWindow(String s, String t) {        
        // 1. count all the t's characters
        Map<Character,Integer> tCount= new HashMap<>();
        for(int i=0; i<t.length(); i++){
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i),0)+1);// character, count
        }
        int tTotal=tCount.size();
        
        // 2. move end pointer until the window(start pointer, end pointer) contains all the t's characters
        int endPtr=0;
        int startPtr=0;
        String globalMin="";
        
        Map<Character,Integer> windowCounts= new HashMap<>();
        int satisfied=0;
        
        while(endPtr<s.length()){
            char c=s.charAt(endPtr);
            windowCounts.put(c, windowCounts.getOrDefault(c,0)+1);
            
            if(tCount.containsKey(c) &&
              windowCounts.get(c).intValue()==tCount.get(c).intValue()) satisfied++;
            
            // 3. move start pointer to reduce the sliding window length - stops when it no longer contains all the t's characters
            while(startPtr<=endPtr && tTotal==satisfied){
                c=s.charAt(startPtr);
                
                // update global min-sliding window length
                if(globalMin.length()==0 || globalMin.length()>(endPtr-startPtr+1)){
                    globalMin= s.substring(startPtr, endPtr+1);
                }
                
                windowCounts.put(c, windowCounts.get(c)-1);
                if(tCount.containsKey(c) &&
                  windowCounts.get(c).intValue()< tCount.get(c).intValue()) satisfied--;
                startPtr++;
            }
            
            endPtr++;
        }
        
        return globalMin;
    }
}