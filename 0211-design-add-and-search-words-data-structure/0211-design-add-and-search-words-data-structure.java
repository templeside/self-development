class WordDictionary {
    class TrieNode{
        boolean isTail;
        Map<Character, TrieNode> childMap;
        public TrieNode(){
            isTail = false;
            childMap = new HashMap<>();
        }
    }
    
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    /*
    ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
                                    ^
    [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
                   ^
    root(isTail-f,[b,d])
    
    b(isTail-f,[a])     d(isTail-f,[a])
    
    a(isTail-f,[d])     a(isTail-f,[])
    
    d(isTail-t,[])
    */
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            //when not havign the children
            if(!curr.childMap.containsKey(c)){
                curr.childMap.put(c, new TrieNode());
            }
            curr = curr.childMap.get(c);
        }
        curr.isTail = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        return helper(curr, word);
    }
    public boolean helper(TrieNode curr, String word){
        if(word.length() ==0){
            return curr.isTail;
        }
        char matchingChar = word.charAt(0);
        
        if(matchingChar =='.'){
            for(char child: curr.childMap.keySet()){
                boolean result = helper(curr.childMap.get(child), word.substring(1));
                if(result == true)
                    return true;
            }            
        }
        if(curr.childMap.containsKey(matchingChar)){
            boolean result = helper(curr.childMap.get(matchingChar), word.substring(1));
            if(result == true)
                return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */