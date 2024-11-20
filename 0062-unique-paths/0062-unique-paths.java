class Solution {
    // public static int countPath(int[][] grid, int row, int col){
    //     if(row==grid.length-1 && col==grid[0].length-1){
    //         return 1;
    //     }
    //     if(row>=grid.length || col>=grid[0].length){
    //         return 0;
    //     }
        
    //     if(grid[row][col]!=-1) return grid[row][col];

    //     grid[row][col] = countPath(grid, row+1, col) + countPath(grid, row, col+1);
    //     return grid[row][col];
    // }

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        // for(int[] ele : grid) Arrays.fill(ele, -1);
        // return countPath(grid, 0, 0);
        Arrays.fill(grid[0], 1);
        for(int i=1; i<m; i++){
            grid[i][0] = 1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }
}