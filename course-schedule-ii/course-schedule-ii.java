class Solution {
    static int notVisited = 1;            //enum으로 활용 가능할 지도!?
    static int visiting = 2;
    static int visited = 3;

    boolean isPossible;
    Map<Integer, Integer> visitCheck;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topologicalOrder;

    //to start the algorithm.initiation
    private void init(int numCourses) {
        this.isPossible = true;
        this.visitCheck = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayList<Integer>();

        // By default all vertces are notVisited
        for (int i = 0; i < numCourses; i++) {
            this.visitCheck.put(i, notVisited);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.init(numCourses);      //to start the algorithm.initiation

        // Create the adjacency list representation of the visiting DB 구축
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);
        }

        // If the node is unprocessed, then call dfs on it.
        for (int i = 0; i < numCourses; i++) {
            if (this.visitCheck.get(i) == notVisited) {
                this.dfs(i);
            }
        }

        if(!this.isPossible)    //edge case
            return new int[0];

        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            order[i] = this.topologicalOrder.get(numCourses - i - 1);   //왜 numCourses-i -1? 갯수라서. 뒤에서 부터 가져오고 싶었기 때문.
        return order;
    }

    private void dfs(int node) {
        // Edge case. Don't recurse further if we found a cycle already
        if (!this.isPossible)
            return;

        // Start the recursion
        this.visitCheck.put(node, visiting);

        // Traverse on neighboring vertices
        for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
            if (this.visitCheck.get(neighbor) == notVisited) {
                this.dfs(neighbor);
            } else if (this.visitCheck.get(neighbor) == visiting) {
                // An edge to a visiting vertex represents a cycle
                this.isPossible = false;
            }
        }

        // Recursion ends. We mark it as visited
        this.visitCheck.put(node, visited);
        this.topologicalOrder.add(node);
    }
}