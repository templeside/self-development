class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
            // <any email, owner name>
        Map<String, String> owner = new HashMap<>();
            // <any meail, parent email>
        Map<String, String> parents = new HashMap<>();
            // <parentEmail, union>
        Map<String, TreeSet<String>> unions = new HashMap<>();
        
        for(List<String> account: accounts){
            for(int i=1; i< account.size();i++){
                owner.put( account.get(i), account.get(0));
                parents.put( account.get(i), account.get(i));
            }
        }
        
        for(List<String> account: accounts){
            String p = findParent(account.get(1),parents);
            for(int i=2; i< account.size();i++)
                parents.put(findParent(account.get(i), parents),p);
        }
        
        for(List<String> account: accounts){
            String p = findParent(account.get(1), parents);
            if(!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for(int i=1; i<account.size();i++)
                unions.get(p).add(account.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for(String p: unions.keySet()){
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0,owner.get(p));
            res.add(emails);
        }
        return res;
        
    }
    
    public String findParent(String s, Map<String, String> p){
        return p.get(s)==s? s: findParent(p.get(s),p);
    }
}