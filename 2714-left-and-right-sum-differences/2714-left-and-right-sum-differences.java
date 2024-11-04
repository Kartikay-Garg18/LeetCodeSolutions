class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int right = 0;
        for(int ele : nums) right+=ele;
        int left = 0;
        for(int i=0; i<n; i++){
            right-=nums[i];
            int diff = Math.abs(left-right);
            left+=nums[i];
            nums[i] = diff;
        }
        return nums;
    }
}