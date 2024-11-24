class Solution {
    /*
    bfs로 일을 한다.
    find the possibilities
    
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        
        //checking the endWord is in wordSet
        if(!wordSet.contains(endWord))
            return 0;
        
        //initialize BFS
        Queue<String> queue= new LinkedList<>();
        queue.add(beginWord);
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i< size; i++){
                String currentWord = queue.poll();
                
                //if currWord == endWord
                if(currentWord.equals(endWord)){
                    return level;
                }
                
                //try changing each letter with wordset
                char[] wordChars = currentWord.toCharArray();
                for(int j=0; j< wordChars.length; j++){
                    char originalChar = wordChars[j];
                    
                    for(char c = 'a'; c<='z'; c++){
                        if(c==originalChar)
                            continue;
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        // check isValid - in wordset,      not in visited
                        if(wordSet.contains(newWord) && !visited.contains(newWord)){
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    wordChars[j] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}