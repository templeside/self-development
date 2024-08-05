class Solution {
    /*
    having hashset and sliding window with fixed size, check is it visited.
    */
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        int windowStart=0;
        int windowEnd = 0;
        StringBuilder sb = new StringBuilder();
        
        for(; windowStart< s.length(); windowStart++){
            char currChar = s.charAt(windowStart);
            sb.append(currChar);
            
            if(sb.length()== 10){
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
                sb.deleteCharAt(0);
            }
        }
        
        List<String> returnVal = new ArrayList();
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue()>=2)
                returnVal.add(entry.getKey());
        }
        return returnVal;
    }
}