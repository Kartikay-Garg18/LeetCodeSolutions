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
    public TreeNode reverseOddLevels(TreeNode root) {
        boolean even = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                if(queue.isEmpty()){
                    break;
                } else{
                    if(even){
                        TreeNode[] arr = new TreeNode[queue.size()];
                        for(int i=0; i<arr.length; i++){
                            arr[i] = queue.poll();
                        }
                        for(int i=0; i<arr.length/2; i++){
                            int temp = arr[i].val;
                            arr[i].val = arr[arr.length-i-1].val;
                            arr[arr.length-i-1].val = temp;
                        }
                        for(int i=0; i<arr.length; i++){
                            queue.add(arr[i]);
                        }
                    }
                    even = !even;
                    queue.add(null);
                }
            } else{
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
        }
        return root;
    }
}