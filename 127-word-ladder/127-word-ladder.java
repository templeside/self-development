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
    
    **/
    
    public static final char[] ALPHABETS = new char[26];
    static {
        // ascii representation of english alphabets a - z are numbers 97 - 122
        for (int i = 0; i < 26; i++) {
            ALPHABETS[i] = (char) (i + 'a');
        }
    }

    public static int ladderLength(String begin, String end, List<String> wordList){
        // make a set because existence query is O(1) vs O(N) for list
        Set<String> words = new HashSet<>(wordList);
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(begin);
        int distance = 1;
        while (queue.size() > 0) {
            int n = queue.size();
            distance++;
            for (int i = 0; i < n; i++) {
                String word = queue.pop();
                for (int j = 0; j < word.length(); j++) {
                    for (char c : ALPHABETS) {
                        StringBuilder wordBuilder = new StringBuilder(word.length());
                        wordBuilder.append(word.substring(0, j));
                        wordBuilder.append(c);
                        wordBuilder.append(word.substring(j + 1));
                        String nextWord = wordBuilder.toString();
                        if (!words.contains(nextWord)) continue;
                        if (nextWord.equals(end)) return distance;
                        queue.add(nextWord);
                        // removing from the set is equivalent as marking the word visited
                        words.remove(nextWord);
                    }
                }
            }
        }
        return 0;
    }
}