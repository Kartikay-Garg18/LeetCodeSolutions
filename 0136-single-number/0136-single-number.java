class Solution {
    public int singleNumber(int[] nums) {
        int i=0;
        int ans = nums[0];
        while(i<nums.length-1){
            ans^=nums[++i];
        }
        return ans;
    }
}