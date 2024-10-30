class Solution {
   
    public int xorBeauty(int[] nums) {
        int ans=0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            ans^=nums[i];
        }
        return ans;
    }
}