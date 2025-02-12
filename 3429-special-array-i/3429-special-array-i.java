class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for(int i=1; i<n; i++){
            int first = nums[i-1]&1;
            int second = nums[i]&1;
            if(first == second){
                return false;
            }
        }
        return true;
    }
}