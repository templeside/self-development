class Solution {
    static int White = 1;            //enum으로 활용 가능할 지도!?
    static int Gray = 2;
    static int Black = 3;

    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topologicalOrder;

    //to start the algorithm.initiation
    private void init(int numCourses) {
        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayList<Integer>();

        // By default all vertces are White
        for (int i = 0; i < numCourses; i++) {
            this.color.put(i, White);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.init(numCourses);      //to start the algorithm.initiation

        // Create the adjacency list representation of the graph DB 구축
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);
        }

        // If the node is unprocessed, then call dfs on it.
        for (int i = 0; i < numCourses; i++) {
            if (this.color.get(i) == White) {
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
        this.color.put(node, Gray);

        // Traverse on neighboring vertices
        for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
            if (this.color.get(neighbor) == White) {
                this.dfs(neighbor);
            } else if (this.color.get(neighbor) == Gray) {
                // An edge to a Gray vertex represents a cycle
                this.isPossible = false;
            }
        }

        // Recursion ends. We mark it as black
        this.color.put(node, Black);
        this.topologicalOrder.add(node);
    }
}

