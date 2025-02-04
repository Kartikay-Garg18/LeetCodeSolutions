class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[i-1] < nums[i]){
                sum+=nums[i];
            } else{
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}