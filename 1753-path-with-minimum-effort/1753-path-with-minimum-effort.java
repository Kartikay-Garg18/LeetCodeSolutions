class Solution {
    class Pair{
        int row;
        int col;
        int distance;
        public Pair(int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    int[] r = {0, 0, 1, -1};
    int[] c = {1, -1, 0, 0};

    public int minimumEffortPath(int[][] heights) {
        int[][] vis = new int[heights.length][heights[0].length];
        for(int[] ele : vis) Arrays.fill(ele, (int)1e9);
        vis[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        pq.add(new Pair(0, 0, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.row == heights.length-1 && curr.col == heights[0].length -1) return curr.distance;
            for(int i=0; i<4; i++){
                int row = curr.row + r[i];
                int col = curr.col + c[i];
                if(row>=0 && col>=0 && row<heights.length && col<heights[0].length){
                    int dist = Math.abs(heights[row][col] - heights[curr.row][curr.col]);
                    if(curr.distance<vis[row][col]){
                        vis[row][col] = Math.max(dist, curr.distance);
                        pq.add(new Pair(row, col, vis[row][col]));
                    }
                }
            }
        }
        return 0;
    }
}