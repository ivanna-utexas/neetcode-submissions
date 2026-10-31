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
    public int kthSmallest(TreeNode root, int k) {
        //Valid BST -> In-order DFS traversal will give you sorted order
        ArrayList<Integer> sortedOrder = new ArrayList<>();
        inOrder(root, k - 1, sortedOrder);
        return sortedOrder.get(k - 1);
    }

    private void inOrder(TreeNode current, int k, ArrayList<Integer> sortedOrder) {
        if(current == null || sortedOrder.size() > k) return;
        inOrder(current.left, k, sortedOrder);
        sortedOrder.add(current.val);
        inOrder(current.right, k, sortedOrder);    
    }
}
