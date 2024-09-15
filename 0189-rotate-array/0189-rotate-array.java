class Solution {
    public static void helper(int[] nums, int firstidx, int lastidx){
        while(firstidx<lastidx){
            int temp = nums[firstidx];
            nums[firstidx] = nums[lastidx];
            nums[lastidx] = temp;
            firstidx++;
            lastidx--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        helper(nums, 0, nums.length-k-1);
        helper(nums, nums.length-k, nums.length-1);
        helper(nums, 0, nums.length-1);
    }
}