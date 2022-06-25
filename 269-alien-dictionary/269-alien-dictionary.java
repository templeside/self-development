class Solution {
    public String alienOrder(String[] words) {
        if(words ==null || words.length ==0)return "";
        
        // a. initialize the graph
        HashMap<Character, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex.
        HashMap<Character, List<Character>> graph = new HashMap<>();    // adjacency list graph.
        for(String word: words){
            for(char character : word.toCharArray()){
                inDegree.put(character,0);
                graph.put(character, new ArrayList<Character>());
            }
        }
        
        // b. build the graph
        for(int i=0; i< words.length-1; i++){
            String w1=words[i], w2=words[i+1];  // find  the ording of characters.
            // Check that word2 is not a prefix of w1.
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            for(int j=0; j<Math.min(w1.length(), w2.length());j++){
                char parent = w1.charAt(j), child= w2.charAt(j);
                if(parent !=child){                             //if two characters are different, 
                    inDegree.put(child, inDegree.get(child)+1); //put the child into it's parent list
                    graph.get(parent).add(child);               //increment child's inDegree
                break;                                          //only checking the first different character between the two words
                }
            }
        }
        
        // 여기 부터는 기존 topological sort와 같음.
        // c. find all sources i.e., all verticies with 0 inDegrees
        Queue<Character> sources = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry: inDegree.entrySet()){
            if(entry.getValue()==0)
                sources.add(entry.getKey());
        }
        
        // d. for each source, add it to the sortedOrder and subtract one from all of its schildren's inDegrees if a hild's inDegree becomes zero, add it to the sources queue.
        StringBuilder sortedOrder = new StringBuilder();
        
        while(!sources.isEmpty()){
            Character vertex = sources.poll();
            sortedOrder.append(vertex);
            List<Character> children = graph.get(vertex);
            for(Character child: children){
                inDegree.put(child, inDegree.get(child)-1);
                if(inDegree.get(child) ==0)
                    sources.add(child);
            }
        }
        
        if(sortedOrder.length() !=inDegree.size())
            return "";
        return sortedOrder.toString();
    }
}