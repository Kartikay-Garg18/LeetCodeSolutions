class Solution {
    public void bfs(int[][] arr, int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while(!queue.isEmpty()){
            int n = queue.poll();
            arr[n][n] = 0;
            for(int k=0; k<arr[0].length; k++){
                if(arr[n][k] == 1){
                    arr[n][k] = 0;
                    queue.add(k);
                }
            }
        }
    }
    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        int ans = 0;
        for(int i=0;i<n; i++){
            if(arr[i][i] == 1){
                ans++;
                bfs(arr, i);
            }
        }
        return ans;
    }
}