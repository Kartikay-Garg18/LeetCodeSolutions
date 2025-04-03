class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        long diff = 0;
        long max = nums[0];
        for(int num : nums){
            ans = Math.max(ans, diff * num);
            diff = Math.max(diff, max - num);
            max = Math.max(max, num);
        }
        return ans;
    }
}