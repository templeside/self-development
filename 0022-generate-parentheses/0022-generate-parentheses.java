class Solution {
    /*
    backtrack
    base case - when reaches the end stack
        add to the returnVal
    
    by iterating the datasource, 
        if already found in saved then don't backtrack
        add parenthesis and backtrack
        
        len = 2, .insert 0, 1, 2
        for(int i=0; i<= n; i++)
     (  )
    ^  ^ ^
    ( ) ( ),   ( (  ) )
   ^ ^ ^ ^ ^  ^ ^  ^ ^ ^
   ()()(), (())(), ()(()), | (()()), ((()))
    */
    public List<String> generateParenthesis(int n) {
        Set<String> memo= new HashSet<>();
        List<String> returnVal = new ArrayList();
        StringBuilder sb = new StringBuilder();
        
        backtrack(n, sb, returnVal, memo);
        return returnVal;
    }
    public void backtrack(int n, StringBuilder sb, List<String> returnVal, Set<String> memo){
    //     base case - when reaches the end stack
        if(n ==0){
    //         add to the returnVal
            if(!memo.contains(sb.toString())){
                returnVal.add(sb.toString());
                memo.add(sb.toString());
            }
            return;
        }
        // by iterating the datasource, 
        for(int i=0; i<= sb.length(); i++){
            if(sb.length() ==0 && i ==1)// when ""
                continue;
        // add parenthesis and backtrack
            sb.insert(i, "()");
        // if already found in saved then don't backtrack
            if(!memo.contains(sb.toString())){
                
                backtrack(n-1, sb, returnVal, memo);
                memo.add(sb.toString());
            }
            sb.deleteCharAt(i);
            sb.deleteCharAt(i);
        }
    }
}