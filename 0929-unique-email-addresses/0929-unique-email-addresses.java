class Solution {
    /*
    three options:
    // 1. normal alice@leetcode.com
    // 2. periods ignorance alice.z == alicez
    // 3. ignore after + in local name:  m.y+name => 
    */
    public int numUniqueEmails(String[] emails) {
        Set<String> refined = new HashSet<>();
        for(String email: emails){
            String formatted = refine(email);
            if(!refined.contains(formatted)){
                refined.add(formatted);
            }
        }
        return refined.size();
    }
    
    // local, domain
    public String refine(String email){
        String[] splitted = email.split("@");
        String local = splitted[0];
        String domain = splitted[1];
        // 1. normal alice@leetcode.com
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i< local.length(); i++){
            char currChar = local.charAt(i);
            // 2. periods ignorance alice.z == alicez
            if(currChar == '.')
                continue;
            // 3. ignore after + in local name:  m.y+name => 
            else if(currChar == '+')
                break;
            else// just normal chars can be added
                sb.append(currChar);
        }
        sb.append('@');
        sb.append(domain);
        return sb.toString();
    }
}