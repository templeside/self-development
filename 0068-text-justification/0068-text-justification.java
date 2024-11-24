class Solution {
    /*
    how would you like that???
    pad extra
    something somethings
    
    so i need to have the previous texts as much as possible. 
    
    each line, has remaining spaces
    
    it in last line, 
    */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>(); // To store the final justified text
        int index = 0; // Pointer to traverse the words array
        int n = words.length; // Total number of words

        while (index < n) {
            int totalChars = words[index].length(); // Total characters in the current line
            int last = index + 1; // Pointer to determine the end of the current line

            // Determine how many words can fit into the current line
            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length(); // 1 for the space
                last++;
            }

            int numberOfWords = last - index; // Number of words in the current line
            int numberOfSpaces = maxWidth - totalChars + (numberOfWords - 1); // Total spaces to distribute

            StringBuilder sb = new StringBuilder();

            // If it's the last line or the line contains only one word, left-justify
            if (last == n || numberOfWords == 1) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) {
                        sb.append(" ");
                    }
                }
                // Fill the remaining spaces
                int remaining = maxWidth - sb.length();
                while (remaining > 0) {
                    sb.append(" ");
                    remaining--;
                }
            } else {
                // Calculate spaces to distribute
                int totalSpaces = maxWidth - (totalChars - (numberOfWords - 1));
                int spaceBetweenWords = totalSpaces / (numberOfWords - 1);
                int extraSpaces = totalSpaces % (numberOfWords - 1);

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) {
                        // Add spaces
                        for (int s = 0; s < spaceBetweenWords; s++) {
                            sb.append(" ");
                        }
                        // Distribute extra spaces to the left slots
                        if (extraSpaces > 0) {
                            sb.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            result.add(sb.toString());
            index = last; // Move to the next line
        }

        return result;
    }
}
