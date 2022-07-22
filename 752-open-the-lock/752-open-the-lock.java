class Solution {
    /**
    starting from '0000' heading to the target.
    
    deadends are obstacles.
    
    do the bfs with the lock.
        get the children by adding 
    
    if could not found, return -1.
    **/
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000"))return 0;
        
        Set<String> deadend = new HashSet<>();
        for(String dead: deadends){
            if(dead.equals("0000"))return -1;
            deadend.add(dead);
            
        }
            
        
        Queue<String> queue = new LinkedList();
        queue.add("0000");
        int count =0;
        
        while(queue.size()>0){
            count ++;
            int n= queue.size();
            
            for(int i=0; i< n;i++){
                String currString = queue.poll();
                
                List<String> adjacents = getValidAdjacents(currString, deadend);
                for(String adjacent: adjacents){
                    if(adjacent.equals(target))return count;
                    queue.add(adjacent);
                    deadend.add(adjacent);
                }
            }
        }
        return -1;
    }
    
    public List<String> getValidAdjacents(String currString, Set<String> deadend){
        List<String> adjacents = new LinkedList<>();
        
        for(int i=0; i< 4; i++){
            for(int d= -1; d<=1; d+=2){
                int y = ((currString.charAt(i)-'0')+d+10)%10;
                String adjacent = currString.substring(0,i)+(""+y)+currString.substring(i+1);
                if(!deadend.contains(adjacent)){
                    adjacents.add(adjacent);
                }
            }
        }
        return adjacents;
    }
}