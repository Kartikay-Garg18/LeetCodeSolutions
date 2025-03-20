class Solution {
    int[] parent;

    private int findParent(int x){
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    private void union(int x, int y){
        int parentX = findParent(x);
        int parentY = findParent(y);

        if(parentX == parentY){
            return;
        }

        parent[parentX] = parentY;
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        for(int[] edge : edges){
            union(edge[0], edge[1]);
        }

        int q = query.length;
        int[] ans = new int[q];
        HashMap<Integer, Integer> parentAnd = new HashMap<>();

        for(int i=0; i<n; i++){
            parent[i] = findParent(parent[i]);
        }

        for(int[] edge : edges){
            parentAnd.put(parent[edge[0]], parentAnd.getOrDefault(parent[edge[0]], edge[2]) & edge[2]);
        }


        for(int i=0; i<q; i++){
            int firstParent = parent[query[i][0]];
            int secondParent = parent[query[i][1]];

            if(firstParent != secondParent){
                ans[i] = -1;
            } else{
                ans[i] = parentAnd.get(firstParent);
            }
        }

        return ans;
    }
}