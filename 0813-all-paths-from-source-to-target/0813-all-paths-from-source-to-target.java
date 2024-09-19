class Solution {
    public void dfs(int[][] graph, List<List<Integer>> ans, int src, int dest, List<Integer> temp){
        // temp.add(src);
        if(src == dest){
            ans.add(new ArrayList<>(temp));
            // temp.remove(temp.size()-1);
            return;
        }
        for(int neigh : graph[src]){
            temp.add(neigh);
            dfs(graph, ans, neigh, dest, temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int dest = graph.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(graph, ans, 0, dest, temp);
        return ans;
    }
}