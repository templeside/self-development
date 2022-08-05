class Solution {
    /**
    아니 이게 왜 topological sort를 써야 하는거지???? 
    topological sort를 사용하면, leaf node를 구별해 낼 수 있어서???
    leaf node란 무엇인가? leaf node가 된다면, minimum height node가 될 수 없는 존재이다.
    
    We can implement the above process using the topological sort. 
    Any node with only one edge (i.e., a leaf) can be our source and, 
    in a stepwise fashion, we can remove all sources from the graph to find new sources. 
    We will repeat this process until we are left with one or two nodes in the graph, 
    which will be our answer.


    **/
    public List<Integer> findMinHeightTrees(int nodes, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();
        if(nodes<=0) return minHeightTrees;
        
        // with only one node, since its in-degree will be 0, therefore, we need to handle it seperately
        if(nodes == 1){
            minHeightTrees.add(0);
            return minHeightTrees;
        }
        
        // a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>();// count of incoming edges for every verex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for(int i=0; i< nodes; i++){
            inDegree.put(i,0);
            graph.put(i, new ArrayList<Integer>());
        }
        
        // b. build the graph   
        for(int i= 0; i< edges.length; i++){
            int n1 = edges[i][0], n2 = edges[i][1];
            // since this is an undirected graph, add a link for both nodes.
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
            // increment the in-degrees of both nodes
            inDegree.put(n1, inDegree.get(n1)+1);
            inDegree.put(n2, inDegree.get(n2)+1);
        }
        
        // c. find all leaves i.e., all nodes with only 1 in-degree
        Queue<Integer> leaves = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry: inDegree.entrySet()){
            if(entry.getValue() ==1)        // all nodes with only 1 in-degree
                leaves.add(entry.getKey()); // 왜 only 1 이 될까??? 왜 only1을 하고 있을까???\
        }                                   // leaf node들을 찾고 있다. edge 하나는 parent node를 위한 edge.
        
        // d. Remove leaves level by level and subtract each eave's children's in-degrees.
        // Repeat this until we are left with 1 or 2 nodeswhich will be our answer.
        // Any node that has already been a leaf cannot be the root of a minimum height tree, 
        // because its adjacent non-left node will always be a better candidate..?
        int totalNodes = nodes;
        while(totalNodes>2){                    // minimum height node는 무조건 1개 혹은 2개이다. 왜????
            int leavesSize = leaves.size();     
            totalNodes -= leavesSize;
            
            for(int i=0; i< leavesSize; i++){
                int vertex = leaves.poll();
                List<Integer> children = graph.get(vertex);
                for(int child: children){
                    inDegree.put(child, inDegree.get(child)-1);
                    if(inDegree.get(child)==1)      // if the hcild has become a leaf
                        leaves.add(child);
                }
            }
        }
        minHeightTrees.addAll(leaves);
        return minHeightTrees;
    }
}