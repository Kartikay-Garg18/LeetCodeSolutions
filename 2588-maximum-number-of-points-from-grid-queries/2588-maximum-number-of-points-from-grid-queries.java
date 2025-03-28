class Solution {

    int[] r = {1, -1, 0, 0};
    int[] c = {0, 0, 1, -1};

    private void bfs(int[][] grid, int[] prefix){
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        boolean[][] dist = new boolean[m][n];
        pq.add(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            if(dist[currRow][currCol]) continue;

            int max = Math.max(curr[2], grid[currRow][currCol]);
            dist[currRow][currCol] = true;
            prefix[max+1]++;
            for(int i=0; i<4; i++){
                int nxtR = currRow + r[i];
                int nxtC = currCol + c[i];

                if(nxtR>=0 && nxtR<m && nxtC>=0 && nxtC<n && !dist[nxtR][nxtC]){
                    pq.add(new int[]{nxtR, nxtC, max});
                }
            }
        }
    }

    public int[] maxPoints(int[][] grid, int[] queries) {
        int max = grid[0][0];

        for(int[] row : grid){
            for(int ele : row){
                max = Math.max(ele, max);
            }
        }

        int[] prefix = new int[max+2];
        bfs(grid, prefix);

        for(int i=1; i<prefix.length; i++){
            prefix[i]+=prefix[i-1];
        }

        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            if(queries[i] > max){
                ans[i] = grid.length*grid[0].length;
            } else{
                ans[i] = prefix[queries[i]];
            }
        }
        
        return ans;
    }
}