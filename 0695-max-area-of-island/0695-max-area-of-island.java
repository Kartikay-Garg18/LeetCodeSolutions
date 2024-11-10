class Solution {
    int[] rows = {0, 1, 0, -1};
    int[] cols = {1, 0, -1, 0};
    public int dfs(int[][] grid, int currRow, int currCol, int m, int n){
        if(currRow<0 ||currRow>=m || currCol<0 || currCol>=n) return 0;
        if(grid[currRow][currCol] == 0) return 0;
        grid[currRow][currCol] = 0;
        int sum = 0;
        for(int i=0; i<4; i++){
            sum+=dfs(grid, currRow+rows[i], currCol+cols[i], m, n);
        }
        return 1+sum;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(grid, i, j, m, n));
                }
            }
        }
        return max;
    }
}