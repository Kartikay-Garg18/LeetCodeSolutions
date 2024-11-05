class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] rows = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=1; j<n; j++){
                mat[i][j] += mat[i][j-1];
            }
        }
        
        int[][] ans = new int[m][n];
        int sum = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                sum=0;
                int low = i-k<0?0:i-k;
                int high = i+k>=m?m-1:i+k;
                
                while(low<=high){
                    int minus = j-k-1<0?0:mat[low][j-k-1];
                    int total = j+k>=n?mat[low][n-1]:mat[low][j+k];
                    sum+=(total-minus);
                    low++;
                }

                ans[i][j] = sum;
            }
        }

        return ans;
    }
}