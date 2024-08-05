class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j=0;
        int n = word.length(), m = abbr.length();

        while(i < m && j < n) {
            if(!Character.isDigit(abbr.charAt(i))) {
                if(word.charAt(j) == abbr.charAt(i)) {
                    i++; j++;
                } else return false;
            }
            int start = i;
            while(i<m && Character.isDigit(abbr.charAt(i))) {
                if(abbr.charAt(i) == '0' && start == i){
                    return false;
                }
                i++;
            }
            if(i != start) {
                int number = Integer.parseInt(abbr.substring(start, i));
                while(number-- > 0) {
                    j++;
                }
            }
        }

        return i == m && j == n;
    }
}
