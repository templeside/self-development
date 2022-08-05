class Solution {
    /**
    for intuition, it is like a graph. find all of the adjacencies to make it sure it is a valid adjacent email, and make the common firstEmail.
    어떻게 만드는가? 어차피 모든 것이firstemail로 돌아오게만 하면 된다.... 이거지
    first email로 adjacent한 그래프들은 모두 연결이 되거든.
    
    1. initialize all the adjacency list - HashMap<currEmail, List<adjacencis>>
    2. visitedSet to avoid overlapping accounts- HashSet<emails>  
    3. traverse each accounts
        a. if first email visited, do not iterate.
        b. during iteration, store the traversed iteration in an array mergedAccount
    4. after the iteration is over, create the sort the emails and the account name.
    5. store the vector mergedAccount in the return value mergedAccounts.
    **/
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashSet<String> visited= new HashSet<>();
        HashMap<String, List<String>> adjacent = new HashMap<>();
        
        // building adjacency list
        // adding edge between first email to all other emails in the account.
        // accountFirstEamil가지고 connecting을 하려고 하네. 그래야 연결이 편하니까.
        // 그렇다면 accountFirstEmaiil이 아닌 다른 email로 connected 되면 어떻게 하는 거지???
        // adjacent라고 하는 global hashMap에서 accountFirstEmail로 다 통하기를 만들어 버린다.
        for(List<String> account: accounts){
            String accountFirstEmail = account.get(1);
            
            for(int i=2; i< account.size(); i++){
                String accountEmail = account.get(i);
                
                if(!adjacent.containsKey(accountFirstEmail))
                    adjacent.put(accountFirstEmail, new ArrayList<>());
                adjacent.get(accountFirstEmail).add(accountEmail);
                if(!adjacent.containsKey(accountEmail))
                    adjacent.put(accountEmail, new ArrayList<>());
                adjacent.get(accountEmail).add(accountFirstEmail);
                
            }
        }
        
        // Traverse over all the accounts to store components
        List<List<String>>mergedAccounts = new ArrayList<>();
        for(List<String> account: accounts){
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);
            
            // If email is visited, then it's a part of different component
            // Hence perform DFS only if email is not visited yet   
            if(!visited.contains(accountFirstEmail)){
                List<String> mergedAccount = new ArrayList<>();
                // Adding account name at the 0th index
                mergedAccount.add(accountName);
                
                DFS(visited, adjacent, mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }
        return mergedAccounts;
    }
    
    /**
    각 node마다 adjacencies들이 있을 테니, adjacent한 놈들을 통해 계속 뻗쳐 나가는 방법이다.
    현 놈들 adjacent email중에서, 계속 계속 뻗어 나가는 게지. 신경이 퍼지듯이. 
    왜냐면 이미 initialization에서 adjacents들을 모두 다 그래프화 시켜 놓았으니까. 
    그렇다면 bfs에서는 어떻게 했었을까? 똑같이 했었을 것이다. adjacencies들을 다 확인하고, 그다음에 iterator에다가 넣고. 다른게 없다. DFS를 굳이 써야 할 필요도 없다. BFS나 DFS나 똑같은 방법이다.
    
    그럼 굳이 firstEmail로 모아야 하는 이유가 있을까???? 
    친구들 중에 다른 adjacency가 있으면 다른 accountFirstEmail로 이동할 것이다. 그러면 그 다른 accountFirstEmail이 다른 노드들로 연결을 해주며 adjacent email로 보내준다.
    **/
    public void DFS(HashSet<String> visited, HashMap<String, List<String>> adjacent, List<String> mergedAccount, String email){
        visited.add(email);
        
        // Add the email vector that contains the current component's emails
        mergedAccount.add(email);
        if(!adjacent.containsKey(email))   
            return;
        
        // 다른 노드들로 이동시켜 주기 위한 행동.
        for(String neighbor: adjacent.get(email)){
            if(!visited.contains(neighbor))
                DFS(visited, adjacent, mergedAccount, neighbor);
        }
    }
}