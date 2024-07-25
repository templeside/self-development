class Solution {
    /*
    word square???
    how???? 
    "ball",
    "area",
    "lead",
    "lady"
    
    forming by reorderding the words array.
    isWordSquare
    
    1. backtrack the words
        //base case n== currWords.size()
        2. if it is available, 
            add to the wordsquare is it used or not with hashset<String>
        recursion with all combinations of words
    3. return with the value.
        
    */
    Map<String, List<String>> map = new HashMap<>();
    public List<List<String>> wordSquares(String[] words) {
        
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        for (String word : words) {
            for (int i = 1; i < word.length(); ++i) {
                String sub = word.substring(0, i);
                map.putIfAbsent(sub, new ArrayList<>());
                map.get(sub).add(word);
            }
        }
        for (String word : words) {
            List<String> path = new ArrayList<>();
            path.add(word);
            dfs(word, 1, path, res);
        }
        return res;
    }
    
    private void dfs(String word, int index, List<String> path, List<List<String>> res) {
        if (index == word.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String w : path) {
            sb.append(w.charAt(index));
        }
        for (String w : map.getOrDefault(sb.toString(), new ArrayList<>())) {
            path.add(w);
            dfs(w, index + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}