class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parentheses = new ArrayList<>();
        backtrack("",0,0,n,parentheses);
        return parentheses;
    }
    
    public void backtrack(String currString, int openCount, int closeCount, int n, List<String> parentheses){
        if(openCount ==n && closeCount ==n){
            parentheses.add(currString);
            return;
        }
        
        if(openCount< n){
            backtrack(currString+"(",openCount+1, closeCount, n, parentheses);
        }
        
        if(closeCount< openCount){
            backtrack(currString+")",openCount, closeCount+1, n, parentheses);
        }
    }
}