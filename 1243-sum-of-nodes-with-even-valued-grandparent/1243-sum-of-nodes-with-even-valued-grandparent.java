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
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        if(root.val%2==0){
            sum+=root.left!=null && root.left.left!=null?root.left.left.val:0;
            sum+=root.left!=null && root.left.right!=null?root.left.right.val:0;
            sum+=root.right!=null && root.right.left!=null?root.right.left.val:0;
            sum+=root.right!=null && root.right.right!=null?root.right.right.val:0;
        }
        return sum+sumEvenGrandparent(root.left)+sumEvenGrandparent(root.right);
    }
}