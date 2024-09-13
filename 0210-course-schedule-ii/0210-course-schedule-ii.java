class Solution {
    /*
Input: numCourses = 2, 
               target source
prerequisites = [[1,0]]
        source -> target
Output: [0,1]

generate map<vertex, List<adjacencies>> graph
in-Degree map<vertex, # incoming degrees>

find 0 indegree
    add to bfsIterator.

while iteration:
    add to order(curr)
    
    for adjacencies:
        decrement indegree
        if(indegree ==0)
            add to iterator
return order.size() == numCourses? order: empty array
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> order = new ArrayList<>();
//         generate map<vertex, List<adjacencies>> graph
//         in-Degree map<vertex, # incoming degrees>
        Map<Integer, List<Integer>> graph = new HashMap<>();
//         find 0 indegree
        Map<Integer, Integer> inDegree= new HashMap<>();
        //add prerequisites
        for(int i=0; i< numCourses; i++){
            graph.put(i, new ArrayList<>());
            inDegree.put(i,0);
        }
        for(int[] prerequisite: prerequisites){
            int target = prerequisite[0];
            int source = prerequisite[1];
            graph.get(source).add(target);
            inDegree.put(target, inDegree.get(target)+1);
        }
//             add to bfsIterator.
        Queue<Integer> bfsIterator = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree.get(i) ==0)
                bfsIterator.add(i);
        }
//         while iteration:
        while(!bfsIterator.isEmpty()){
            int currCourse = bfsIterator.poll();
//             add to order(curr)
            order.add(currCourse);
//             for adjacencies:
            for(int adj: graph.get(currCourse)){
//                 decrement indegree
                inDegree.put(adj, inDegree.get(adj)-1);
//                 if(indegree ==0)
                if(inDegree.get(adj) == 0)
//                     add to iterator
                    bfsIterator.add(adj);
            }
        }
        if(order.size() == numCourses){
            int[] returnVal = new int[numCourses];
            for(int i=0; i< numCourses;i++){
                returnVal[i] = order.get(i);
            }
            return returnVal;
        }else{
            return new int[]{};
        }
            
        

    }
}