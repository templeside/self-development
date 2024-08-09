class Solution {
    /*
    having the parentheses, generate the values
    set with values
    backtrack.
        base case - reaches 2*n length or visited
        when to close the parentheses
    
        (
    ()          (( 
()(   ())   (((     (()

open close
backtrack(open, close, currString, n, returnVal)
    */
    public List<String> generateParenthesis(int n) {
        int openCount=0;
        int closeCount=0;
        StringBuilder currString = new StringBuilder();
        List<String> returnVal = new ArrayList<>();
        backtrack(openCount, closeCount, currString, returnVal, n);
        return returnVal;
    }
    
    public void backtrack(int openCount, int closeCount,StringBuilder currString,List<String> returnVal,int n){
        //base case - openCount == closeCount == n
        if(openCount == n && closeCount == n){
            returnVal.add(currString.toString());
            return;
        }
        
        //adding open clause
        if(openCount< n){
            currString.append("(");
            backtrack(openCount+1, closeCount, currString, returnVal, n);
            currString.deleteCharAt(currString.length()-1);
        }
        
        //adding close clause
        if(openCount> closeCount){
            currString.append(")");
            backtrack(openCount, closeCount+1, currString, returnVal, n);
            currString.deleteCharAt(currString.length()-1);
        }
    }
}