class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> returnVal = new ArrayList<>();
        if(!expression.contains("-")&&!expression.contains("+")&&!expression.contains("*")){
            returnVal.add(Integer.parseInt(expression));
            return returnVal;
        }
        
        for(int i=0; i< expression.length();i++){
            char currChar = expression.charAt(i);
            if(currChar =='-'|| currChar=='+' || currChar =='*'){
                List<Integer> lefts = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rights = diffWaysToCompute(expression.substring(i+1, expression.length()));
                
                int tempSum = 0;
                for(int left: lefts){
                    for(int right: rights){
                        if(currChar =='-'){
                            tempSum = left-right;
                        }
                        else if(currChar =='+'){
                            tempSum =left+right;
                        }else{
                            tempSum = left*right;
                        }
                        returnVal.add(tempSum);
                    }
                }
            }
        }
        return returnVal;
    }
}