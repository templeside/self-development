/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root ==null)return new String("");
        LinkedList<TreeNode> currList = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextList = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        nextList.add(root);
        
        while(!nextList.isEmpty()){
            currList = nextList;
            nextList = new LinkedList<TreeNode>();
            
            while(!currList.isEmpty()){
                TreeNode curr = currList.poll();
                if(curr !=null){
                    sb.append(curr.val);
                    sb.append(',');                    
                }

                
                if(curr.left !=null)
                    nextList.add(curr.left);
                if(curr.right !=null)
                    nextList.add(curr.right);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() ==0)return null;
        String[] set = data.split(",");
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        for(String s: set){
            int i = Integer.parseInt(s);
            q.add(i);
        }
        
        
        return BST(q);
        
    }
    public TreeNode BST(ArrayDeque<Integer> q){
        if(q.isEmpty()) return null;
        
        TreeNode head = new TreeNode(q.poll());
        
        while(!q.isEmpty()){
            function(head, q);
        }
        return head;
    }
    public TreeNode function(TreeNode root, ArrayDeque<Integer> q){
        if(root ==null) return new TreeNode(q.poll());
        
        if(root.val> q.peek()){
            root.left = function(root.left,q);
        }
        
        else{
            root.right = function(root.right,q);
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;