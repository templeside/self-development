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
        String result = serializeDFS(root);
        return result;
    }
    
    public static String serializeDFS(TreeNode root){
        if(root ==null)return "null";
        
        String serial = Integer.toString(root.val);
        serial += "," + serializeDFS(root.left);
        serial += "," + serializeDFS(root.right);
        return serial;
    }

    /*
    [1,2,null,null,3,4,null,null,5,null,null]
    
     1
    / \
   2   3
      / \
     4   5
     
    returnVal TreeNode
    if(val == null)
        return null
    have the root
    root.left = dfs(left)
    root.right = dfs(right)
    
    how to iterate?
    iterator
    */
    
    public Integer stringIdx = 0;
    public TreeNode deserialize(String data) {
        String[] splitted = data.split(",");
        System.out.println(Arrays.toString(splitted));
        return deserializeDFS(splitted);
    }
    
    public TreeNode deserializeDFS(String[] splitted){
        String nextVal = splitted[stringIdx++];

        if(nextVal.equals("null")){
            return null;
        }
                    
        TreeNode root = new TreeNode(Integer.parseInt(nextVal));
        root.left = deserializeDFS(splitted);
        root.right = deserializeDFS(splitted);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));