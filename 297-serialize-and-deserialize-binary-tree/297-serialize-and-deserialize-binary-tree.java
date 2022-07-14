/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
identifier, null pointer
*/
public class Codec {
    
    // Encodes a tree to a single string.
    public static StringBuilder sb;
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        serializeDFS(root);
        return sb.toString();
    }
    public void serializeDFS(TreeNode root){
        if(root == null){
            sb.append("x");
            sb.append(" ");
        }
        else{
            sb.append(root.val);
            sb.append(" ");
            serializeDFS(root.left);
            serializeDFS(root.right);
        }
    }
    // Decodes your encoded data to tree.
    public static Integer splittedIdx;
    public TreeNode deserialize(String data) {
        String[] splitted = data.split(" ");
        splittedIdx= 0;
        return deserializeDFS(splitted);
    }
    
    
    public TreeNode deserializeDFS(String[] splitted){
        // base case : when splittedIdx>= splitted.length, splitted[i] == x
        if(splittedIdx>= splitted.length)return null;
        
        if(splitted[splittedIdx].equals("x")){
            splittedIdx++;
            return null;
        }
        TreeNode returnNode = new TreeNode(Integer.valueOf(splitted[splittedIdx]));
        splittedIdx++;
        returnNode.left = deserializeDFS(splitted);
        returnNode.right = deserializeDFS(splitted);
        return returnNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));