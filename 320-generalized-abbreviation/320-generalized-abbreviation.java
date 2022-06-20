class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        dfs(word, new StringBuilder(), 0,0,result);
        return result;
    }
    
    public void dfs(String word, StringBuilder abWord, int start, int count, List<String> result){
        if(start ==word.length()){
            if(count !=0)
                abWord.append(count);
            result.add(abWord.toString());
        }
        else{
            dfs(word, new StringBuilder(abWord), start+1, count+1, result);
            
            if(count !=0)
                abWord.append(count);
            dfs(word, new StringBuilder(abWord).append(word.charAt(start)), start+1, 0, result);
        }
    }
}