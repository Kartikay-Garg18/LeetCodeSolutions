class Solution {
    public int minOperations(int[][] grid, int x) {

        int[] arr = new int[grid.length * grid[0].length];
        int n = arr.length;
        int[] moves = new int[n];

        int idx = 0;

        for(int[] row : grid){
            for(int ele : row){
                arr[idx++] = ele;
            }
        }

        Arrays.sort(arr);

        int count = 0;
        
        for(int i=0; i<n; i++){
            int diff = arr[i] - arr[0];
            if(diff%x!=0){
                return -1;
            }
            moves[i] = diff/x;
            count+=moves[i];
        }

        int min = count;
        for(int i=1; i<n; i++){
            int sub = ((moves[i] - moves[i-1]) * (n-i));
            int add = ((moves[i] - moves[i-1]) * i);
            count = count - sub + add;
            min = Math.min(min, count);
        }

        return min;
    }
}