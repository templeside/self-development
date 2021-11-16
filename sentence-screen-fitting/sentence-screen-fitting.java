public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        // all sentence
        String s = String.join(" ", sentence) + " ";
        // staring point
        int start = 0;
        //regulator
        int l = s.length();
        
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                // while having the new things.
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }
        return start / s.length();
    }
}
