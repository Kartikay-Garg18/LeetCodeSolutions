class Solution {
    int[] r = {-1, 0, 1};
    private int helper(int[][] grid, int row, int col, int[][] dp){
        if(dp[row][col]!=0) return dp[row][col];
        for(int i=0; i<3; i++){
            int nxtR = row+r[i];
            int nxtC = col+1;
            if(nxtR>=0 && nxtR<grid.length && nxtC<grid[0].length && grid[row][col] < grid[nxtR][nxtC]){
                dp[row][col] = Math.max(dp[row][col], 1+helper(grid, nxtR, nxtC, dp));
            }
        }
        return dp[row][col];
    }
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for(int i=0; i<m; i++){
            if(dp[i][0] == 0){
                max = Math.max(max, helper(grid, i, 0, dp));
            }
        }
        return max;
    }
}