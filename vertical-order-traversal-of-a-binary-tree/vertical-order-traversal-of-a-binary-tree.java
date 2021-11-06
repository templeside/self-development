class Solution{
	private Queue<int[]> nodeEntries;
	public List<List<Integer>> verticalTraversal(TreeNode root){
		nodeEntries = new PriorityQueue<>((e1, e2)->{
			for(int i=0; i<e1.length;i++){
				if(e1[i] != e2[i]) 
					return e1[i]-e2[i];
            }
			return 0;
		});
		dfs(root, 0,0);
		List<List<Integer>> output = new ArrayList<>();
		int currentCol = Integer.MIN_VALUE;
		while(!nodeEntries.isEmpty()){
			int[] entry = nodeEntries.remove();
			if(entry[0] != currentCol){
				currentCol = entry[0];
				output.add(new ArrayList<>());
			}
			output.get(output.size()-1).add(entry[2]);
		}
		return output;
	}
	
	private void dfs(TreeNode root, int col, int row){
		if(root ==null) return;
		nodeEntries.add(new int[]{col, row, root.val});
		dfs(root.left, col-1, row+1);
		dfs(root.right, col+1, row+1);
    }
}