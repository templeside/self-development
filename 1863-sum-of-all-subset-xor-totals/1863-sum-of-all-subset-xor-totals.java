class Solution {
    int totalSum;
    public int subsetXORSum(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        totalSum = 0;
        ArrayList<Integer> currArray = new ArrayList();
        
        dfs(visited, 0,currArray, nums);
        
        return totalSum;
    }
    public void dfs(boolean[] visited, int currIdx, ArrayList<Integer> currArray, int[] nums){
        if(currArray.size() > nums.length)return;      //base case
        
        totalSum += xor(currArray);
        
        for(int i=currIdx; i< nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                currArray.add(nums[i]);
                
                dfs(visited, i, currArray, nums);
                
                visited[i] = false;
                currArray.remove(currArray.size()-1);
            }
        }
    }
    
    
    public int xor(ArrayList<Integer> arr){
        int temp = 0;
        for(int i= 0; i< arr.size();i++){
            temp = temp ^arr.get(i);
        }
        return temp;
    }
}