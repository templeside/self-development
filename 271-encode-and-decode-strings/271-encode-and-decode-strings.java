public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs.size() ==0) return Character.toString((char)258);
        
        StringBuilder sb= new StringBuilder();
        
        String delimiter = Character.toString((char)257);
        for(String s: strs){
            sb.append(s);
            sb.append(delimiter);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String delimiter = Character.toString((char)258);
        if(delimiter.equals( s))return new ArrayList();
        
        delimiter = Character.toString((char)257);
        return Arrays.asList(s.split(delimiter,-1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));