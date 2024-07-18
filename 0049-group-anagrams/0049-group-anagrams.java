class Solution {
    /*
    Anagram - same things count chars.
    save in hashmap - for grouping
    hashmap<
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> encodedMap = new HashMap<>();
        for(String str: strs){
            String encoded = count(str);
            List<String> encodedList = encodedMap.getOrDefault(encoded, new ArrayList<>());
            encodedList.add(str);
            encodedMap.put(encoded, encodedList);
        }
        
        List<List<String>> returnVal = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: encodedMap.entrySet()){
            returnVal.add(entry.getValue());
        }
        return returnVal;
    }
    public String count(String s){
        s.toLowerCase();
        int[] arr = new int[26];
        for(char c: s.toCharArray()){
            arr[c-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< 26; i++){
            if(arr[i] !=0){
                sb.append((char)('a'+i));
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}