class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int n = nums.length;
        while(right<n){
            sum+=nums[right];
            while(left<=right && sum>=target){
                ans = Math.min(ans, right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        
        while(left<=right && sum>=target){
            ans = Math.min(ans, right-left+1);
            sum-=nums[left];
            left++;
        }

        return ans==Integer.MAX_VALUE?0:ans;
    }
}