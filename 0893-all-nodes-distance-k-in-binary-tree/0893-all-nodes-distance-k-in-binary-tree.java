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
    class Pair{
        TreeNode root;
        int dist;
        public Pair(TreeNode root, int dist){
            this.root = root;
            this.dist = dist;
        }
    }

    public void build(HashMap<Integer, List<TreeNode>> graph, TreeNode root){
        if(root == null) return;
        if(!graph.containsKey(root.val)){
            graph.put(root.val, new ArrayList<>());
        }
        if(root.left!= null && !graph.containsKey(root.left.val)){
            graph.put(root.left.val, new ArrayList<>());
        }
        if(root.right!= null && !graph.containsKey(root.right.val)){
            graph.put(root.right.val, new ArrayList<>());
        }
        if(root.left!=null){
            graph.get(root.val).add(root.left);
            graph.get(root.left.val).add(root);
        }
        if(root.right!=null){
            graph.get(root.val).add(root.right);
            graph.get(root.right.val).add(root);
        }
        build(graph, root.left);
        build(graph, root.right);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer, List<TreeNode>> graph = new HashMap<>();
        List<TreeNode> vis = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        // visited.add(target);
        if(k==0){
            ans.add(target.val);
            return ans;
        }
        build(graph, root);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(target, 0));
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            vis.add(curr.root);
            for(TreeNode neigh : graph.get(curr.root.val)){
                int nxtDist = curr.dist+1;
                if(nxtDist == k && !vis.contains(neigh)){
                    ans.add(neigh.val);
                }
                if(!vis.contains(neigh)){
                    queue.add(new Pair(neigh, nxtDist));
                }
            }
        }
        return ans;
    }
}