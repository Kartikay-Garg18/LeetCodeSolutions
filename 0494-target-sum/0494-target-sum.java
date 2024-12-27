class Solution {
    private int find(int[] nums, int target, int i, int sum){
        if(i==nums.length){
            if(sum == target) return 1;
            return 0;
        }
        return find(nums, target, i+1, sum + nums[i]) + find(nums, target, i+1, sum - nums[i]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return find(nums, target, 0, 0);
    }
}