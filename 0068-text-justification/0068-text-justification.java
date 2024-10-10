class Solution {
    /*
    words
    maxWidth
    
    lines - maxwidth
    paddings
    offsets - left first.
    
    last line - single lines
    
    data structures
        List<String> returnVal
        List<String> currCharArr = each line builder
    
    for each line, we have stirng builder
    
    for(word: words)
        calculate is valid string if adding a word
            if not valid - if(currCharNum + currCharArr.size()-1 > maxWidth)
                add the previous currCharArr to the returnVal
                recreate currCharArr
            currCharArr.add(word)
            currCharNum += word
    
    done with iteration, check still has remaining last line
        generate the string with spacing 1, and having remaining spaces on the right
    */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> returnVal = new ArrayList<>();
        List<String> currWords = new ArrayList<>(); // Words in the current line
        int currCharsNum = 0; // Total number of characters in currWords (excluding spaces)
        
        for (String word : words) {
            // Check if adding the next word exceeds the maxWidth
            if (currCharsNum + word.length() + currWords.size() > maxWidth) {
                // Generate the justified line and add it to the result
                String currLine = generateLine(currWords, currCharsNum, maxWidth, false);
                returnVal.add(currLine);
                // Reset for the next line
                currWords = new ArrayList<>();
                currCharsNum = 0;
            }
            currWords.add(word);
            currCharsNum += word.length();
        }
        // Handle the last line
        String lastLine = generateLine(currWords, currCharsNum, maxWidth, true);
        returnVal.add(lastLine);
        return returnVal;
    }

    public String generateLine(List<String> words, int currCharsNum, int maxWidth, boolean isLastLine) {
        StringBuilder sb = new StringBuilder();
        int numWords = words.size();
        int numSpaces = maxWidth - currCharsNum; // Total spaces to distribute

        if (numWords == 1 || isLastLine) {
            // Left-justified: words are separated by a single space
            for (int i = 0; i < numWords; i++) {
                sb.append(words.get(i));
                if (i != numWords - 1) {
                    sb.append(" ");
                    numSpaces--;
                }
            }
            // Fill the remaining spaces at the end
            for (int i = 0; i < numSpaces; i++) {
                sb.append(" ");
            }
        } else {
            // Fully justified
            int spacesBetweenWords = numWords - 1;
            int spacesEach = numSpaces / spacesBetweenWords; // Minimum spaces to add between words
            int extraSpaces = numSpaces % spacesBetweenWords; // Extra spaces to distribute

            for (int i = 0; i < numWords; i++) {
                sb.append(words.get(i));
                if (i != numWords - 1) {
                    // Distribute extra spaces to the left slots
                    int spacesToAdd = spacesEach + (i < extraSpaces ? 1 : 0);
                    for (int j = 0; j < spacesToAdd; j++) {
                        sb.append(" ");
                    }
                }
            }
        }
        return sb.toString();
    }
}
