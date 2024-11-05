class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int sum=0;
        int[] prefix = new int[n+1];
        for(int i=1; i<=n; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        for(int i=1; i<=n; i++){
            nums[i-1] = nums[i-1]*(2*i-n) + prefix[n] - 2*prefix[i];
        }
        return nums;
    }
}