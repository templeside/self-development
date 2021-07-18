class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        
        for(int i=0; i< isConnected.length;i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs( int[][] isConnected, boolean[]visited, int idx){
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[idx][i] ==1 && !visited[i] ){
                visited[i] = true;
                dfs(isConnected, visited, i);
            }
        }
        
    }
}