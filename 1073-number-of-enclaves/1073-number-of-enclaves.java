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

    private void bfs(int[][] grid, int row, int col){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        grid[row][col] = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i=0; i<4; i++){
                int nr = curr.row + r[i];
                int nc = curr.col + c[i];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc] == 1){
                    grid[nr][nc] = 0;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<n; i++){
            if(grid[0][i] == 1){
                bfs(grid, 0, i);
            }
        }

        for(int i=0; i<n; i++){
            if(grid[m-1][i] == 1){
                bfs(grid, m-1, i);
            }
        }

        for(int i=0; i<m; i++){
            if(grid[i][0] == 1){
                bfs(grid, i, 0);
            }
        }

        for(int i=0; i<m; i++){
            if(grid[i][n-1] == 1){
                bfs(grid, i, n-1);
            }
        }

        int cnt = 0;
        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(grid[i][j] == 1) cnt++;
            }
        }

        return cnt;
    }
}