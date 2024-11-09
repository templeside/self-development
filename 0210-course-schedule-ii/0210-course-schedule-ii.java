class Solution {
    /*
    does well when having the 
    
    starting from indegree of 0, shift to the end
    
    add to queue
    iterate over adjacnecies:
        if(adj valid)
            add to queue.
        
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue =new ArrayDeque<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        
        for(int i=0; i<numCourses; i++){
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }
        for(int[] prereq: prerequisites){   // 1,0  0 is required, 1 is course  required -> course
            int required = prereq[1];
            int course = prereq[0];
            inDegree.put(course, inDegree.get(course)+1);
            graph.get(required).add(course);
        }
        
        for(int course=0; course< numCourses; course++){
            if(inDegree.get(course) == 0)
                queue.add(course);
        }
        
        List<Integer> courseOrder = new ArrayList<>();
        while(!queue.isEmpty()){
            int currCourse = queue.poll();
            courseOrder.add(currCourse);
            
            // look for adjacencies
            for(int adj: graph.get(currCourse)){
                inDegree.put(adj, inDegree.get(adj)-1);
                
                if(inDegree.get(adj)== 0){
                    queue.add(adj);
                }
            }            
        }
        
        if(courseOrder.size() !=numCourses)
            return new int[]{};
        
        int[] returnVal = new int[courseOrder.size()];
        for(int i=0; i<courseOrder.size(); i++){
            returnVal[i] = courseOrder.get(i);
        }
        
        return returnVal;
    }
}