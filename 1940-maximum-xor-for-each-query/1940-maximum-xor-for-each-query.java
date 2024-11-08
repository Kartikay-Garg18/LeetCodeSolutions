class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1]^nums[i];
        }
        
        int max = (1<<maximumBit) - 1;
        
        for(int i=0; i<n; i++){
            nums[i] = prefix[n-i-1]^max;
        }

        return nums;
    }
}