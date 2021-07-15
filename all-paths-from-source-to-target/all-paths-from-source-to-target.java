class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(0));
        
        int goalNode = graph.length-1;
        
        while(!queue.isEmpty()){
            List<Integer> path = queue.poll();
            int lastNode = path.get(path.size()-1);
            
            if(lastNode ==goalNode){
                result.add(new ArrayList<>(path));
            }else{
                int[] neighbors = graph[lastNode];
                for(int neighbor: neighbors){
                    List<Integer> list = new ArrayList<>(path);
                    list.add(neighbor);
                    queue.add(list);
                
                }
            }
        }
        return result;
    }
}