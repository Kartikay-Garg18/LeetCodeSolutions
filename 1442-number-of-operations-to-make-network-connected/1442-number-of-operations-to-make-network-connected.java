class Solution {
    int[] parent;

    private int find(int x){
        return parent[x] = parent[x] == x ? x : find(parent[x]);
    }

    private int union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py) return 1;

        if(px<py){
            parent[py] = px;
        } else{
            parent[px] = py;
        }
        return 0;
    }
    
    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        int extra = 0;
        for(int[] con : connections){
            extra+=union(con[0], con[1]);
        }
        int comp = 0;
        for(int i=0; i<n; i++){
            if(parent[i] == i) comp++;
        }
        return extra<comp-1?-1:comp-1;
    }
}