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
    int gap = -1;
    int idx = 0;
    public TreeNode helper(String traversal, int level) {
        if(idx == traversal.length()) return null;

        int num = 0;
        while(idx< traversal.length() && traversal.charAt(idx) != '-'){
            num = num*10 + (traversal.charAt(idx) - 48);
            idx++;
        }

        TreeNode root = new TreeNode(num);

        if(idx == traversal.length()) return root;

        int dash = 0;

        while(idx<traversal.length() && traversal.charAt(idx) == '-'){
            dash++;
            idx++;
        }

        if(dash > level){
            root.left = helper(traversal, level+1);
        } else{
            gap = dash;
            return root;
        }

        if(dash == gap){
            root.right = helper(traversal, level+1);
        }

        return root;
    }

    public TreeNode recoverFromPreorder(String traversal) {
        return helper(traversal, 0);
    }
}