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
    public List<Integer> rightSideView(TreeNode root) {
        //BFS
        ArrayList<Integer> rightSide = new ArrayList<>();
        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int levelSize = queue.size();
                ArrayList<Integer> level = new ArrayList<>();
                for(int i = 0; i < levelSize; i++) {
                    TreeNode curr = queue.poll();
                    level.add(curr.val);
                    if(curr.left != null) queue.add(curr.left);
                    if(curr.right != null) queue.add(curr.right);
                }
                rightSide.add(level.get(level.size() - 1));
            }
        }
        return rightSide;
    }
}
