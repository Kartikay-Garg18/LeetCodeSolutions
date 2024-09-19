class Solution {
    public boolean isPartite(int[][] graph, boolean[] vis, int[] color, int src){
        Queue<Integer> queue = new LinkedList<>();
        vis[src] = true;
        queue.add(src);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int neigh : graph[curr]){
                if(!vis[neigh]){
                    vis[neigh] = true;
                    color[neigh] = 1-color[curr];
                    queue.add(neigh);
                } else{
                    if(color[neigh] == color[curr]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        int[] color = new int[n];
        for(int i=0; i<n; i++){
            if(!vis[i] && !isPartite(graph, vis, color, i)){
                return false;
            }
        }
        return true;
    }
}