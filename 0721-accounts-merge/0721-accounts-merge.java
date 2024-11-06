class Solution {
    /*
    i'm basically having the number of accounts.

    what i need to do is when 
                     name           emails,      emails....
Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]

find the representative email to connect all the related emails with name.

hahsmap<email, representative email> 

    */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, List<String>> graph = new HashMap<>();
        HashSet<String> visited = new HashSet<>();

        for(List<String> account : accounts){
            String accountFirstEmail = account.get(1);

            for(int i=2; i< account.size(); i++){
                String accountCurrEmail = account.get(i);

                graph.putIfAbsent(accountFirstEmail, new ArrayList<>());
                graph.get(accountFirstEmail).add(accountCurrEmail);

                graph.putIfAbsent(accountCurrEmail, new ArrayList<>());
                graph.get(accountCurrEmail).add(accountFirstEmail);
            }
        }

        List<List<String>> mergedAccounts = new ArrayList<>();

        for(List<String> account: accounts){
            String accountName= account.get(0);
            String accountFirstEmail = account.get(1);

            if(!visited.contains(accountFirstEmail)){
                List<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(accountName);
                DFS(visited, graph, mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }
        return mergedAccounts;
    }
    public void DFS(HashSet<String> visited, HashMap<String, List<String>> graph, List<String> mergedAccount, String accountCurrEmail){
        if(visited.contains(accountCurrEmail))
        return;

        visited.add(accountCurrEmail);

        mergedAccount.add(accountCurrEmail);

        if(!graph.containsKey(accountCurrEmail)){
            return;
        }

        for(String adjEmail: graph.get(accountCurrEmail)){
            DFS(visited, graph, mergedAccount, adjEmail);
        }
    }
}