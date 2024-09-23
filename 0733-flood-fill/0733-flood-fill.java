class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        int original = image[sr][sc];
        fill(image,sr,sc,color,original);
        return image;
    }

    public void fill(int [][] image,int sr,int sc,int color,int orig){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc] != orig){
            return;
        }
        image[sr][sc] = color;
        fill(image,sr+1,sc,color,orig);
        fill(image,sr-1,sc,color,orig);
        fill(image,sr,sc+1,color,orig);
        fill(image,sr,sc-1,color,orig);
    }
}