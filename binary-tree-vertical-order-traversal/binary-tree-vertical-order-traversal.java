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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root ==null)return new ArrayList<>();
        // <Index, list<Integer>>
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int index = 100;
        bfs(root, index, map);
        
        List<List<Integer>> order = new ArrayList<>();
        System.out.println(map.keySet());
        
        Set<Integer> keyset = map.keySet();
        Integer[] keys = keyset.toArray(new Integer[map.size()]);
        Arrays.sort(keys);
        for(int key: keys){
        // for(int key: map.keySet()){
            order.add(map.get(key));
        }
        return order;
    }
    
    public class Node{
        public int index;
        public TreeNode node;
        
        public Node(int index, TreeNode node){
            this.index = index;
            this.node = node;
        }
    }
    
    private void bfs(TreeNode root, int index, HashMap<Integer, List<Integer>> map){
        if(root == null)return;   //base case
        // {index, node}
        LinkedList<Node> q = new LinkedList<Node>();
        LinkedList<Node> nextQ = new LinkedList<Node>();
        
        nextQ.add(new Node(index, root));
        while(!nextQ.isEmpty()){
            q = nextQ;
            nextQ = new LinkedList<Node>();
            
            while(!q.isEmpty()){
                Node currNode = q.poll();
                int currIndex = currNode.index;
                TreeNode currRoot = currNode.node;
                
                // hasmap에 넣기
                if(!map.containsKey(currIndex))
                    map.put(currIndex, new LinkedList<Integer>());
                map.get(currIndex).add(currRoot.val);                
                
                if(currRoot.left !=null)
                    nextQ.add(new Node(currIndex-1, currRoot.left));
                
                if(currRoot.right !=null)
                    nextQ.add(new Node(currIndex+1, currRoot.right));
            }
        }
        return;
    }
}