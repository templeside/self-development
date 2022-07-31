class Solution {
    /**
    need to think of prerequisite on the schedule.
    then, I can use topological sort to checking while i am iterating through gcourses.
    
    1. initiate prerequisites in hash map as a graph:
    inDegree< course, number of prerequisites>
    childrenMap<prerequisite, course> prerequisite-> course edge.
    
    2. look for the courses which doesnt need prerequisite. 
    inDegree.get(course) == 0
    
    3. iterate through the non-prerequisite courses, and thinking of removing this courses.
    in this case the childrenCourses containing non-prerequisite courses as a requisite should decrement their prerequisite number.
    then check the children is also became a non-prerequisite course.
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> childrenMap =new HashMap<>();
        for(int course=0; course< numCourses; course++){
            inDegree.put(course,0);
            childrenMap.put(course, new ArrayList<>());
        }
        for(int[] prerequisite: prerequisites){
            int prereq = prerequisite[0];
            int course = prerequisite[1];
            inDegree.put(course, inDegree.get(course)+1);
            childrenMap.get(prereq).add(course);
        }
        
        Queue<Integer> schedule = new LinkedList<>();
        Queue<Integer> topoIterator = new LinkedList<>();
        for(int course =0; course<numCourses;course++)
            if(inDegree.get(course)==0)
                topoIterator.add(course);
        
        while(topoIterator.size()>0){
            int currCourse = topoIterator.poll();
            schedule.add(currCourse);
            
            for(int nextCourse: childrenMap.get(currCourse)){
                inDegree.put(nextCourse, inDegree.get(nextCourse)-1);
                if(inDegree.get(nextCourse)==0)
                    topoIterator.add(nextCourse);
            }
        }
        return schedule.size()== numCourses;
    }
}