/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
public static int orderIdx; // order index
public TreeNode buildTree(int[] preorder, int[] inorder) {
	// <inorderValue, inorderIndex>
	Map<Integer, Integer> mapping = new HashMap<>();    
	int n = preorder.length;
	
	for(int i=0; i< n; i++){
		mapping.put(inorder[i], i);
	}
	
	orderIdx = 0;
	
	return postDFS(preorder, inorder, 0, n-1, mapping);
}

public TreeNode postDFS(int[] preorder, int[] inorder, int left, int right, Map<Integer, Integer> mapping){
		if(left>right){    //base case - when out of range
		return null;
	}
	
	int curr = preorder[orderIdx];
	orderIdx++;
	TreeNode root = new TreeNode(curr);
	
	if(left == right){   // base case - when leaf
		return root;
	}
	
	int inIndex = mapping.get(curr);  // middle index 찾아 left, right range
	
	root.left = postDFS(preorder, inorder, left, inIndex-1, mapping);
	root.right = postDFS(preorder, inorder, inIndex+1, right, mapping);
	return root;
}
}