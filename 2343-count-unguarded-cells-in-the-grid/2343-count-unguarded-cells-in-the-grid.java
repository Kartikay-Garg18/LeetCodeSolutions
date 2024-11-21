class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for(int[] g : guards){
            grid[g[0]][g[1]] = 1;
        }
        for(int[] w : walls){
            grid[w[0]][w[1]] = 2;
        }
        for(int i=0; i<m; i++){
            int pick = 2;
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    pick = 1;
                } else if(grid[i][j] == 2){
                    pick = 2;
                } else{
                    if(pick == 1){
                        grid[i][j] = -1;
                    }
                }
            }
        }
        for(int i=0; i<m; i++){
            int pick = 2;
            for(int j=n-1; j>=0; j--){
                if(grid[i][j] == 1){
                    pick = 1;
                } else if(grid[i][j] == 2){
                    pick = 2;
                } else{
                    if(pick == 1){
                        grid[i][j] = -1;
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++){
            int pick = 2;
            for(int j=0; j<m; j++){
                if(grid[j][i] == 1){
                    pick = 1;
                } else if(grid[j][i] == 2){
                    pick = 2;
                } else{
                    if(pick == 1){
                        grid[j][i] = -1;
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            int pick = 2;
            for(int j=m-1; j>=0; j--){
                if(grid[j][i] == 1){
                    pick = 1;
                } else if(grid[j][i] == 2){
                    pick = 2;
                } else{
                    if(pick == 1){
                        grid[j][i] = -1;
                    }
                }
            }
        }
        
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0) count++;
            }
        }
        return count;
    }
}