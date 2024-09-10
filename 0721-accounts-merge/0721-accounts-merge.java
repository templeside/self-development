class Solution {
    public class UnionFind {
    private int[] parents;

    public UnionFind(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find(int node) {
        if (parents[node] == node) {
            return node;
        }
        return find(parents[node]);
    }

    public void union(int node1, int node2) {
        int rootNode1 = find(node1);
        int rootNode2 = find(node2);
        if (rootNode1 != rootNode2) {
            parents[rootNode2] = rootNode1;
        }
    }
}

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> emailMapping = new HashMap<>();

        
        // prepare a hash with unique email address as key and index in accouts as value
        // <email address, index of the account>
        // union inside, uf contains the parent.
        for (int i = 0; i < accounts.size(); ++i) {
            List<String> emails = accounts.get(i);      // ["John","johnsmith@mail.com","john_newyork@mail.com"],
            for (int j = 1; j < emails.size(); ++j) {
                
                // if we have already seen this email before, merge the account  "i" with previous account
                // if we already found the id, union
                // else, put
                if (emailMapping.containsKey(emails.get(j))) {
                    if (!accounts.get(i).get(0).equals(accounts.get(emailMapping.get(emails.get(j))).get(0))) {
                        return new ArrayList<>(); 
                    }
                    uf.union(emailMapping.get(emails.get(j)), i);
                }
                emailMapping.put(emails.get(j), i);
            }
        }

        // prepare a hash with index in accounts as key and list of unique email address for that account as value
        Map<Integer, List<String>> mergedAccounts = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailMapping.entrySet()) {
            int root = uf.find(entry.getValue());
            mergedAccounts.computeIfAbsent(root, k -> new ArrayList<>());
            mergedAccounts.get(root).add(entry.getKey());
        }
        
        // collect the emails from idToEmails, sort it and add account name at index 0 to get the final list to add to final return List
        List<List<String>> finalMerged = new ArrayList<>();
        
        for (Map.Entry<Integer, List<String>> entry : mergedAccounts.entrySet()) {
            int parent = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(parent).get(0));
            merged.addAll(emails);
            finalMerged.add(merged);
        }
        return finalMerged;
    }
}