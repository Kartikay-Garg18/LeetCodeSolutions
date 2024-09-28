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
    public int count(TreeNode root, int max){
        if(root == null) return 0;
        if(root.val>=max){
            return 1+count(root.left, root.val)+count(root.right, root.val);
        }
        return count(root.left, max)+count(root.right, max);
    }
    public int goodNodes(TreeNode root) {
        return count(root, root.val);
    }
}