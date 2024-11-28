class Solution {
    class Pair{
        int row;
        int col;
        int remove;
        public Pair(int row, int col, int remove){
            this.row = row;
            this.col = col;
            this.remove = remove;
        }
    }

    int[] r = {0, 0, 1, -1};
    int[] c = {1, -1, 0, 0};

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        for(int[] ele : vis) Arrays.fill(ele, (int)1e9);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.remove - b.remove);
        vis[0][0] = grid[0][0];
        pq.add(new Pair(0,0,grid[0][0]));
        while(!pq.isEmpty()){
            int row = pq.peek().row;
            int col = pq.peek().col;
            vis[row][col] = pq.poll().remove;
            for(int i=0; i<4; i++){
                int currRow = row+r[i];
                int currCol = col+c[i];
                if(currRow>=0 && currCol>=0 && currRow<m && currCol<n && vis[currRow][currCol]>vis[row][col]+grid[currRow][currCol]){
                    vis[currRow][currCol] = vis[row][col]+grid[currRow][currCol];
                    pq.add(new Pair(currRow, currCol, vis[currRow][currCol]));
                }
            }
        }
        return vis[m-1][n-1];
    }
}