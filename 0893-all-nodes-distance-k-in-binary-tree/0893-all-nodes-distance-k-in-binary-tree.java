/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();

    private void printKDown(TreeNode root, int k){
        if(root == null || k<0) return;
        if(k== 0){
            list.add(root.val);
            return;
        }
        printKDown(root.left, k-1);
        printKDown(root.right, k-1);
    }
    
    private int printKFar(TreeNode root, TreeNode target, int k){
        if(root == null) return -1;
        if(root == target){
            printKDown(root, k);
            return 0;
        }
        int dl = printKFar(root.left, target, k);
        if(dl != -1){
            if(dl+1 == k){
                list.add(root.val);
            } else{
                printKDown(root.right, k - dl - 2);
            }
            return 1+dl;
        }
        int dr = printKFar(root.right, target, k);
        if(dr!=-1){
            if(dr+1 == k){
                list.add(root.val);
            } else{
                printKDown(root.left, k - dr - 2);
            }
            return 1+dr;
        }
        return -1;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        printKFar(root, target, k);
        return list;
    }
}