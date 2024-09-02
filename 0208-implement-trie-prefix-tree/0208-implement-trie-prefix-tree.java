class Trie {
    class Node{
        public boolean isEndOfWord;
        public Map<Character, Node> childrenMap;
        
        public Node(){
            isEndOfWord = false;
            childrenMap = new HashMap<>();
        }
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node iterator = root;
        for(char currChar : word.toCharArray()){
            if(!iterator.childrenMap.containsKey(currChar)){
                iterator.childrenMap.put(currChar, new Node());
            }
            iterator = iterator.childrenMap.get(currChar);
        }
        iterator.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        Node iterator = root;
        for(char currChar : word.toCharArray()){
            if(!iterator.childrenMap.containsKey(currChar)){
                return false;
            }
            iterator = iterator.childrenMap.get(currChar);
        }
        return iterator.isEndOfWord == true;

    }
    
    public boolean startsWith(String prefix) {
        Node iterator = root;
        for(char currChar : prefix.toCharArray()){
            if(!iterator.childrenMap.containsKey(currChar)){
                return false;
            }
            iterator = iterator.childrenMap.get(currChar);
        }
        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */