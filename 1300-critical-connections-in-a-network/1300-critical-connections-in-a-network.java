class Solution {
    int timer = 1;
    private void dfs(int src, int parent, List<List<Integer>> graph, 
                     boolean[] vis, int[] toi, int[] low, List<List<Integer>> bridge){
        if(vis[src]) return;
        vis[src] = true;
        toi[src] = timer;
        low[src] = timer;
        timer++;
        for(int neigh : graph.get(src)){
            if(neigh!=parent){
                dfs(neigh, src, graph, vis, toi, low, bridge);
                low[src] = Math.min(low[src], low[neigh]);
                if(toi[src]<low[neigh]){
                    bridge.add(Arrays.asList(src, neigh));
                }
            }
        }

    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) graph.add(new ArrayList<>());

        for(List<Integer> edge : connections){
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        System.out.println(graph);
        boolean[] vis = new boolean[n];
        int[] toi = new int[n];
        int[] low = new int[n];

        List<List<Integer>> bridge = new ArrayList<>();
        dfs(0, -1, graph, vis, toi, low, bridge);
        return bridge;
    }
}