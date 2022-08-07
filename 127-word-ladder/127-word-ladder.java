class Solution {
    /**
    graph.
    bfs
    visited
    
    iterate the string by each index of the word.
    
    ex)
    Input: beginWord = "hot", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
                        ^                                   
    visited                                                  -    -            -
    bfsIterator = dot,lot, 
    Output: 5
    Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
    
    how to check the valid alphabet????
    having the alphabet array, and iterate 26characters with the index. time complexity of O(1).
    
    "hot"
    "dog"
    ["hot","dog"]
    
    word        - hot
    bfsIterator - 
    
    **/
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        char[] charArr = new char[26];
        for(int i=0; i< 26; i++){
            charArr[i] = (char)('a'+i);
        }
        HashSet<String> wordSet = new HashSet<>();
        for(String word: wordList){
            wordSet.add(word);
        }
        if(!wordSet.contains(endWord))return 0;
        
        Queue<String> bfsIterator =  new LinkedList<>();
        bfsIterator.add(beginWord);
        int shortestCount = 0;
        while(bfsIterator.size()>0){
            shortestCount++;
            int n = bfsIterator.size();
            for(int i=0; i<n;i++){
                String word = bfsIterator.poll();
                if(word.equals(endWord)) return shortestCount;
                
                for(int j=0 ;j< word.length(); j++){
                    // find word.
                    for(char c: charArr){
                        StringBuilder sb = new StringBuilder();
                        sb.append(word.substring(0,j));
                        sb.append(c);
                        sb.append(word.substring(j+1));
                        if(wordSet.contains(sb.toString())){
                            bfsIterator.add(sb.toString());
                            wordSet.remove(sb.toString());
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}