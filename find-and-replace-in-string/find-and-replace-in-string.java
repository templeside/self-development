class Solution {
    /**
    1. Check if the substring sources[i] occurs at index indices[i] in the original string s.
    2. If it does not occur, do nothing.
    3. Otherwise if it does occur, replace that substring with targets[i].
Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
Output: "eeebffff"
Explanation:
"a" occurs at index 0 in s, so we replace it with "eee".
"cd" occurs at index 2 in s, so we replace it with "ffff".
replace from left to right.
    **/
public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
    Map<Integer, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < indexes.length; i++)//map the indexes 
        map.put(indexes[i], i);

    for(int i = 0; i < s.length(); i++){
        if(!map.containsKey(i)) {// i is not in indexes array
            sb.append(s.charAt(i));//append current character 
            continue;
        }

        int idx = map.get(i);//get the index for sources and targets array

        if(!s.substring(i, i + sources[idx].length()).equals(sources[idx])){//substring in s doesn't match string in source
            sb.append(s.charAt(i));//add current character 
            continue;
        }

        i += sources[idx].length() - 1;//move i to the end of matched substring
        sb.append(targets[idx]);//append the corresponding target string 
    }
    return sb.toString();
}
}