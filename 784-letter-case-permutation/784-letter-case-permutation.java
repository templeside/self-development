class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> queue = new ArrayList<>();
        queue.add(s);
        
        for(int i=0; i< s.length();i++){
            if(Character.isDigit(s.charAt(i)))continue;
            int n= queue.size();
            
            for(int j=0; j<n; j++){
                char[] currStringArr = queue.get(j).toCharArray();
                
                if(Character.isLowerCase(currStringArr[i]))
                    currStringArr[i] = Character.toUpperCase(currStringArr[i]);
                else
                    currStringArr[i] = Character.toLowerCase(currStringArr[i]);
                
                queue.add(String.valueOf(currStringArr));
                
            }
        }
        return queue;
    }
}