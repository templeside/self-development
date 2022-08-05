class Solution {
    /**
    how to solve this problem??
    hashmap - list iteration
    O(N)
    
    the email accounts will going to be the key of hashmap.
    hashMap<email, accountIndex>
    
    1. accounts iteration
    2. if found containsKey( email, update all the emails to the index of the key).
    3. move on to next iteration.
    4. after that, make the returnValue.
    이 방법도 좋긴 좋은데, 만약 두개 이상이 연결되어 있다면은 불가능한 방법이다.
    
    
    time complexity: O(N). N is the length of accounts.
    **/
    HashSet<String> visited = new HashSet<>();
    Map<String, List<String>> adjacent = new HashMap<String, List<String>>();
    private void DFS(List<String> mergedAccount, String email){
        visited.add(email);
        
        mergedAccount.add(email);
        if(!adjacent.containsKey(email))
            return;
        for(String neighbor: adjacent.get(email)){
            if(!visited.contains(neighbor))
                DFS(mergedAccount, neighbor);
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accountListSize = accounts.size();
        
        for(List<String> account: accounts){
            int accountSize = account.size();
            
            // building adjacency list
            // adding edge between first email to all other emails in the account.
            // kinda vertex.
            // accountFirstEamil가지고 connecting을 하려고 하네. 그래야 연결이 편하니까.
            String accountFirstEmail = account.get(1);
            for(int j=2; j< accountSize; j++){
                String accountEmail = account.get(j);
                
                if(!adjacent.containsKey(accountFirstEmail))
                    adjacent.put(accountFirstEmail, new ArrayList<String>());
                adjacent.get(accountFirstEmail).add(accountEmail);
                
                if(!adjacent.containsKey(accountEmail))
                    adjacent.put(accountEmail, new ArrayList<String>());
                adjacent.get(accountEmail).add(accountFirstEmail);
            }
        }
        
        // Traverse over all the accounts to store components
        List<List<String>> mergedAccounts = new ArrayList<>();
        for(List<String> account: accounts){
            String accountName= account.get(0);
            String accountFirstEmail = account.get(1);
            
            if(! visited.contains(accountFirstEmail)){
                List<String> mergedAccount = new ArrayList<>();
                // Adding account name at the 0th index
                mergedAccount.add(accountName);
                
                DFS(mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }
        return mergedAccounts;
    }
}