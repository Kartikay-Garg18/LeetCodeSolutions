class Solution {
    static int[] row = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] col = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int helper(int n, int i, int j, int[][][] dp) {
        if(0==n) {
            return dp[i][j][n] = 1;
        }

        if(dp[i][j][n]!=0) return dp[i][j][n];

        int task = 0;
        for(int k=0; k<8; k++){
            int r = i + row[k];
            int c = j + col[k];
            if(r>=0 && c>=0 && r<4 && c<3 && !(r==3 && c==0) && !(r==3 && c==2)){
                dp[i][j][n] += helper(n-1, r, c, dp);
                dp[i][j][n] %= 1_000_000_007;
            }
        }
        return dp[i][j][n];
    }
    public int knightDialer(int n) {
        int count = 0;
        int[][][] dp = new int[10][10][n];
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                if(!(i==3 && j==0) && !(i==3 && j==2)){
                    count += helper(n-1, i, j, dp);
                    count %= 1_000_000_007;
                }
            }
        }
        return count;
    }
}