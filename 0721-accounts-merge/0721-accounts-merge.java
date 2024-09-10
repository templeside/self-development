class Solution {
    class UnionFind {
        private Map<Integer, Integer> parents;
        public UnionFind(int n) {
            parents = new HashMap<>();
            for (int i = 0; i < n; i++) {
                parents.put(i,i);
            }
        }

        public int find(int node) {
            if(parents.get(node) == node){
                return node;
            }
            return find(parents.get(node));
        }

        public void union(int node1, int node2) {
            int rootNode1 = find(node1);
            int rootNode2 = find(node2);
            if (rootNode1 != rootNode2) {
                parents.put(rootNode2, rootNode1);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();

        UnionFind uf = new UnionFind(size);

        // prepare a hash with unique email address as key and index in accouts as value
        HashMap<String, Integer> emailToId = new  HashMap<>();
        for(int i = 0; i < size; i++) {
            List<String> details = accounts.get(i);
            for(int j = 1; j < details.size(); j++) {
                String email = details.get(j);
                
				// if we have already seen this email before, merge the account  "i" with previous account
				// else add it to hash
                if (emailToId.containsKey(email)) {
                    uf.union(i, emailToId.get(email));
                } else  {
                    emailToId.put(email, i);
                }
            }
        }
        
        // prepare a hash with index in accounts as key and list of unique email address for that account as value
        HashMap<Integer, List<String>> idToEmails = new HashMap<>();
        for(String key : emailToId.keySet()) {
            int root = uf.find(emailToId.get(key));
            
            if (!idToEmails.containsKey(root)) {
                idToEmails.put(root, new ArrayList<String>());
            }
            
            idToEmails.get(root).add(key);
        }
        
        // collect the emails from idToEmails, sort it and add account name at index 0 to get the final list to add to final return List
        List<List<String>> mergedDetails =  new ArrayList<>();
        for(Integer id : idToEmails.keySet()) {
            List<String> emails =  idToEmails.get(id);
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));
            
            mergedDetails.add(emails);
        }
        
        return  mergedDetails;
    }
}