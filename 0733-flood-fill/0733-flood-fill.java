class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    int[] rows = {1,-1,0,0};
    int[] cols = {0,0,1,-1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orig = image[sr][sc];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        boolean[][] vis = new boolean[image.length][image[0].length];
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int r = curr.row;
            int c = curr.col;
            image[r][c] = color;
            vis[r][c] = true;
            for(int i=0; i<4; i++){
                int nxtR = r + rows[i];
                int nxtC = c + cols[i];
                if(nxtR>=0 && nxtC>=0 && nxtR<image.length && nxtC<image[0].length && image[nxtR][nxtC] == orig && !vis[nxtR][nxtC]){
                    queue.add(new Pair(nxtR, nxtC));
                }
            }
        }
        return image;
    }
}