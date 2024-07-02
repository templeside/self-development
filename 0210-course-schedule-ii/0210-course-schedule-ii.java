class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();  // courses looking for child courses
        HashMap<Integer, Integer> numPrerequisite = new HashMap<>();
        
        // add to hashmap
        for(int i=0; i< numCourses; i++){
            adjList.put(i, new ArrayList<>());
            numPrerequisite.put(i, 0);
        }
        // add prerequisites
        for(int[] prerequisite: prerequisites){
            int prereq=prerequisite[1];
            int currCourse = prerequisite[0];
            adjList.get(prereq).add(currCourse);    // currCourse is child course. prereq -> currCourse
            numPrerequisite.put(currCourse, numPrerequisite.get(currCourse)+1);
        }
        
        List<Integer> courseOrder = new LinkedList<>();
        Queue<Integer> bfsIterator = new LinkedList<>();
        
		// find no requisite
        for(Map.Entry<Integer,Integer> entry: numPrerequisite.entrySet()){
            if(entry.getValue() == 0)
                bfsIterator.add(entry.getKey());
        }
		
		// do bfs
        while(bfsIterator.size()>0){
            int currCourse = bfsIterator.poll();
            courseOrder.add(currCourse);
            
            for(int childCourse: adjList.get(currCourse)){
                numPrerequisite.put(childCourse, numPrerequisite.get(childCourse)-1);
                if(numPrerequisite.get(childCourse)==0)
                    bfsIterator.add(childCourse);
            }
        }
        if(courseOrder.size() != numCourses)return new int[]{};
        
        int[] returnOrder = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            returnOrder[i] = courseOrder.get(i);
        }
        return returnOrder;
    }
}