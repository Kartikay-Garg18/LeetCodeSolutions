class Solution {
    public int search(int[][] matrix, int i, int j, int m, int n, int[][] dp, int par){
        if(i<0 || j<0 || i>=m || j>=n || matrix[i][j]<=par) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int ele = matrix[i][j];
        int left = search(matrix, i, j-1, m, n, dp, ele);
        int right = search(matrix, i, j+1, m, n, dp, ele);
        int up = search(matrix, i-1, j, m, n, dp, ele);
        int down = search(matrix, i+1, j, m, n, dp, ele);
        return dp[i][j] = 1+Math.max(left, Math.max(right, Math.max(up, down)));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] ele : dp) Arrays.fill(ele, -1);
        int max = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                max = Math.max(max, search(matrix, i, j, m, n, dp, -1));
            }
        }
        return max;
    }
}