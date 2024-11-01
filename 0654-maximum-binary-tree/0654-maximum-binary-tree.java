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
    private TreeNode buildTree(int[] nums, int st, int end){
        if(end<st) return null;
        int max = -1;
        int idx = -1;
        for(int i=st; i<=end;i++){
            if(nums[i]>max){
                max = nums[i];
                idx = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = buildTree(nums, st, idx-1);
        root.right = buildTree(nums, idx+1, end);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }
}