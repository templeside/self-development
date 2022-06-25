class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        
        HashMap<Integer, Integer> incomingCounter = new HashMap<>();
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0; i< numCourses; i++){
            incomingCounter.put(i, 0);
            adjList.put(i, new ArrayList<Integer>());
        }
        
        for(int[] prerequisite: prerequisites){
            int prereq = prerequisite[0];
            int totake = prerequisite[1];
            
            incomingCounter.put(totake, incomingCounter.get(totake)+1);
            adjList.get(prereq).add(totake);
        }
        
        Queue<Integer> sources= new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: incomingCounter.entrySet()){
            if(entry.getValue()==0)
                sources.add(entry.getKey());
        }
        
        while(!sources.isEmpty()){
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = adjList.get(vertex);
            for(int child: children){
                incomingCounter.put(child, incomingCounter.get(child)-1);
                if(incomingCounter.get(child)==0)
                    sources.add(child);
            }
        }
        System.out.println(sortedOrder);
        if(sortedOrder.size()!= numCourses)
            return new int[]{};
        int[] returnval = new int[sortedOrder.size()];
        for(int i=0; i<sortedOrder.size();i++)
            returnval[numCourses-1-i] = sortedOrder.get(i);
        return returnval;
    }
}