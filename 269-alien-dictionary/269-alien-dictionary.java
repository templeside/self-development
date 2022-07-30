class Solution {
    /**
    need to find out it is lexicographically ordered.
    in this case, we can use topological sort.
    1. initiate two hashmap:
        inDegree<alphabet, prerequisite counter>
        childrenMap<currNode, childrenNode>
    2. iterate through the words, and build the hashmaps
    3. look for the non-prerequisite characters.
    4. find the nodes.
    
    return in the ordered way.
    
    ["abc","ab"]
    **/
    public String alienOrder(String[] words) {
        HashMap<Character, Integer> inDegree = new HashMap<>();
        HashMap<Character, List<Character>> childrenMap = new HashMap<>();
        
        for(String word: words){
            for(char c: word.toCharArray()){
                inDegree.put(c, 0);
                childrenMap.put(c, new ArrayList<>());
            }
        }
        for(int i=0; i< words.length-1; i++){
            String prereq = words[i];
            String curr = words[i+1];
            // Check that word2 is not a prefix of word1.
            if (prereq.length() > curr.length() && prereq.startsWith(curr)) 
                return "";
            for(int j=0; j< Math.min(prereq.length(), curr.length()); j++){
                if(prereq.charAt(j) != curr.charAt(j)){
                    char prevChar = prereq.charAt(j);
                    char currChar = curr.charAt(j);
                    inDegree.put(currChar, inDegree.get(currChar)+1);
                    childrenMap.get(prevChar).add(currChar);
                    break;
                }
            }
        }
        
        StringBuilder currOrder = new StringBuilder();
        Queue<Character> topoIterator = new LinkedList<>();
        for(Map.Entry<Character, Integer> set: inDegree.entrySet()){
            if(set.getValue() ==0)
                topoIterator.add(set.getKey());
        }
        
        while(topoIterator.size()>0){
            char currChar = topoIterator.poll();
            currOrder.append(currChar);
            for(char child: childrenMap.get(currChar)){
                inDegree.put(child, inDegree.get(child)-1);
                if(inDegree.get(child) ==0)
                    topoIterator.add(child);
            }
        }
        return currOrder.length() == inDegree.size()? currOrder.toString() : "";
    }
}