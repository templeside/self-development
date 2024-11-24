class Solution {
    /*
    prerequisites[a,b]
                - b -> a
    
    handle indegree - 0, 1...
    
    algo:
        create graph
        for prerequisites:
            count indegree
        for indegree:
            find 0-indegree
            add to BFS queue
        while BFS queue:
            add ordering to queue.
            
            for adj of currCourse:
                decrement indegree
                if(adj indegree == 0)
                    add to queue.
                    
        if n != ordering, return empty, or return the order
    data structure
        Map<course, #indegree> indegree
        Map<course, List<nextCourse>> graph
        List<Integer> order
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Map<course, #indegree> indegree
        // Map<course, List<nextCourse>> graph
        // List<Integer> order
        Map<Integer, Integer> inDegree =new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> order = new ArrayList<>();
        // Set<Integer> visited = new HashSet<>();
        
        // create graph
        for(int course=0; course< numCourses; course++){
            inDegree.put(course, 0);
            graph.put(course, new ArrayList<>());
        }
        // for prerequisites: [a,b] b-> a
            // count indegree
        for(int[] prereq: prerequisites){
            int a = prereq[0];
            int b = prereq[1];
            graph.get(b).add(a);
            inDegree.put(a, inDegree.get(a)+1);
        }
        
        Queue<Integer> queue =new ArrayDeque<>();
        // for indegree:
        for(int course=0; course< numCourses; course++){
            // find 0-indegree
            // add to BFS queue
            if(inDegree.get(course) == 0){
                queue.add(course);
                // visited.add(course);
            }
        }
        
        // while BFS queue:
        while(!queue.isEmpty()){
            int currCourse = queue.poll();
            
            // add ordering to queue.
            order.add(currCourse);
            
            // for adj of currCourse:
            for(int adj: graph.get(currCourse)){
                // decrement indegree
                inDegree.put(adj, inDegree.get(adj)-1);
                // if(adj indegree == 0 && not visited)
                if(inDegree.get(adj)== 0){
                    // add to queue.
                    queue.add(adj);
                }
            }
        }
        // if n != ordering, return empty, or return the order
        if(numCourses != order.size()){
            return new int[]{};
        }
        
        int[] returnVal = new int[numCourses];
        for(int i=0; i< numCourses; i++){
            returnVal[i] = order.get(i);
        }
        return returnVal;
    }
}