class Solution {
    /*
    all things are tablized
    topo sort.
    
    generate inDegree map
    generate adjacency<vertex, adjacencies> map
    generate set visited 
    find 0 inDegree map
    
    while bfs:
        update visited
        update adjacencies:
            update indegree
            if indegree ==0, add to queue

    visited.size() == num courses
     
       1<-0
     [[1,0]]
 target <- source
[[1,4],[2,4],[3,1],[3,2]]


indegree {1=1, 2=1, 3=2, 4=0}
graph {1=[3], 2=[3], 3=[], 4=[1, 2]}
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0)
            return true;
        Map<Integer, Integer> inDegree= new HashMap<>(); // < vertex, # of indegree. no requirements>
        Map<Integer, List<Integer>> graph = new HashMap<>();  // vertex, adjacency
        Set<Integer> visited = new HashSet<>();
        
        for(int i=0; i< numCourses; i++){
            inDegree.put(i,0);
            graph.put(i, new ArrayList());
        }
        
        for(int[] prerequisite: prerequisites){ // r[1] -> r[0] source target
            int source = prerequisite[1];
            int target = prerequisite[0];
            
            // inDegree.putIfAbsent(source,0);
            // inDegree.putIfAbsent(target,0);
            inDegree.put(target, inDegree.get(target)+1);
            // graph.putIfAbsent(source, new ArrayList());
            // graph.putIfAbsent(target, new ArrayList());
            graph.get(source).add(target);
        }
        
        // System.out.println(inDegree);
        // System.out.println(graph);
        Queue<Integer> nodeIterator = new ArrayDeque<>();
        
        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()){
            if(entry.getValue() ==0){
                nodeIterator.add(entry.getKey());
            }
        }
        
        while(!nodeIterator.isEmpty()){
            int currCourse = nodeIterator.poll();
            
            visited.add(currCourse);
            for(int adj : graph.get(currCourse)){
                inDegree.put(adj, inDegree.get(adj)-1);
                if(inDegree.get(adj) ==0)
                    nodeIterator.add(adj);
            }
        }
        return numCourses == visited.size();
    }
}