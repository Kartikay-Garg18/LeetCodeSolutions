class Solution {
    private int bs(int[][] items, int[] pre, int target){
        int st = 0;
        int end = items.length-1;
        int ans = 0;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(items[mid][0]<=target){
                ans = pre[mid];
                st = mid+1;
            } else{
                end = mid-1;
            }
        }
        return ans;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a,b)-> a[0] - b[0]);
        int n = items.length;
        int[] preMax = new int[n];
        preMax[0] = items[0][1];

        for(int i=1; i<n; i++){
            preMax[i] = Math.max(preMax[i-1], items[i][1]);
        }

        for(int i=0; i<queries.length; i++){
            queries[i] = bs(items, preMax, queries[i]);
        }

        return queries;
    }
}