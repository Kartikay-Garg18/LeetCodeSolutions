class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        boolean obs = false;
        for(int i=0; i<n; i++){
            if(grid[0][i] == 1) obs = true;
            dp[0][i] = obs?0:1;
        }
        obs = false;
        for(int i=0; i<m; i++){
            if(grid[i][0] == 1) obs = true;
            dp[i][0] = obs?0:1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                } else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}