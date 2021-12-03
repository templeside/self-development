class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 1. dp
        // s = "leetcode", wordDict = ["leet", "code"]
        boolean[] segmented = new boolean[s.length()+1];
        
        segmented[0] = true;        //it is valid of starting point.
        HashSet<String> set = new HashSet<>(wordDict);
        
        for(int end = 1; end<= s.length();end++){
            for(int start = 0; start<end; start++){
                if(segmented[start] && set.contains(s.substring(start,end)))
                    segmented[end] = true;
            }
        }
        
        return segmented[s.length()];
    }
}