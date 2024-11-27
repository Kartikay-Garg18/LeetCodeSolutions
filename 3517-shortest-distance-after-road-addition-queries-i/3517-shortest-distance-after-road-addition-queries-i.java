class Solution {
    int[] routes;
    int[] tor;

    private void dfs(HashMap<Integer, List<Integer>> map, int src, int step){
        tor[src] = step;

        if(step>routes[src]) return;
        
        if(!map.containsKey(src)) return;

        for(int ele : map.get(src)){
            dfs(map, ele, step+1);

            if(tor[ele]<routes[ele]){
                routes[ele] = tor[ele];
            }
        }
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n-1; i++){
            map.computeIfAbsent(i, k -> new ArrayList<>());
            map.get(i).add(i+1);
        }

        routes = new int[n];
        tor = new int[n];
        for(int i=0; i<n; i++){
            routes[i] = i;
            tor[i] = i;
        }

        int[] ans = new int[queries.length];
        int idx = 0;
        for(int[] ele : queries){
            map.get(ele[0]).add(ele[1]);
            dfs(map, 0, 0);
            ans[idx++] = routes[n-1];
        }
        return ans;
    }
}