class Solution {
    /*
    need to sort the strs in same place.
    to store values in same place, we can use hashmap.
    hashMap<hashcodeKey, anagram strings>
    hashMap<String, List<String>>
    
    how to group?
    common things are - frequency of chars.
    we can list out in alphabetical order
    ex) cat - a1c1t1
    ex) tac - a1c1t1
    
    algorithm:
        iterating strs:
            convert into hashcodeKey
            save it into hashmap
        return the hashmap after convert to List<List<String>>
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashmap = new HashMap<>();
        
        for(String str: strs){
            String hashcodeKey = hash(str);
            if(!hashmap.containsKey(hashcodeKey))
                hashmap.put(hashcodeKey, new ArrayList<>());
            List<String> hashcodeGroup = hashmap.get(hashcodeKey);
            hashcodeGroup.add(str);
        }
        
        List<List<String>> returnGroup = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : hashmap.entrySet()){
            returnGroup.add(entry.getValue());
        }
        return returnGroup;
    }
    
    public static String hash(String s){
        int[] charFreq = new int[26];
        for(char c: s.toCharArray()){
            charFreq[c-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            if(charFreq[i] !=0){
                sb.append((char)('a'+i));
                sb.append(charFreq[i]);
            }
        }
        return sb.toString();
    }
}