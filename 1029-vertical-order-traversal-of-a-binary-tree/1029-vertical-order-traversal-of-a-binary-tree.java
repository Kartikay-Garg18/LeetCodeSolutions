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
    class Pair{
        TreeNode curr;
        int idx;
        int level;
        public Pair(TreeNode curr, int idx, int level){
            this.curr = curr;
            this.idx = idx;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, 0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            TreeNode curr = p.curr;
            List<Integer> l = new ArrayList<>();
            if(!map.containsKey(p.idx)){
                map.put(p.idx, new TreeMap<>());
                map.get(p.idx).put(p.level, new ArrayList<>(l));
            } else{
                if(!map.get(p.idx).containsKey(p.level)){
                    map.get(p.idx).put(p.level, new ArrayList<>(l));
                }
            }
            map.get(p.idx).get(p.level).add(curr.val);
            if(curr.left!=null){
                queue.add(new Pair(curr.left, p.idx-1, p.level+1));
            }
            if(curr.right!=null){
                queue.add(new Pair(curr.right, p.idx+1, p.level+1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int vertical: map.keySet()){
            List<Integer> l = new ArrayList<>();
            for(int key : map.get(vertical).keySet()){
                Collections.sort(map.get(vertical).get(key));
                l.addAll(map.get(vertical).get(key));
            }
            ans.add(new ArrayList<>(l));
        }
        return ans;
    }
}