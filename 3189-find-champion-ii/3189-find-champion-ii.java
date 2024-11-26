class Solution {
    int[] parent;

    private int findParent(int x){
        return parent[x] = parent[x] == x ? x : findParent(parent[x]);
    }

    private void union(int src, int des){
        int px = findParent(src);
        int py = findParent(des);
        parent[des] = px;
    }

    public int findChampion(int n, int[][] edges) {
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;

        for(int[] edge : edges){
            union(edge[0], edge[1]);
        }
        
        int ans = -1;
        for(int i=0; i<n; i++){
            if(parent[i] == i){
                if(ans == -1){
                    ans = i;
                } else{
                    return -1;
                }
            }
        }
        return ans;
    }
}