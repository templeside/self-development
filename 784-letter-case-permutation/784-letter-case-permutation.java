class Solution {
    /**
    ab7c
    ab7c      |  Ab7c
    ab7c Ab7c | 
    **/
    public List<String> letterCasePermutation(String str) {
        List<String> permutations = new ArrayList<>();
        if(str ==null)return permutations;
        
        permutations.add(str);
        
        for(int i=0; i<str.length(); i++){      // string iterator
            if(Character.isLetter(str.charAt(i))){  // character일 때
                int n= permutations.size();
                
                for(int j=0; j<n; j++){     
                    char[] chs = permutations.get(j).toCharArray();
                    
                    if(Character.isUpperCase(chs[i]))
                        chs[i] = Character.toLowerCase(chs[i]);
                    else
                        chs[i] = Character.toUpperCase(chs[i]);
                    
                    permutations.add(String.valueOf(chs));
                }
            }
        }
        return permutations;
    }
}