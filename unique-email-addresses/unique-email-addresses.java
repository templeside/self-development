class Solution {
    /**
For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.

For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.

For example, "m.y+name@email.com" will be forwarded to "my@email.com".

find # unique emails.

first, need to be divided into local, and domain.
domain can be ignored.

    <local name + domain name>
HashSet<String> frequency;
I would use stringBuilder for collecting unique emails.
two cases:
    1. dots
        if found dots, move to next index
    2. +
        if found +, end the iteration for unique email.
    
    **/
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails  = new HashSet<>();
        
        for(String email: emails){
            String[] splitted = email.split("@");   // [local, domain]
            String formatted = format(splitted[0])+"@"+ splitted[1];
            if(!uniqueEmails.contains(formatted))
                uniqueEmails.add(formatted);
        }
        return uniqueEmails.size();
    }
    public String format(String local){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< local.length(); i++){
            char currChar= local.charAt(i);
            if(currChar =='+')
                break;
            else if(currChar =='.')
                continue;
            else
                sb.append(currChar);
        }
        return sb.toString();
    }
}