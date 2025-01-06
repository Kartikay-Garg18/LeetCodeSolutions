class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int init = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int[] pre = new int[n-1];
        int[] suf = new int[n-1];
        for(int i=0; i<n-1; i++){
            pre[i] = Math.max(values[i] + i, init);
            init = pre[i];
        }
        init = Integer.MIN_VALUE;
        for(int i=n-1; i>0; i--){
            suf[i-1] = Math.max(values[i] - i, init);
            init = suf[i-1];
            ans = Math.max(ans, pre[i-1] + suf[i-1]);
        }
        return ans;
    }
}