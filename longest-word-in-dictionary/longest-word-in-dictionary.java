class Solution {
    public String longestWord(String[] words) {
        // 1. find the longestrepresenting english dictionary
            // can be built one other words in 'words'
        // 2. if more than one possible answer, return longest
        /** algo:
        1. store all variables in priority queue in lexicographical order
        2. for word character, add items into the hashset.
            a. if( set is null)
                add
            b. if(set contains the substring n-1) 
                push to hashset
                if longer than the logest update the longest.
        return longest
        **/
        Arrays.sort(words, (a,b)->{
            if(a.length()!=b.length())
                return a.length()-b.length();
            else
                return a.compareTo(b);
               });
        Set<String> wordsSet = new HashSet<>();
        String longest="";
        
        // for(String word: words)
        //     System.out.print(word+" ");
        // System.out.println();
        
        for(String word: words){
            if(word.length() ==1 || wordsSet.contains(word.substring(0,word.length()-1))){
                System.out.println(word);
                wordsSet.add(word);
                if(longest.length()< word.length())
                    longest = word;
            }
        }
        return longest;
    }
}