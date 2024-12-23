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
    private int countSwap(List<Integer> list){
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int ele : list) map.put(ele, idx++);

        List<Integer> temp = new ArrayList<>(list);
        Collections.sort(temp);
        int cnt = 0;
        for(int i=0; i<list.size(); i++){
            if(map.get(temp.get(i)) != i){
                cnt++;
                map.put(list.get(i), map.get(temp.get(i)));
                list.set(map.get(list.get(i)), list.get(i));
                map.put(temp.get(i), i);
                list.set(i, temp.get(i));
                
            }
        }
        return cnt;
    }
    public int minimumOperations(TreeNode root) {
        int swaps = 0;
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                } else{
                    swaps+=countSwap(list);
                    list.clear();
                    q.add(null);
                }
            } else{
                if(curr.left!=null){
                    q.add(curr.left);
                    list.add(curr.left.val);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                    list.add(curr.right.val);
                }
            }
        }
        return swaps;
    }
}