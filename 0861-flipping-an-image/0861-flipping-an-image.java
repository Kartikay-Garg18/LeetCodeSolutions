class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int[][] ans = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ans[i][j] = 1 - image[i][n-j-1];
            }
        }
        return ans;
    }
}