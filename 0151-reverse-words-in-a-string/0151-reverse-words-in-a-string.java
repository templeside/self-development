class Solution {
    /*
    if i reverse partially and reverse whole string
    it would be a great way to solve the problem.
    becuase reverse all string makes the front to end
    and partially reverse will make it reorganize the word by word
    
    the sky is blue
    eulb si yks eht
    
    if found identifier,reverse the word
    then reverse whold string.
    
    
    */
    public String reverseWords(String s) {
        s = s.trim();
        int curr = 0;
        int tail = 0;
        
        String[] splitted = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for(String substring: splitted){
            if(substring.length() ==0) continue;
            sb.append(reverse(substring));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.reverse();
        return sb.toString();
    }
    public String reverse(String s){
        int i=0;
        int j = s.length()-1;
        char[] sArr = s.toCharArray();
        
        while(i<j){
            char temp = sArr[i];
            sArr[i] = sArr[j];
            sArr[j] = temp;
            
            i++;
            j--;
        }
        return new String(sArr);
    }
}