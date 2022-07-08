class Solution {
    /**
    for the brute force way, I can iterate through the strings and compare is it anagram.
    ex)
Input: strs = ["eat","tea","tan","ate","nat","bat"]
                ^
for string in strs:
    for string in returnval:
        check is there a similar anagram in the array.
    if no, then add the returnVal.

time complexity:O(N^2)
space: O(N).

how can i decrease the time complexity???
how about I can go to the further extension?????
hashing - string automatically heading to the proper place. - identifying by strs index.

Input: strs = ["eat","tea","tan","ate","nat","bat"]
                                         ^
                 
{a1e1t1: [0,1,3], a1t1n1:[2,4], abt: [5]}

in this case, I can hashmap, key is string of counting, and value is the index of the strs.

afterwards, Iterate the hashmap and return the value.

the time complexity of this algorythm is O(N)
space complexity of this algorithm is O(1). 

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    **/
    public String countString(String s){
        int[] count = new int[26];
        for(char c: s.toCharArray()){
            count[c-'a'] ++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< 26; i++){
            if( count[i] !=0){
                sb.append((char)('a'+i));
                sb.append(count[i]);
            }
        }
        return sb.toString();
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
                //<counter, List<strs Idx>>
        HashMap<String, List<Integer>> orderIndex = new HashMap<>();
        for(int i=0; i< strs.length; i++){
            String s= strs[i];
            String count = countString(s);
            
            if(!orderIndex.containsKey(count))
                orderIndex.put(count, new ArrayList<>());
            List<Integer> currArr = orderIndex.get(count);
            currArr.add(i);
        }
        
        List<List<String>> returnVal = new ArrayList<>();
        for(Map.Entry<String, List<Integer>> set: orderIndex.entrySet()){
            List<String> temp = new ArrayList<>();
            
            for(int i: set.getValue()){
                temp.add(strs[i]);
            }
            returnVal.add(temp);
        }
        
        return returnVal;
    }
}