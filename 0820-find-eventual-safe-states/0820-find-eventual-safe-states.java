class Solution {
    int[] dp;
    public boolean find(int[][] graph, int src, boolean[] vis, List<Integer> ans){
        
        if(dp[src]!=-1) return dp[src] == 1;

        if(vis[src]) return false;

        vis[src] = true;

        for(int neigh : graph[src]){
            if(!find(graph, neigh, vis, ans)){
                dp[src] = 0;
                return false;
            }
        }
        
        dp[src] = 1;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        
        dp = new int[n];

        Arrays.fill(dp, -1);

        for(int i=0; i<n; i++){
            if(dp[i] == -1){
                dp[i] = find(graph, i, new boolean[n], ans) ? 1 : 0;
            }
        }

        for(int i=0; i<n; i++){
            if(dp[i] == 1) ans.add(i);
        }

        return ans;
    }
}