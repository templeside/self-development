class Solution {
    public String frequencySort(String str) {
        
    Map<Character, Integer> counter = new HashMap<>();
    for(char c: str.toCharArray()){
      counter.put(c, counter.getOrDefault(c, 0)+1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
    for(Map.Entry<Character,Integer> entry: counter.entrySet())
      queue.add(entry);
    
    String returnVal = "";
    while(!queue.isEmpty()){
      Map.Entry<Character, Integer> entry = queue.poll();
      for(int i=0; i<entry.getValue(); i++ )
        returnVal += entry.getKey();
    }

    return returnVal;
  }

}