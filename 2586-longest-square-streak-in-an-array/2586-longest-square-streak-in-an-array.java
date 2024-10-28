class Solution {

    public int binary(int[] nums, int st, int target){
        int end = nums.length-1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid]<target) st = mid+1;
            else end = mid-1;
        }
        return -1;
    }

    public int streak(int[] nums, int i, int[] dp){
        int sq = nums[i]*nums[i];
        int idx = binary(nums, i+1, sq);
        if(idx==-1) return dp[i] = 1;
        return dp[i] = 1 + streak(nums, idx, dp);
    }

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            if(dp[i] == 0){
                max = Math.max(max, streak(nums, i, dp));
            }
        }
        return max==1?-1:max;
    }
}