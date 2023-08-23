/*
how to handle?
there should be an identifier.
we can use (char)257 for identifier.
*/
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str);
            sb.append((char)257);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String delimiter = Character.toString((char) 257);
        return Arrays.asList(s.split(delimiter,-1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));