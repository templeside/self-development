class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> result = new ArrayList<>();
        int startIdx=0, endIdx = 0;
        int k=10;
        Map<String,Integer> sequences = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        if(k>= s.length())return List.of();
        
        for(startIdx=0; startIdx< k-1; startIdx++){
            sb.append(s.charAt(startIdx));
        }
        
        for(; startIdx<s.length(); startIdx++){
            sb.append(s.charAt(startIdx));
            
            String currStr = sb.toString();
            
            sequences.put(currStr, sequences.getOrDefault(currStr, 0)+1);
            if(sequences.get(currStr) == 2)
                result.add(currStr);
            
            sb.deleteCharAt(0);
        }
        return result;
    }
}