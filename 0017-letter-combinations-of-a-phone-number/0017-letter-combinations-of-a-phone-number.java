class Solution {
    /*
    2-a,b,c
    3-d,e,f
    4-g,h,i
    5-j,k,l
    6-m,n,o
    7-p,q,r,s
    8-t,u,v
    9-w,x,y,z
    
    starting from index 0, backtrack the combinations
    */
    public List<String> letterCombinations(String digits) {
        if(digits.length() ==0)
            return new ArrayList();
        List<String> returnVal = new ArrayList<>();
        int idx = 0;
        StringBuilder sb=  new StringBuilder();
        Map<Integer, List<Character>> button = new HashMap<>();
        button.put(2, List.of('a','b','c'));
        button.put(3, List.of('d','e','f'));
        button.put(4, List.of('g','h','i'));
        button.put(5, List.of('j','k','l'));
        button.put(6, List.of('m','n','o'));
        button.put(7, List.of('p','q','r', 's'));
        button.put(8, List.of('t','u','v'));
        button.put(9, List.of('w','x','y','z'));
        
        System.out.println(button);

        backtrack(idx, digits, returnVal, sb, button);
        return returnVal;
    }
    public void backtrack(int idx, String digits, List<String> returnVal, StringBuilder sb, 
                          Map<Integer, List<Character>> button){
        if(idx == digits.length()){
            returnVal.add(sb.toString());
            return;
        }
        // System.out.println(digits.charAt(idx));
        List<Character> candidates = button.get(digits.charAt(idx)-'0');
        for(char c: candidates){
            sb.append(c);
            backtrack(idx+1, digits, returnVal, sb, button);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}