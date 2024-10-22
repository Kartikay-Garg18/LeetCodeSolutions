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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                if(pq.size()<k){
                    pq.add(sum);
                } else{
                    if(pq.peek()<sum){
                        pq.poll();
                        pq.add(sum);
                    }
                }
                sum = 0;
                if(queue.isEmpty()){
                    break;
                } else{
                    queue.add(null);
                }
            } else{
                sum+=curr.val;
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
        }
        if(pq.size()<k) return -1;
        return pq.peek();
    }
}