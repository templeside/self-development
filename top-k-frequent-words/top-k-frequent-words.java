class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words)
            map.put(word, map.getOrDefault(word, 0)+1);
        
        List<String> lst = new ArrayList(map.keySet());
        
        Collections.sort(lst, (a,b)-> map.get(a)-map.get(b) ==0? a.compareTo(b) : map.get(b)-map.get(a));
        
        return lst.subList(0,k);
    }
}