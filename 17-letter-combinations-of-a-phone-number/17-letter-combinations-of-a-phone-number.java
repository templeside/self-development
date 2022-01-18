class Solution {
    public List<String> combinations = new ArrayList<>();
    private Map<Character ,String> map = Map.of(
    '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
    '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String digit;
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() ==0)return combinations;
        digit = digits;
        
        backtrack(0, new StringBuilder());
        return combinations;
    }
    
    public void backtrack(int index, StringBuilder path){
        if(path.length() == digit.length()){
            combinations.add(path.toString());
            return;
        }
        String possibleLetters = map.get(digit.charAt(index));
        for(char letter : possibleLetters.toCharArray()){
            path.append(letter);
            backtrack(index+1, path);
            path.deleteCharAt(path.length()-1);
        }
            
    }
}