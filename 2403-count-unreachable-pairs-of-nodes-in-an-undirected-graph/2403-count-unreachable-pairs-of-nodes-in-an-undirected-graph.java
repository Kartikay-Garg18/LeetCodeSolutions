class Solution {
    int[] parent;

    private int find(int x){
        return parent[x] = parent[x]==x?x:find(parent[x]);
    }

    private void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py) return;

        if(px<py) parent[py] = px;
        else parent[px] = py;

    }

    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        for(int[] e : edges){
            union(e[0], e[1]);
        }

        for(int i=0; i<n; i++){
            parent[i] = find(parent[i]);
        }

        int i=0;
        int j=0;
        long count = 0;
        Arrays.sort(parent);
        while(i<n){
            int p = parent[j];
            while(j<n && p == parent[j]){
                j++;
            }
            long num = j-i;
            long dec = n-j;
            long mul = (num)*(dec);
            count+=mul;
            i=j;
        }
        return count;
    }
}