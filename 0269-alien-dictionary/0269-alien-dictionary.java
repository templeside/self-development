class Solution {
    public String alienOrder(String[] words) {
      // create hashmap with values
      Map<Character, List<Character>> graph = new HashMap<>();
      for(String word: words){
         for(char c: word.toCharArray())
            graph.putIfAbsent(c, new ArrayList<>());
      }

      // add graph adjacnecies
      for(int i=0; i < words.length-1; i++){
         String prereq = words[i];
         String curr = words[i+1];
         // Check that word2 is not a prefix of word1. 
         if (prereq.length() > curr.length() && prereq.startsWith(curr))
            return "";
         for(int j=0; j< Math.min(prereq.length(), curr.length()); j++){
            if(prereq.charAt(j) != curr.charAt(j)){
               char prevChar = prereq.charAt(j);
               char currChar = curr.charAt(j);
               graph.get(prevChar).add(currChar);  //graph add neighbors
               break;
            }
         }
      }

   return toposort(graph);
   }

   public static String toposort(Map<Character, List<Character>> graph){
      String order = "";
      ArrayDeque<Character> queue = new ArrayDeque<>();

      //create inDegree
      Map<Character, Integer> inDegree = new HashMap<>();
      for(Character vertex: graph.keySet()){
         inDegree.put(vertex, 0);
      }
      //find neighbor to be in 
      for(Map.Entry<Character, List<Character>> entry: graph.entrySet()){
         for(char neighbor: entry.getValue()){
            inDegree.put(neighbor, inDegree.get(neighbor)+1);
         }
      }
      //find 0 inDegree node
      for(Map.Entry<Character, Integer> entry: inDegree.entrySet()){
         if(entry.getValue() ==0)
         queue.add(entry.getKey());
      }

      //do topological sort
      while(!queue.isEmpty()){
         char c = queue.poll();
         order = order+c;
         for(char neighbor: graph.get(c)){
            inDegree.put(neighbor, inDegree.get(neighbor)-1);
            if(inDegree.get(neighbor)== 0)
               queue.add(neighbor);
         }
      }
      return graph.size() == order.length()? order: "";
   }
}