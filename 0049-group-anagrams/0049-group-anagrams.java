class Solution {
    /*
    update with the groups first.
    we can use two forloop and figures out it is same anagram or not.
    for(int i=0; i< n ;i++){
        for(int j= i+1; j<n; j++){
            compare i with j
                if anagram():
                if not anagram();
                    skip
        }
    }
    
    time complexity:O(n^2)
    space complexity: O(1)
    
    how can we do faster? counting is always same. 
    and if we store the varaibles with the combination of character and integer, then it would be gerat .
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        ex) bat - a1b1t1
            nat - a1n1t1
            tan - a1n1t1
            
            how can i make those in char??
            because only consist of lowecase English letters.
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str: strs){
            String hashedStr = hashcode(str);
            
            if(!map.containsKey(hashedStr)){
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(hashedStr, newList);
            }
            else if(map.containsKey(hashedStr)){
                map.get(hashedStr).add(str);
            }
        }
        
        List<List<String>> returnVal = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            returnVal.add(entry.getValue());
        }
        return returnVal;
    }
    
    public static String hashcode(String s){
        int[] cArr = new int[26];

        for(char c: s.toCharArray()){
            cArr[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            if(cArr[i]!=0){
                sb.append((char)'a'+i);
                sb.append(cArr[i]);
            }
        }
        return sb.toString();
    }
}