class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    int[] r = {0, 0, 1, -1};
    int[] c = {1, -1, 0, 0};

    private void bfs(char[][] grid, int row, int col){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        grid[row][col] = '1';
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i=0; i<4; i++){
                int nr = curr.row + r[i];
                int nc = curr.col + c[i];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc] == 'O'){
                    grid[nr][nc] = '1';
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }

    public void solve(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<n; i++){
            if(grid[0][i] == 'O'){
                bfs(grid, 0, i);
            }
        }

        for(int i=0; i<n; i++){
            if(grid[m-1][i] == 'O'){
                bfs(grid, m-1, i);
            }
        }

        for(int i=0; i<m; i++){
            if(grid[i][0] == 'O'){
                bfs(grid, i, 0);
            }
        }

        for(int i=0; i<m; i++){
            if(grid[i][n-1] == 'O'){
                bfs(grid, i, n-1);
            }
        }


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1') grid[i][j] = 'O';
                else grid[i][j] = 'X';
            }
        }

    }
}