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

    public void update(Set<TreeNode> list, int sum, HashMap<TreeNode, Integer> map){
        for(TreeNode curr : list){
            int feed = sum-map.get(curr);
            if(curr.left!=null) curr.left.val = feed;
            if(curr.right!=null) curr.right.val = feed;
        }
    }
    
    public TreeNode replaceValueInTree(TreeNode root) {
        HashMap<TreeNode,Integer> map = new HashMap<>();
        int childSum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.add(root);
        queue.add(null);
        Set<TreeNode> list = new HashSet<>();
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr!=null){
                int a = curr.left!=null?curr.left.val:0;
                int b = curr.right!=null?curr.right.val:0;
                map.put(curr, a+b);
                childSum+=a+b;
                if(curr.left!=null){
                    if(curr.left.left!=null || curr.left.right!=null) queue.add(curr.left);
                }
                if(curr.right!=null){
                    if(curr.right.left!=null || curr.right.right!=null) queue.add(curr.right);
                }
                list.add(curr);
            } else{
                update(list, childSum, map);
                childSum=0;
                list.clear();
                if(queue.isEmpty()) break;
                else{
                    queue.add(null);
                }
            }
        }
        return root;
    }
}