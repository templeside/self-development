class Solution {
    public List<List<String>> groupStrings(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        Arrays.sort(strs);    	
        for (String s : strs) {
            String key = "";
            for (int i = 1; i < s.length(); i++) 
                key += String.format("%2d", (s.charAt(i) - s.charAt(i-1) + 26) % 26);//Difference from the previous char.
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);    		
        } 
        return new ArrayList<List<String>>(map.values());
    }
}