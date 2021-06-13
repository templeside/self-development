class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root ==null)return new LinkedList<Integer>();
        //bfs
        List<Integer> rightSide = new LinkedList<Integer>();
        //arraydequeue 는 referencing을 하지 않는다(LinkedList는 한다). linkedlist로 구성하면, levels에 모든 nodes들이 추가 됨.
        ArrayDeque<ArrayDeque<TreeNode>> levels = new ArrayDeque<>();   //total db
        ArrayDeque<TreeNode> currLevel = new ArrayDeque<>();            //curr level to check right side
        ArrayDeque<TreeNode> nextLevel;                                 //next level adding with curr level nodes' children

        currLevel.add(root);
        levels.add(currLevel);
        TreeNode node = null;

        while(!levels.isEmpty()){
            currLevel = levels.poll();          // curr level from total db
            nextLevel = new ArrayDeque<>();     // making the next level
            while(!currLevel.isEmpty()){
                node = currLevel.poll();
                if(node.left !=null)            //adding to next level
                    nextLevel.add(node.left);
                if(node.right !=null)           //adding to next level
                    nextLevel.add(node.right);
            }

            rightSide.add(node.val);
            if(!nextLevel.isEmpty())
                levels.add(nextLevel);
        }
        return rightSide;
    }
}

